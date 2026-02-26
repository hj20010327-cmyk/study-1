/* ================================
 * 0) App Shell (Header/LNB)
 * ================================ */

// DOM Ready 시 실행
$(() => {
  // 전역 AppShell: 공통 UI 초기화 컨테이너
  window.AppShell = {
    state: {},

    // 헤더 로드 후 콜백
    initHeader: () => console.log("[AppShell] header init"),

    // LNB 로드 후 콜백
    initLnb: () => console.log("[AppShell] lnb init"),

    // 공통 load 함수
    load: (sel, url, cb) => $(sel).load(url, cb)
  };

  // 헤더 로드
  AppShell.load("#header", "./partials/header.html", AppShell.initHeader);

  // LNB 로드
  AppShell.load("#lnb", "./partials/lnb.html", AppShell.initLnb);
});


/* ================================
 * 1) Storage DB Core
 * ================================ */

window.DBKEY = {
  properties:    "jungseoks_childs.db.properties",
  rooms:         "jungseoks_childs.db.rooms",
  members:       "jungseoks_childs.db.members",
  reviews:       "jungseoks_childs.db.reviews",
  reservations:  "jungseoks_childs.db.reservations",
  searches:      "jungseoks_childs.db.searches",
  tags:          "jungseoks_childs.db.tags",
  wishlist:      "jungseoks_childs.db.wishlist" // 찜
};

// localStorage JSON 로드
const _load = (key, fallback = []) =>
  JSON.parse(localStorage.getItem(key) || JSON.stringify(fallback));

// localStorage JSON 저장
const _save = (key, rows) =>
  localStorage.setItem(key, JSON.stringify(rows));

// 공통 페이지네이션
const _paginate = (rows, page = 1, pageSize = 20) => {
  const total = rows.length;
  const pages = Math.max(1, Math.ceil(total / pageSize));
  const p = Math.min(Math.max(1, page), pages);
  const start = (p - 1) * pageSize;
  return { page: p, pageSize, total, pages, items: rows.slice(start, start + pageSize) };
};

// 전역 DB 유틸
window.DB = {
  // table 조회
  get: (key, fallback = []) => _load(key, fallback),

  // table 저장
  set: (key, rows) => _save(key, rows),

  // paginate
  paginate: (rows, page, pageSize) => _paginate(rows, page, pageSize),

  // URL 파라미터
  param: (k) => new URL(location.href).searchParams.get(k)
};


/* ================================
 * 2) Property Index (캐시/집계)
 * ================================ */

window.PropertyIndex = (() => {
  let CACHE = null; // enriched properties 캐시

  // 리뷰 집계: propertyId -> {sum,cnt}
  const buildReviewAgg = (reviews) => {
    const map = {};
    for (const r of reviews) {
      const pid = r.propertyId;
      if (!pid) continue;
      (map[pid] ??= { sum: 0, cnt: 0 }).sum += (+r.rating || 0);
      map[pid].cnt += 1;
    }
    return map;
  };

  // 태그 맵: propertyId -> tags[]
  const buildTagsMap = (rows) => {
    const map = {};
    for (const x of rows) {
      if (x.propertyId) map[x.propertyId] = x.tags || [];
    }
    return map;
  };

  // 찜 set: memberId -> Set(propertyId)
  const buildWishSet = (wishlistRows, memberId) => {
    if (!memberId) return null;
    return new Set(wishlistRows.filter(x => x.memberId === memberId).map(x => x.propertyId));
  };

  // 캐시 빌드(또는 리빌드)
  const build = ({ memberIdForWish = null } = {}) => {
    const props    = DB.get(DBKEY.properties, []);
    const reviews  = DB.get(DBKEY.reviews, []);
    const tagsRows = DB.get(DBKEY.tags, []);
    const wishRows = DB.get(DBKEY.wishlist, []);

    const agg     = buildReviewAgg(reviews);
    const tagsMap = buildTagsMap(tagsRows);
    const wishSet = buildWishSet(wishRows, memberIdForWish);

    CACHE = props.map(p => {
      const a = agg[p.propertyId] || { sum: 0, cnt: 0 };
      const avg = a.cnt ? a.sum / a.cnt : 0;

      return {
        ...p,
        _reviewAvg: avg,                        // 평균 별점
        _reviewCnt: a.cnt,                      // 리뷰 수
        _tags: tagsMap[p.propertyId] || [],     // 태그 배열
        _wish: wishSet ? wishSet.has(p.propertyId) : false, // 찜 여부
        _price: p.minRoomPrice ?? p.priceFrom ?? 0          // 정렬용 가격
      };
    });

    return CACHE;
  };

  // 캐시 반환 (없으면 생성)
  const get = (opts = {}) => {
    if (!CACHE) build(opts);
    return CACHE;
  };

  // 캐시 초기화
  const reset = () => { CACHE = null; };

  return { build, get, reset };
})();


/* ================================
 * 3) Property API (필터/정렬/조회)
 * ================================ */

window.PropertyAPI = (() => {

  // 정렬
  const sortRows = (rows, sort = "reco") => {
    const r = [...rows];
    if (sort === "rating")      r.sort((a,b) => b._reviewAvg - a._reviewAvg);
    else if (sort === "reviewCount") r.sort((a,b) => b._reviewCnt - a._reviewCnt);
    else if (sort === "priceAsc")    r.sort((a,b) => a._price - b._price);
    else if (sort === "priceDesc")   r.sort((a,b) => b._price - a._price);
    else if (sort === "reco")  r.sort((a,b) => (b._reviewCnt*0.7 + b._reviewAvg) - (a._reviewCnt*0.7 + a._reviewAvg));
    return r;
  };

  // 메인 쿼리
  const query = ({
    city, district,
    minRating, maxRating,
    onlyWishlistedByMemberId,
    hasFacilities,
    tagIncludes,
    keyword,
    sort = "reco",
    page = 1, pageSize = 20
  } = {}) => {

    // wish 필터를 쓰면, wishSet 포함해서 캐시를 빌드해야 함
    const rows0 = PropertyIndex.get({ memberIdForWish: onlyWishlistedByMemberId });

    let rows = rows0;

    // 지역 필터
    if (city) rows = rows.filter(p => p.city === city);
    if (district) rows = rows.filter(p => p.district === district);

    // 별점 필터
    if (minRating != null) rows = rows.filter(p => p._reviewAvg >= minRating);
    if (maxRating != null) rows = rows.filter(p => p._reviewAvg <= maxRating);

    // 찜 필터
    if (onlyWishlistedByMemberId) rows = rows.filter(p => p._wish);

    // 편의시설 필터
    if (Array.isArray(hasFacilities) && hasFacilities.length) {
      rows = rows.filter(p => {
        const f = p.facilities || {};
        return hasFacilities.every(k => !!f[k]);
      });
    }

    // 태그 필터
    if (Array.isArray(tagIncludes) && tagIncludes.length) {
      rows = rows.filter(p => tagIncludes.every(t => (p._tags || []).includes(t)));
    }

    // 키워드 필터
    if (keyword && keyword.trim()) {
      const q = keyword.trim().toLowerCase();
      rows = rows.filter(p =>
        (p.name || "").toLowerCase().includes(q) ||
        (p.address || "").toLowerCase().includes(q) ||
        (p.city || "").toLowerCase().includes(q) ||
        (p.district || "").toLowerCase().includes(q)
      );
    }

    // 정렬
    rows = sortRows(rows, sort);

    // 페이지네이션 결과 리턴
    return DB.paginate(rows, page, pageSize);
  };

  // 지역 리스트
  const listCities = () => {
    const rows = PropertyIndex.get();
    return [...new Set(rows.map(p => p.city).filter(Boolean))].sort();
  };

  // 구 리스트
  const listDistricts = (city) => {
    const rows = PropertyIndex.get();
    return [...new Set(rows.filter(p => p.city === city).map(p => p.district).filter(Boolean))].sort();
  };

  // 도시별 카운트
  const countByCity = () => {
    const rows = PropertyIndex.get();
    return rows.reduce((m,p)=>((m[p.city]??=0), m[p.city]++, m), {});
  };

  // 숙소 단건
  const getProperty = (propertyId) =>
    DB.get(DBKEY.properties, []).find(p => p.propertyId === propertyId) || null;

  // 숙소별 객실
  const listRoomsByProperty = (propertyId) =>
    DB.get(DBKEY.rooms, []).filter(r => r.propertyId === propertyId);

  // 숙소별 리뷰
  const listReviews = ({ propertyId, page=1, pageSize=10, sort="latest" } = {}) => {
    let rows = DB.get(DBKEY.reviews, []).filter(r => r.propertyId === propertyId);
    if (sort === "latest") rows.sort((a,b) => (b.createdAt||"").localeCompare(a.createdAt||""));
    if (sort === "rating") rows.sort((a,b) => (+b.rating||0) - (+a.rating||0));
    return DB.paginate(rows, page, pageSize);
  };

  // 별점 요약
  const getRatingSummary = (propertyId) => {
    const rows = PropertyIndex.get();
    const p = rows.find(x => x.propertyId === propertyId);
    return { avg: p?._reviewAvg || 0, count: p?._reviewCnt || 0 };
  };

  // 찜 토글
  const toggleWish = (memberId, propertyId) => {
    const rows = DB.get(DBKEY.wishlist, []);
    const idx = rows.findIndex(x => x.memberId===memberId && x.propertyId===propertyId);
    if (idx >= 0) rows.splice(idx, 1);
    else rows.push({ memberId, propertyId, createdAt: new Date().toISOString() });
    DB.set(DBKEY.wishlist, rows);

    // 캐시 reset (wish 반영 위해)
    PropertyIndex.reset();

    return idx < 0; // true면 찜됨
  };

  // 찜 목록
  const listWishlist = ({ memberId, page=1, pageSize=20 } = {}) => {
    const res = query({ onlyWishlistedByMemberId: memberId, page, pageSize, sort:"reco" });
    return res;
  };

  // 검색어 로그 기록
  const logSearch = ({ memberId=null, keyword, city=null, createdAt=new Date().toISOString() }) => {
    const rows = DB.get(DBKEY.searches, []);
    const id = (crypto?.randomUUID?.() || ("S_"+Date.now()));
    rows.push({ id, memberId, keyword, city, createdAt });
    DB.set(DBKEY.searches, rows);
    return id;
  };

  // 검색어 로그 조회
  const listSearches = ({ memberId, keyword, page=1, pageSize=50 } = {}) => {
    let rows = DB.get(DBKEY.searches, []);
    if (memberId) rows = rows.filter(x => x.memberId === memberId);
    if (keyword) {
      const q = keyword.toLowerCase();
      rows = rows.filter(x => (x.keyword||"").toLowerCase().includes(q));
    }
    rows.sort((a,b) => (b.createdAt||"").localeCompare(a.createdAt||""));
    return DB.paginate(rows, page, pageSize);
  };

  // 외부에서 쓰는 API 묶음
  return {
    query,
    listCities,
    listDistricts,
    countByCity,
    getProperty,
    listRoomsByProperty,
    listReviews,
    getRatingSummary,
    toggleWish,
    listWishlist,
    logSearch,
    listSearches,

    // 캐시 리프레시(데이터 넣은 뒤 1회 호출)
    refresh: () => PropertyIndex.build()
  };
})();


/* ================================
 * 4) 콘솔에서 바로 JSON 뽑기 예시 (한 줄 주석)
 * ================================ */

// console.log(PropertyAPI.query({ city:"서울", minRating:4, sort:"rating", page:1, pageSize:10 })); // 서울 & 별점>=4 & 별점순 & 10개 페이징
// console.log(PropertyAPI.listCities()); // 전체 도시 목록
// console.log(PropertyAPI.listDistricts("서울")); // 서울의 구 목록
// console.log(PropertyAPI.countByCity()); // 도시별 숙소 수 집계
// console.log(PropertyAPI.getProperty("P_1001")); // 숙소 1건 조회 (propertyId)
// console.log(PropertyAPI.listRoomsByProperty("P_1001")); // 해당 숙소의 객실 목록
// console.log(PropertyAPI.listReviews({ propertyId:"P_1001", sort:"latest", page:1, pageSize:5 })); // 숙소 리뷰 최신 5개
// console.log(PropertyAPI.getRatingSummary("P_1001")); // 숙소 별점 요약(avg/count)
// console.log(PropertyAPI.toggleWish("M_1","P_1001")); // 찜 토글(추가/해제) 후 true/false 반환
// console.log(PropertyAPI.listWishlist({ memberId:"M_1", page:1, pageSize:20 })); // 내 찜 목록 페이징
// console.log(PropertyAPI.logSearch({ memberId:"M_1", keyword:"바다뷰", city:"부산" })); // 검색어 로그 저장 후 id 반환
// console.log(PropertyAPI.listSearches({ memberId:"M_1", page:1, pageSize:20 })); // 내 검색어 로그 목록
// console.log((PropertyAPI.refresh(), "refreshed")); // 데이터 변경 후 캐시 재빌드