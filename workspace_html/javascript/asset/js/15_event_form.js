window.addEventListener('load', function () {

    const log = document.querySelector('#log')

    window.addEventListener('resize', function () {
        const w = window.innerWidth;
        const h = window.innerHeight;

        log.innerHTML = `<br>너비:${w}, 높이:${h}` + log.innerHTML;
    })

    const id = document.querySelector('#id')
    id.addEventListener('focus', function () {
        id.style.backgroundColor = 'yellow'
    })
    id.addEventListener('blur', function () {
        id.style.backgroundColor = ''
    })
    id.addEventListener('input', function () {
        const r = parseInt(Math.random() * 256)
        const g = parseInt(Math.random() * 256)
        const b = parseInt(Math.random() * 256)
        const a = Math.random()

        id.style.backgroundColor = `rgba(${r},${g},${b},${a})`
    })

    const site = document.querySelector('#site')
    const form = document.querySelector('#form')
    site.addEventListener('change', () => {
        console.log(site.value)

        if (site.value == 1) {
            form.setAttribute('action', "https://search.naver.com/search.naver")
            id.setAttribute('name', 'query')
        } else if (site.value == 2) {
            form.setAttribute('action', "https://www.google.com/search")
            id.setAttribute('name', 'query')
        } else if (site.value == 3) {
            form.setAttribute('action', "https://maplescouter.com/ko/info")
            id.setAttribute('name', 'name')
        }
    })

    form.addEventListener('submit', function (event) {

        // html 태그의 고유(기본) 기능을 막아준다
        // 여기서는 submit의 기능을 막음
        event.preventDefault()

        // 검색어가 두글자 이하면
        if (id.value.length < 2) {
            alert('검색어는 두글자 이상입니다')
        } else {
            form.submit()
        }
    })

    addEventListener('copy', function (event) {
        event.preventDefault()
        alert('복사금지')
    })
    addEventListener('selectstart', function (event) {
        event.preventDefault()
    })

    document.querySelector('#parent')
        .addEventListener('click', function (event) {
            console.log('부모 클릭')

            // event.target : 실제 이벤트가 발생한 DOM
            console.log('event.target', event.target)

            // event.currentTarget : 이벤트가 적용되어 있는 DOM
            console.log('event.currentTarget', event.currentTarget)

            console.log('this', this)
            console.log('this', this === event.currentTarget)
            // 화살표arrow 함수인 경우 this를 변경하지 않음
            // 즉 this === window 상태


            // }, true)
        })

    document.querySelector('#child1')
        .addEventListener('click', function (event) {
            // 전파 방지
            // 부모로 전달되는 이벤트 중지
            // event.stopPropagation()

            console.log('자식1 클릭')
        })

    // 같이 해보자
    // 1. table 태그에 클릭 이벤트 주기
    // 2. click된 dom을 출력
    // 3. DOM.classList.contains('chk')로
    // 4. checkbox일 경우만 value 출력

    // const table = document.querySelector('table')
    // table.addEventListener('click', function (event) {
    //     console.log(event.target)
    //     console.log(event.target.classList.contains('chk'))
    //     if (event.target.classList.contains('chk')) {
    //         console.log(event.target.value)
    //     }

    //     // 5. 제목을 클릭했을 때만 내용을 출력
    //     if(event.target.classList.contains('title')){
    //         console.log(event.target.innerText)
    //         console.log(event.target.textContent)
    //     }
    // })
    // 6. 이제 table에 위임하지 않고
    // tr에 위임하게 해주세요
    const trs = document.querySelectorAll('#board tr')
    for (let i = 0; i < trs.length; i++) {
        trs[i].addEventListener('click', function (event) {

            // 7. 무조건 제목의 내용이 출력되게
            console.log(event.currentTarget.querySelector('.title').textContent)

            // 8. checkbox를 클릭했을 때는 제목이 나오지 않게
            // if (!(event.target.classList.contains('chk'))) {
            //     console.log(event.currentTarget.querySelector('.title').textContent)
            // }

        })

        trs[i].querySelector('.chk')
            .addEventListener('click', function (event) {
                event.stopPropagation()

                // 부모로 이동
                console.log('this.parentNode',this.parentNode)
                console.log('this.parentNode.parentNode',this.parentNode.parentNode)

                // 9. checkbox를 클릭했을 때 그 줄의 제목을 출력하시오
                console.log(this.parentNode.parentNode.querySelector('.title').innerText)
        })
    }





})


console.log('밖에서 this', this)
console.log('밖에서 window', this === window)
// 문제2
// 피자 주문
// 피자 종류 선택 select
//    치즈피자, 불고기피자, 페퍼로니피자, 콤비네이션피자
// 사이즈 선택 radio
//    small(18000), medium(20000), large(22000)
// 도우 엣지 선택 radio
//    thin(0), 치즈(0), 고구마(0), 에그타르트(0), 소보로(0)
// 토핑 checkbox
//    감자(2000), 올리브(500), 페퍼로니(1000), 
//    고구마(2000), 새우(5000), 베이컨(3000), 파인애플(500) 
// [확인] 버튼 클릭 시
// 문제 2-1 : 총액 출력
// 문제 2-2 : 선택 내역과 총액 출력

// 문제3
// 주문과 배송
// 주문 정보 : 이름, 주소
// 배송 정보 : 이름, 주소
//      - ㅁ 주문 정보와 배송 정보가 같습니다
// 체크하면 주문 정보가 배송 정보로 복사
// 체크 풀면 배송 정보 초기화

// 문제4
// 인기상품순, 낮은가격순, 높은가격순, 신상품순 메뉴에서
// 클릭한 것만 굵은 글씨로 유지

// 문제5
// 썸네일이 있는 쇼핑몰
// 썸네일에 마우스 올리면 
// 썸네일의 이미지를 오른쪽에 크게 보여준다
