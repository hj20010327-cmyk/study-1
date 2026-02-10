window.onload = function () {
    bind()
}
function bind(){
    const id = document.querySelector('.id')
    const pw = document.querySelector('.pw')
    const login = document.querySelector('.login')
    const error = document.querySelector('.error')
    
    
    login.addEventListener('click', function(){
        if(id.value.trim() != '' && pw.value.trim() != ''){
            error.innerHTML = ''
            error.style.display = 'none'
        } else if(id.value.trim() == '' ) {
            error.style.display = 'block'
            error.innerHTML = '아이디 또는 전화번호를 입력해 주세요'
        }
        if (id.value.trim() != '' && pw.value.trim() == '') {
            error.style.display = 'block'
            error.innerHTML = '비밀번호를 입력해 주세요'
        }
    })
}
