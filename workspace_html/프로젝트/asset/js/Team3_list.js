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
    const q = PropertyAPI.query({ city:"서울"}).items
    // const y = 
    // console.log(y)

    console.log(q)
    function setActive(target) {
        recomand.classList.remove('active');
        low.classList.remove('active');
        high.classList.remove('active');

        target.classList.add('active');
    }

    recomand.addEventListener('click', () => {
        setActive(recomand);
        hotel_cards.innerHTML = ''



        
        
        
    })
    
    low.addEventListener('click', () => {
        setActive(low)
        const sort = [...q].sort((a,b)=> a.priceFrom - b.priceFrom)
        // console.log(sort)
        hotel_cards.innerHTML = ''
        sort.forEach((item) => {
            
            hotel_cards.innerHTML += `
            <a href="./Team3_detail.html" class="hotel-card">
            <div class="hotel-card">
                <img src="${item.thumbnail}">
                <div class="hotel-info">
                    <h3>${item.name}</h3>
                    <p class="location">${item.city} · 매우 좋음 (750개 이용후기)</p>
                    <div class="tags">
                        <span>${item.amenities}</span>
                    </div>
                </div>
                <div class="price-box">
                    <div class="price">₩${item.priceFrom}</div>
                    <button>예약하기</button>
                </div>
                </div>
                </a>
            `
        })

    })
    high.addEventListener('click', () => {
        setActive(high)
        hotel_cards.innerHTML = ''


    })

    const detail = document.querySelector('.price-box')

    



}