document.addEventListener('DOMContentLoaded', function() {
    fetch(window.ctx + "/rentcarFilter.do", {
        method: 'post',
        body: new FormData()
    })
    .then(response => response.json())
    .then(data => {
        const carList = document.querySelector('.carTable');
        carList.innerHTML = "";
        data.forEach(car => {
            carList.innerHTML += `
                <div class="carRow" data-car-num="${car.num}">
                    <span>[${car.company}] ${car.name}</span> 
                    <span>${car.price}원</span> 
                    <span>${car.usepeople}인승</span>
                </div>`;
        });
    })
    .catch(error => console.error("초기 로드 오류", error));

    document.querySelector('.filterContainer').addEventListener('change', function(e) {
        const formData = new FormData(document.getElementById('filterForm'));

        const companyWhole = document.getElementById('company_whole');
        const categoryWhole = document.getElementById('category_whole');
        const usepeopleWhole = document.getElementById('usepeople_whole');
        const companyChecks = document.querySelectorAll('input[name="company"]:not(#company_whole)');
        const categoryChecks = document.querySelectorAll('input[name="category"]:not(#category_whole)');
        const usepeopleChecks = document.querySelectorAll('input[name="usepeople"]:not(#usepeople_whole)');

        if (companyWhole.checked) {
            companyChecks.forEach(check => check.checked = false);
            companyChecks.forEach(check => check.disabled = true);
        } else {
            companyChecks.forEach(check => check.disabled = false);
        }
        if (categoryWhole.checked) {
            categoryChecks.forEach(check => check.checked = false);
            categoryChecks.forEach(check => check.disabled = true);
        } else {
            categoryChecks.forEach(check => check.disabled = false);
        }
        if (usepeopleWhole.checked) {
            usepeopleChecks.forEach(check => check.checked = false);
            usepeopleChecks.forEach(check => check.disabled = true);
        } else {
            usepeopleChecks.forEach(check => check.disabled = false);
        }

        fetch(window.ctx + "/rentcarFilter.do", {
            method: 'post',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            const carList = document.querySelector('.carTable');
            carList.innerHTML = "";
            data.forEach(car => {
                carList.innerHTML += `
                    <div class="carRow" data-car-num="${car.num}">
                        <span>[${car.company}] ${car.name}</span> 
                        <span>${car.price}원</span> 
                        <span>${car.usepeople}인승</span>
                    </div>`;
            });
        })
        .catch(error => console.error("필터링 오류 발생", error));
    });
});