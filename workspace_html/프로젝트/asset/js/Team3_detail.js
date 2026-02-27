window.addEventListener('load', bind)
function bind() {
    const xhr = new XMLHttpRequest();
    let items = [];
    xhr.open('get', 'http://116.36.205.25:15180/api/v1/lodging/properties?city=%EB%B6%80%EC%82%B0&sort=rating&order=desc&page=1&pageSize=10&minRating=4&facilitiesAll=wifi%2Cparkin')
    
    xhr.onload = function () {
        const q = JSON.parse(xhr.responseText);
        items = q.items;
        
        // render(items);          
        // setActive(recomand); 
        console.log(q)
    }
    xhr.send()

    const room = document.querySelector('.room')
    const amenities = document.querySelector('.amenities')
    const reviews = document.querySelector('.reviews')
    const location = document.querySelector('.loc')


    function setActive(target) {
        room.classList.remove('active');
        amenities.classList.remove('active');
        reviews.classList.remove('active');
        location.classList.remove('active');

        target.classList.add('active');
    }

    room.addEventListener('click',()=>{
        setActive(room)
    })
    amenities.addEventListener('click',()=>{
        setActive(amenities)
    })
    reviews.addEventListener('click',()=>{
        setActive(reviews)
    })
    location.addEventListener('click',()=>{
        setActive(location)
    })
}