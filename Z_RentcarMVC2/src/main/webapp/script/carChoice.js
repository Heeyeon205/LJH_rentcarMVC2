document.addEventListener("DOMContentLoaded", function() {
	const carTable = document.querySelector(".carTable");
	const selectCar = document.querySelector(".result");
	const resultCarRow = document.querySelector(".resultCarRow");
	const carNumInput = document.querySelector("#carNum");

	carTable.addEventListener("click", function(event) {
		const carRow = event.target.closest(".carRow");
		if (!carRow) return;

		const result = confirm("해당 차량으로 선택하시겠습니까?");
		if (result) {
			const selectedCarNum = carRow.dataset.carNum;
			if (!selectedCarNum) {
				console.error("차량 번호를 찾을 수 없습니다.");
				return;
			}

			carNumInput.value = selectedCarNum;

			resultCarRow.innerHTML = '';
			const carInfo = document.createElement("div");
			carInfo.textContent = carRow.textContent;
			resultCarRow.appendChild(carInfo);
			selectCar.classList.remove("hide");
		}
	});
});