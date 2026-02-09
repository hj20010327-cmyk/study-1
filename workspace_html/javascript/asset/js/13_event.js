console.log('hello js')

// id btn1을 변수 btn1에 담아서 console.log로 출력
const btn1 = document.querySelector('#btn1')
console.log(1, 'btn1', btn1)

// window.onload = init;
window.addEventListener('load', init)

function init() {
    const btn1 = document.querySelector('#btn1')
    console.log(2, 'btn1', btn1)

    const game = document.querySelector('#game')
    game.style.left = '10px'
    game.style.top = '300px'

    bind()
}
function btn3click() {
    const log = document.querySelector('#console')
    log.innerHTML += '<br>버튼3 클릭'
}

function bind() {
    const log = document.querySelector('#console')

    const btn1 = document.querySelector('#btn1')
    btn1.onclick = function () {
        log.innerHTML += '<br>버튼1 클릭'
    }
    // onclick은 변수라서 하나의 값만 저장된다
    btn1.onclick = function () {
        log.innerHTML += '<br>버튼1 click'
    }

    const btn2 = document.querySelector('#btn2')
    // addEventListener : 동일한 이벤트에 여러 함수를 추가할 수 있다
    btn2.addEventListener('click', function () {
        log.innerHTML += '<br>버튼2 click'
    })
    btn2.addEventListener('click', function () {
        log.innerHTML += '<br>버튼2 click!!!!!!!!!!!!!'
    })

    // 로그인 버튼을 눌렀을 때
    // 아이디와 비밀번호가 비어있지 않다면
    //      아이디, 비밀번호 출력
    // 하나라도 비어있다면
    //      아이디는 필수입니다
    //      비밀번호는 필수입니다 출력

    const id = document.querySelector('#id')
    const pw = document.querySelector('#pw')
    const login = document.querySelector('#login')
    login.addEventListener('click', function () {
        if (id.value.trim() != '' && pw.value.trim().length != 0) {
            log.innerHTML += id.value + '<br>' + pw.value + '<br>'
        } else {
            if (id.value.trim() == '') {
                log.innerHTML += '아이디는 필수입니다<br>'
            }
            if (pw.value.trim() == '') {
                log.innerHTML += '비밀번호는 필수입니다<br>'
            }
        }
    })


    document.querySelector('#id').addEventListener('keydown', function () {
        log.innerHTML += '<br>keydown 발생'
    })
    document.querySelector('#id').addEventListener('keyup', function (event) {
        log.innerHTML += '<br>keyup 발생'
        console.log(event)
        console.log(event.key)
        console.log(event.keyCode)

        console.log(event.shiftKey)
        console.log(event.ctrlKey)
        console.log(event.altKey)
        // 엔터를 누르면
        // "엔터 빵"
        if(event.keyCode == 13) {       // 엔터
            log.innerHTML += '<br>엔터 빵!!!!!!!!!!!!!!!!<br>'
            
            document.querySelector('#pw').focus()
        }
        if(event.ctrlKey == true && event.keyCode == 67){
            alert('복사하실라우?')
        }
    })

    document.querySelector('#pw').addEventListener('keyup', function (event) {
        if(event.keyCode == 13) { 
            document.querySelector('#login').click()  // DOM에 click 발생
        }
    })


    const btn4 = document.querySelector('#btn4')
    btn4.addEventListener('click',btn4click)
    // removeEventListener
    // 이벤트 제거
    // 단, 익명함수는 불가능
    btn4.removeEventListener('click',btn4click)

    document.querySelector('body').addEventListener('keydown',function(event){
        console.log('body event.keyCode :', event.keyCode)

        const game = document.querySelector('#game')
        console.log('game.style.left:', game.style.left)
        if(event.keyCode == 39) {   // 오른쪽
            // game.style.left = '10px'
            // parseInt(game.style.left) // 10  
            // game.style.left.split('px')[0]  // 10
            game.style.left = (parseInt(game.style.left) + 10) + 'px'
        } else if (event.keyCode == 37) {   // 왼쪽
            game.style.left = (parseInt(game.style.left) - 10) + 'px'
        } else if (event.keyCode == 38) {   // 위
            game.style.top = (parseInt(game.style.top) - 10) + 'px'
        } else if (event.keyCode == 40) {   // 아래
            game.style.top = (parseInt(game.style.top) + 10) + 'px'
        }



})
    document.querySelector('#top').addEventListener('click',function(event){
        console.log(document.documentElement.scrollTop)
        // document.documentElement.scrollTop = 0
        window.scrollTo({
            top: 0,
            behavior: 'smooth'
        })

        // 계산 결과가 실시간으로 빠르게 반영되진 않는다
        // let top = document.documentElement.scrollTop
        // while(top > 0){
        //     document.documentElement.scrollTop -= 10
        //     top = document.documentElement.scrollTop
        // }
        
        // 시간에 따라서 setTimeout 대량으로 만들어서
        // 부드럽게 보이길 예상하는
        // for(let i=document.documentElement.scrollTop; i>=0; i-=10){
        //     let delay = 2000 - i
        //     setTimeout(function(){
        //         document.documentElement.scrollTop = i
        //     }, delay)
        // }

    })
}

function btn4click(){
    const log = document.querySelector('#console')
    log.innerHTML += '<br>버튼4 클릭'
}

