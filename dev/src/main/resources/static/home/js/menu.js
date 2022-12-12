const menu_toggle = document.getElementById('menu-toggle');

menu_toggle.addEventListener('click', () => {
    document.body.classList.toggle('menu-open');
    if(document.body.classList.contains('menu-open')) {
        menu_toggle.textContent = 'Close Menu';
        menu_toggle.style.color = 'white';
    }
    else {
        menu_toggle.textContent = 'Menu';
        menu_toggle.style.color = "black";
    }
});
