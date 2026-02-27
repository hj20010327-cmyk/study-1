window.addEventListener('load', bind)
function bind() {

    // 필터 영역
    const price = document.querySelector('.out')
    const range = document.querySelector('.r')

    function render() {
        // const v = Number(range.value);
        // price.textContent = '₩ ' + v.toLocaleString('ko-KR');

        let num = range.value
        let money = "" + num;
        let result = "";

        while (money.length > 3) {
            result = "," + money.substring(money.length - 3) + result;
            money = money.substring(0, money.length - 3);
        }
        result = money + result;

        price.textContent = '₩ ' + result
    }

    // console.log((PropertyAPI.refresh(), "refreshed"));
    range.addEventListener('input', function () {
        render();

    })

    // 정렬 탭
    const recomand = document.querySelector('.recomand');
    const low = document.querySelector('.low');
    const high = document.querySelector('.high');
    const hotel_cards = document.querySelector('.hotel-cards');
    const xhr = new XMLHttpRequest();
    
    let items = [];
    xhr.open('get', 'http://116.36.205.25:15180/api/v1/lodging/properties?city=%EC%84%9C%EC%9A%B8&sort=rating&order=desc&limit=10&offset=0')
    
    xhr.onload = function () {
        const q = JSON.parse(xhr.responseText);
        items = q.items;
        
        render(items);          
        setActive(recomand); 
        console.log(q)
    }
    xhr.send()
    // console.log(q)
    function setActive(target) {
        recomand.classList.remove('active');
        low.classList.remove('active');
        high.classList.remove('active');
        
        target.classList.add('active');
    }
    function render1(list) {
        hotel_cards.innerHTML = '';

        list.forEach((item) => {
            hotel_cards.innerHTML += `
               <div class="hotel-card">
                <a href="./Team3_detail.html">
                <img src="${item.thumbnail}">
                <div class="hotel-info">
                <h3>${item.name}</h3>
                <p class="location">${item.city} · 별점: ${item.rating}</p>
                <div class="tags">
                <span>기타 편의시설</span>
                </a>
                </div>
                </div>
                <div class="price-box">
                <div class="price">₩${item.priceFrom}</div>
                <a href="#" class="reser-search-btn">예약하기</a>
                <button class="select">찜하기</button>
                <span>🤍</span>
                </div>
                </div>
            `;
        });
    }
    recomand.addEventListener('click', () => {
        setActive(recomand);
        render1(items);
    });

    // 낮은 가격순
    low.addEventListener('click', () => {
        setActive(low);
        const sorted = [...items].sort((a, b) => a.priceFrom - b.priceFrom);
        render1(sorted);
    });

    // 높은 가격순
    high.addEventListener('click', () => {
        setActive(high);
        const sorted = [...items].sort((a, b) => b.rating - a.rating);
        render1(sorted);
    });
    // recomand.addEventListener('click', () => {
    //     setActive(recomand);
    //     hotel_cards.innerHTML = ''
        
        
        
        
        
        
    // })
    
    // low.addEventListener('click', () => {
    //         console.log(JSON.parse(xhr.responseText))
    //         setActive(low)
    //         const sort = [...q.items].sort((a, b) => a.priceFrom - b.priceFrom)
    //         // console.log(sort)
    //         hotel_cards.innerHTML = ''
    //         sort.forEach((item) => {
                
    //             hotel_cards.innerHTML += `
                // <div class="hotel-card">
                // <a href="./Team3_detail.html">
                // <img src="${item.thumbnail}">
                // <div class="hotel-info">
                // <h3>${item.name}</h3>
                // <p class="location">${item.city} · 매우 좋음 (750개 이용후기)</p>
                // <div class="tags">
                // <span>${item.amenities[1]}</span>
                // <span>${item.amenities[2]}</span>
                // <span>${item.amenities[3]}</span>
                // <span>...</span>
                // </a>
                // </div>
                // </div>
                // <div class="price-box">
                // <div class="price">₩${item.priceFrom}</div>
                // <a href="#" class="reser-search-btn">예약하기</a>
                // <button class="select">찜하기</button>
                // <span>🤍</span>
                // </div>
                // </div>
    //             `
                
    //         })
        

    // })
    // high.addEventListener('click', () => {
    //     setActive(high)
    //     hotel_cards.innerHTML = ''


    // })

    const filter_button = document.querySelector('.filter-search-btn')
    filter_button.addEventListener('click', () => {
        alert('필터적용 기능은 준비중입니다')
    })


}
