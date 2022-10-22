//header log in Btn
const logInBtn = document.getElementById('logInBtn');
const logInWrapper = document.getElementById('logInWrapper');

logInBtn.addEventListener('click', () => {
    logInWrapper.classList.toggle('visible');
});

const feedback = document.getElementById('feedback');
feedback.style.color = "red";

const emailInput = document.getElementById('emailLogInInput');
const passwordInput = document.getElementById('passwordLogInInput');
const submitLogInBtn = document.getElementById('submitLogInBtn');

submitLogInBtn.addEventListener('click', async () => {
    await fetch (
        `http://localhost:8080/api/user?email=${emailInput.value}&password=${passwordInput.value}`
    ).then(response => {
        if(response.ok) { //response 200
            
            logInWrapper.classList.remove('visible');
        } else
            alert('Error in validating account');
        passwordInput.value = '';
    });
});