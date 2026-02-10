window.onload = function () {
    bind()
}
function bind() {
    
    const size = document.querySelectorAll('.size input')
    const btn = document.querySelector('.btn')
    const topping = document.querySelectorAll('.topping input')
    const dou = document.querySelectorAll('.dou input')
    const pr = document.querySelector('.price')
    
    btn.addEventListener('click',function(event){
        let receipt = ''
        let price = 0;
            for(let i=0; i<size.length; i++) {
                if(size[i].checked){
                    price += parseInt(size[i].value)
                    receipt += "사이즈: "+ size[i].getAttribute('size')
                    break
                }
            }
            for(let i=0; i<dou.length; i++){
                if(dou[i].checked){
                    receipt += " 도우: " + dou[i].getAttribute('value')
                    console.log(dou[i].innerText)
                }
            }
            for(let i=0; i<topping.length; i++){
                if(topping[i].checked){
                    price += parseInt(topping[i].value)
                    receipt += " 토핑: "+ topping[i].getAttribute('name')+" "
                }
            }
            pr.innerText = price + '원 ' + receipt
            console.log(receipt)
            console.log(price)

        })
    
    
    
    
    }