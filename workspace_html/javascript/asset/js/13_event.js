console.log('hello js')

// id btn1을 변수 btn1에 담아서 console.log로 출력
const btn1 = document.querySelector('#btn1')
console.log(1, 'btn1', btn1)

// window.onload = init;
window.addEventListener('load', init)

function init() {
    const btn1 = document.querySelector('#btn1')
    console.log(2, 'btn1', btn1)

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
        if(event.keyCode == 13) {
            log.innerHTML += '<br>엔터 빵!!!!!!!!!!!!!!!!'
        }
        if(event.ctrlKey == true && event.keyCode == 67){
            alert('복사하실라우?')
        }
    })

}




