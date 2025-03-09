document.addEventListener("DOMContentLoaded", function() {
    const carTable = document.querySelector(".carTable");
    const selectCar = document.querySelector(".result");
    const resultCarRow = document.querySelector(".resultCarRow");
    const carNumInput = document.querySelector("#carNum");

    // 차량 리스트가 동적으로 로드되므로 이벤트 위임 사용
    carTable.addEventListener("click", function(event) {
        const carRow = event.target.closest(".carRow"); // .carRow 클래스를 가진 행 찾기
        if (!carRow) return; // 클릭한 요소가 carRow가 아니면 종료

        const result = confirm("해당 차량으로 선택하시겠습니까?");
        if (result) {
            const selectedCarNum = carRow.dataset.carNum; // data-car-num 속성에서 차량 번호 가져오기
            if (!selectedCarNum) {
                console.error("차량 번호를 찾을 수 없습니다.");
                return;
            }

            console.log("선택한 차량 번호: ", selectedCarNum);
            carNumInput.value = selectedCarNum; // hidden input에 차량 번호 저장
            console.log("hidden input 값: ", carNumInput.value);

            // 선택한 차량 정보 표시 (안전하게 처리)
            resultCarRow.innerHTML = ''; // 기존 내용 지우기
            const carInfo = document.createElement("div");
            carInfo.textContent = carRow.textContent; // 텍스트만 복사 (보안 강화)
            resultCarRow.appendChild(carInfo);

            console.log("선택한 차량 정보: ", resultCarRow.innerHTML);
            selectCar.classList.remove("hide"); // 결과 영역 표시
        }
    });
});