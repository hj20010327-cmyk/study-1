window.addEventListener('load', bind)
function bind() {

    // 필터 영역
    const price_range = document.querySelector('.price-range')
    const side_range_value = document.querySelector('.side-range__value')

    function render(){
        let num = price_range.value
        let money = "" + num;
        let result = "";

        while (money.length > 3) {
            result = "," + money.substring(money.length-3) + result;
            money = money.substring(0, money.length-3);
        }
        result = money + result;
        side_range_value.textContent = '₩ ' + result
    }

    price_range.addEventListener('input', ()=>{
        render();
    })

    const side_apply = document.querySelector('.side-apply')
    const side_box = document.querySelector('.side_box')
    const result_grid = document.querySelector('.result-grid')
    const recomand = document.querySelector('.recomand')
    const low = document.querySelector('.low')
    const high = document.querySelector('.high')


    side_apply.addEventListener('click',()=>{

        // 제이슨에서 필터의 값같이

    })

    const select = document.querySelector('.select')

    select.addEventListener('change',()=>{
        if(select.value == recomand.textContent){

            render1(items);
        }
    })

    function setActive(target) {
    
    }


    function render1(list) {
        result_grid.innerHTML = '';

        list.forEach((item)=>{
            result_grid.innerHTML += `
            <article class="card">
                            <div class="card__media">
                                <img src="https://images.unsplash.com/photo-1542314831-068cd1dbfeeb?auto=format&fit=crop&w=1400&q=80"
                                    alt="시티뷰 럭셔리 호텔" />

                                <!-- 왼쪽 상단 배지 -->
                                <span class="badge badge--dark">할인 중</span>

                                <!-- 오른쪽 상단 찜(하트) -->
                                <button class="wish" type="button" aria-label="찜하기">
                                    <svg viewBox="0 0 24 24" class="heart" aria-hidden="true">
                                        <path d="M12 21.35l-1.45-1.32C5.4 15.36 2 12.28 2 8.5
                             2 6 4 4 6.5 4
                             8.04 4 9.54 4.81 10.4 6.09
                             11.26 4.81 12.76 4 14.3 4
                             16.8 4 18.8 6 18.8 8.5
                             c0 3.78-3.4 6.86-8.55 11.54L12 21.35z" />
                                    </svg>
                                </button>
                            </div>

                            <div class="card__body">
                                <div class="card__title">모던 시티뷰 호텔</div>
                                <div class="card__meta">서울 · 강남구</div>

                                <div class="card__row">
                                    <div class="card__rating">
                                        <span class="star">★</span> 4.8 <span class="count">(512)</span>
                                    </div>
                                    <div class="card__price">
                                        ₩189,000 <span>/ 박</span>
                                    </div>
                                </div>

                                <div class="card__tags">
                                    <span class="tag">무료 취소</span>
                                    <span class="tag">조식 포함</span>
                                    <span class="tag">피트니스</span>
                                </div>

                                <a href="#" class="card__btn">객실 보기</a>
                            </div>
                        </article>
            `
        })
    }




    const xhr = new XMLHttpRequest();
    let items = [];
    const url = 'http://116.36.205.25:15180/api/v1/lodging/properties?city=%EC%84%9C%EC%9A%B8&sort=rating&order=desc&limit=10&offset=0'
    xhr.open('get', url)

    xhr.onload = function () {
        const q = JSON.parse(xhr.responseText);
        items = q.items;

        
        
    }


}