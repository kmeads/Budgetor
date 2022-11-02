//pertinent DOM elements
const firstNameInput = document.getElementById('firstNameInput');
const lastNameInput = document.getElementById('lastNameInput');
const phoneNumberInput = document.getElementById('phoneNumberInput');
const emailInput = document.getElementById('emailInput');
const passwordInput = document.getElementById('passwordInput');
const passwordConfirmationInput = document.getElementById('passwordConfirmationInput');
const inputElements = document.querySelectorAll('signUpFormInputs');
const helpText = document.getElementById('helpText');
const createAccountBtn = document.getElementById('createAccountBtn');

let isValidInput = false;
const phoneRegEx = /\(\d{3}\)\s\d{3}-\d{4}/;
const emailRegEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
const passwordRegEx =  /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9])(?=.{8,})/;

//checks validity of input
function validateInput() {
    let errorMsg = '';
    isValidInput = true;

    //validate phone number
    if(phoneNumberInput.value === '') phoneNumberInput.style.border = 'none';
    else if(phoneRegEx.exec(phoneNumberInput.value)) {
        phoneNumberInput.style.border = '1px solid green';
    } else {
        phoneNumberInput.style.border = '1px solid red';
        isValidInput = false;
        errorMsg = errorMsg + 'Phone number is invalid. Make sure it is of the form: (###) ###-####\n';
    }

    //email
    if(emailInput.value === '') {
        emailInput.style.border = 'none';
        isValidInput = false;
    } else if(emailRegEx.exec(emailInput.value)) {
        emailInput.style.border = '1px solid green';
    } else {
        emailInput.style.border = '1px solid red';
        errorMsg = errorMsg + 'Email Address is invalid.\n';
        isValidInput = false;
    }

    //password
    if(passwordInput.value === '') {
        passwordInput.style.border = 'none';
        isValidInput = false;
    } else if(passwordRegEx.exec(passwordInput.value)) {
        passwordInput.style.border = '1px solid green';
    } else {
        passwordInput.style.border = '1px solid red';
        errorMsg = errorMsg + 'Password needs at least 1 lowercase letter, 1 uppercase letter, one digit, one special character and be at least 8 characters long\n';
        isValidInput = false;
    }

    if(passwordConfirmationInput.value === '' && passwordInput.value === '') {
        passwordConfirmationInput.style.border = 'none';
    } else if(passwordConfirmationInput.value === passwordInput.value) {
        passwordConfirmationInput.style.border = '1px solid green';
    } else {
        passwordConfirmationInput.style.border = '1px solid red';
        errorMsg = errorMsg + 'Confirmation password must match password';
        isValidInput = false;
    }

    helpText.innerText = errorMsg;
    if(isValidInput) {
        createAccountBtn.disabled = false;
        createAccountBtn.classList.add('popAnimation');
    } else {
        createAccountBtn.disabled = true;
        createAccountBtn.classList.remove('popAnimation');
    }
}

async function createAccount() {
    if(!isValidInput) return;
    let creationDate = new Date().toISOString().slice(0, 19).replace('T', ' ');

    //send data to backend
    await fetch('http://localhost:8080/api/user', {
        method: 'POST',
        headers: {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
        },
        body: JSON.stringify({
            email: emailInput.value,
            password: passwordInput.value,
            first_name: firstNameInput.value,
            last_name: lastNameInput.value,
            phone_number: phoneNumberInput.value,
            account_creation_date: creationDate,
            password_changed_date: creationDate,
            is_account_locked: false
        })
    }).then(response => {
        if(response.ok) {
            alert('created');
        } else alert('error');
    });
}