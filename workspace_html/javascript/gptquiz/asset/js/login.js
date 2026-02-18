window.onload = function(){
    bind()
}

function bind(){

    const login = document.querySelector('.login')
    const id = document.querySelector('.id')
    const pw = document.querySelector('.pw')
    const err = document.querySelector('.error')

    
    login.addEventListener('click', function(event){
        // console.log(id.value.indexOf('@') )
        // let idx = id.value.indexOf('@')
        
        // 이메일 형식인지 보기
        if (id.value.indexOf('@') < 1) {
            err.innerHTML = '이메일 형식이 아닙니다'
        } else if(id.value.trim() == '') {
            err.innerHTML = '아이디를 입력해주세요'
        } else{
            err.innerHTML = ''
        }
        if(pw.value.length > 0 && pw.value.length < 8) {
            err.innerHTML = '비밀번호는 8자리 이상입니다'
        } else if(pw.value.length == 0) {
            err.innerHTML = '비밀번호를 입력해주세요'
        }


    })


}