//pertinent DOM elements
const firstNameInput = document.getElementById('firstName');
const lastNameInput = document.getElementById('lastName');
const phoneNumberInput = document.getElementById('phoneNumber');
const emailInput = document.getElementById('email');
const passwordInput = document.getElementById('password');
const passwordConfirmationInput = document.getElementById('passwordConfirmation');
const helpText = document.getElementById('helpText');
const createAccountBtn = document.getElementById('createAccountBtn');

let isValidInput = false;
const phoneRegEx = /\(\d{3}\)\s\d{3}-\d{4}/;
const emailRegEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
const passwordRegEx =  /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9])(?=.{8,})/;
const border_unaffected = '1px solid rgb(103, 103, 103)';
const border_error = '1px solid red';
const border_pass = '1px solid rgb(0, 88, 40)';

//checks validity of input
function validateInput() {
    //get rid of bullets
    let childLi = helpText.lastElementChild;
    while(childLi) {
        helpText.removeChild(childLi);
        childLi = helpText.lastElementChild;
    }

    let errorMsg = '';
    isValidInput = true;

    //validate phone number
    if(phoneNumberInput.value === '') phoneNumberInput.style.border = border_unaffected;
    else if(phoneRegEx.exec(phoneNumberInput.value)) {
        phoneNumberInput.style.border = border_pass;
    } else {
        phoneNumberInput.style.border = border_error;
        isValidInput = false;
        errorMsg = errorMsg + '|Phone Number should be of the form: (###) ###-####\n';
    }

    //email
    if(emailInput.value === '') {
        emailInput.style.border = border_unaffected;
        isValidInput = false;
    } else if(emailRegEx.exec(emailInput.value)) {
        emailInput.style.border = border_pass;
    } else {
        emailInput.style.border = border_error;
        errorMsg = errorMsg + '|Email Address is invalid.\n';
        isValidInput = false;
    }

    //password
    if(passwordInput.value === '') {
        passwordInput.style.border = border_unaffected;
        isValidInput = false;
    } else if(passwordRegEx.exec(passwordInput.value)) {
        passwordInput.style.border = border_pass;
    } else {
        passwordInput.style.border = border_error;
        errorMsg = errorMsg + '|Password needs at least 1 lowercase letter|Password needs 1 uppercase letter|Password needs at least one digit|Password needs at least one special character|Password needs to be at least 8 characters long\n';
        isValidInput = false;
    }

    if(passwordConfirmationInput.value === '' && passwordInput.value === '') {
        passwordConfirmationInput.style.border = border_unaffected;
    } else if(passwordConfirmationInput.value === passwordInput.value) {
        passwordConfirmationInput.style.border = border_pass;
    } else {
        passwordConfirmationInput.style.border = border_error;
        errorMsg = errorMsg + '|Confirmation password must match password';
        isValidInput = false;
    }

    //append items to helpText
    errors = errorMsg.split('|');
    errors.forEach((element, index) => {
        if(index === 0) return; // this is because every error *starts* with a |
        const li = document.createElement('li');
        li.innerText = element;
        helpText.appendChild(li);
    });

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
            window.location.replace('/home');
        } else alert('error');
    });
}
