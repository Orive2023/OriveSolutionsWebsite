// let menu = document.querySelector('#menu-icon');
// let navbar = document.querySelector('.navbar');

// menu.onclick = () =>{
//     menu.classList.toggle('bx-x');
//     navbar.classList.toggle('active');
// }

// window.onscroll = () =>{
//     menu.classList.remove('bx-x');
//     navbar.classList.remove('active'); 
// }

// const sr = ScrollReveal({
//     distance:'60px',
//     duration:2500,
//     delay:400,
//     reset:true
// })

// sr.reveal('.text',{delay: 20,origin:'top'})
// sr.reveal('.form-container form',{delay: 30,origin:'left'})
// sr.reveal('.heading',{delay: 20,origin:'top'})
// sr.reveal('.ride-container .box',{delay: 30,origin:'top'})
// sr.reveal('.services-container .box',{delay: 30,origin:'top'})
// sr.reveal('.about-container .box',{delay: 30,origin:'top'})
// sr.reveal('.reviews-container',{delay: 30,origin:'top'})
// sr.reveal('.newsletter .box',{delay: 30,origin:'bottom'})

function updateTime() {
    const dateElement = document.getElementById('currentDateTime');
    const now = new Date();
    const formattedTime = now.toLocaleString(undefined, {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit',
        second: '2-digit'
    });
    const dayOfWeek = now.toLocaleString('en-us', { weekday: 'long' });
    dateElement.innerText = `${formattedTime} (${dayOfWeek})`;
}

setInterval(updateTime, 1000); // Update every second (1000 milliseconds)