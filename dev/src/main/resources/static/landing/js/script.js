//header log in Btn
const logInBtn = document.getElementById('logInBtn');
const logInWrapper = document.getElementById('logInWrapper');

logInBtn.addEventListener('click', () => {
    logInWrapper.classList.toggle('visible');
});