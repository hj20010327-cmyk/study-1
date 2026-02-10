window.onload = function () {
    bind()
}
function bind(){
    const address = document.querySelector('.address')
    const tel = document.querySelector('.tel')
    const copy = document.querySelector('.copy')
    const cadd = document.querySelector('.caddress')
    const ctel = document.querySelector('.ctel')

    copy.addEventListener('change', function(){
        if(copy.checked){
            cadd.value = address.value
            ctel.value = tel.value
        } else {
            cadd.value = ''
            ctel.value = ''
        }
    })


    
}
