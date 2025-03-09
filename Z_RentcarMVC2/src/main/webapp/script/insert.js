let isIdValid = 0;
const form = document.querySelector('#userForm');
const idInput = document.querySelector('#userid');
const checkIdButton = document.querySelector('#checkId');

form.addEventListener('submit', (event) => {
    event.preventDefault();
    if (isIdValid !== 1) {
        alert('먼저 아이디 중복 확인을 해주세요');
        idInput.focus();
        return;
    }
    if (validateAll()) {
        form.submit();
    }
});

checkIdButton.addEventListener('click', async () => {
    const id = idInput.value.trim();

    if (!id) {
        alert('ID를 입력해주세요');
        idInput.focus();
        return;
    }

    try {
       const response = await fetch(`${window.ctx}/validIdAjax.do`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
            },
            body: new URLSearchParams({ id }).toString(),
        });

        const result = await response.text();
        handleIdValidationResult(result);
    } catch (error) {
        console.error('ID 확인 오류:', error);
        alert('아이디 확인 중 오류가 발생했습니다');
    }
});

function handleIdValidationResult(result) {
    const message = result.trim();
    if (message === 'valid') {
        alert('이 아이디는 사용 가능합니다');
        idInput.style.border = '2px solid green';
        idInput.setAttribute('readonly', 'true');
        isIdValid = 1;
    } else if (message === 'notValid') {
        alert('이 아이디는 사용 불가능합니다');
        idInput.style.border = '2px solid red';
        idInput.value = '';
        idInput.focus();
        isIdValid = -1;
    }
}

function validateAll() {
    const inputs = form.querySelectorAll('input');
    let isValid = true;
    inputs.forEach(input => {
        if (!validateField(input)) {
            isValid = false;
        }
    });
    return isValid && isIdValid === 1;
}

function validateField(input) {
    const value = input.value.trim();
    let isValid = true;
    let message = '';

    if (!value) {
        message = `${input.name}을 입력해주세요`;
        isValid = false;
    } else {
        if (input.name === 'phone') {
            const phonePattern = /^01[016789]-?\d{3,4}-?\d{4}$/;
            if (!phonePattern.test(value)) {
                message = '유효한 휴대폰 번호를 입력해주세요 (예: 010-1234-5678)';
                isValid = false;
            }
        }
    }

    input.style.border = isValid ? '1px solid green' : '1px solid red';
    showError(input, message);
    return isValid;
}


function showError(input, message) {
    let errorElement = input.nextElementSibling;
    if (!errorElement || !errorElement.classList.contains('error-message')) {
        errorElement = document.createElement('div');
        errorElement.classList.add('error-message');
        input.parentNode.insertBefore(errorElement, input.nextSibling);
    }
    errorElement.textContent = message;
    errorElement.style.color = 'red';
}