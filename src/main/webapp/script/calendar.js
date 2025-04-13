class Calendar {
	constructor(year, month) {
		this.year = year;
		this.month = month;
		this.today = new Date();
		this.selectedDays = [];

		this.initDOM();
		this.fillCalendar();
		this.addEventListeners();
	}

	initDOM() {
		this.calDays = document.querySelectorAll('.calendar-days');
		this.calTitle = document.querySelector('.calTitle');
		this.leftBtn = document.querySelector('.left-btn');
		this.rightBtn = document.querySelector('.right-btn');
	}

	getFirstDay() {
		return new Date(this.year, this.month, 1).getDay();
	}

	getLastDay() {
		const wholeDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
		if ((this.year % 4 === 0 && this.year % 100 !== 0) || (this.year % 400 === 0)) {
			wholeDays[1] = 29;
		}
		return wholeDays[this.month];
	}

	clearCalendar() {
		this.calDays.forEach((day) => (day.innerHTML = ""));
	}

	fillCalendar() {
		this.clearCalendar();

		this.calTitle.innerText = `${this.year}년 ${this.month + 1}월`;

		const firstDay = this.getFirstDay();
		const lastDay = this.getLastDay();
		let day = 1;

		this.calDays.forEach((cell, idx) => {
			if (idx >= firstDay && day <= lastDay) {
				const currentDate = new Date(this.year, this.month, day);
				const today = new Date();
				today.setHours(0, 0, 0, 0);

				if (currentDate < today) {
					cell.innerHTML = `<button class="dayBtn disabled" disabled>${day}</button>`;
				} else {
					cell.innerHTML = `<button class="dayBtn">${day}</button>`;
				}

				const btn = cell.querySelector(".dayBtn");
				if (this.selectedDays.length > 0) {
					if (currentDate.getTime() === this.selectedDays[0]?.getTime() ||
						currentDate.getTime() === this.selectedDays[1]?.getTime()) {
						btn.classList.add("selected");
						btn.style.backgroundColor = '#808080';
						btn.style.color = 'white';
					} else if (this.selectedDays.length === 2 &&
						currentDate > this.selectedDays[0] &&
						currentDate < this.selectedDays[1]) {
						btn.classList.add("range");
						btn.style.backgroundColor = '#C0C0C0';
					}
				}
				day++;
			}
		});
		this.selectDay();
	}

	changeMonth(step) {
		this.month += step;
		if (this.month < 0) {
			this.year--;
			this.month = 11;
		} else if (this.month > 11) {
			this.year++;
			this.month = 0;
		}
		this.calTitle.innerText = `${this.year}년 ${this.month + 1}월`;
		this.fillCalendar();
	}

	addEventListeners() {
		this.leftBtn.addEventListener("click", () => this.changeMonth(-1));
		this.rightBtn.addEventListener("click", () => this.changeMonth(+1));
	}

	selectDay() {
		const dayBtns = document.querySelectorAll(".dayBtn:not(.disabled)");
		dayBtns.forEach((btn) => {
			btn.removeEventListener('click', this.handleDayClick);
			btn.addEventListener('click', this.handleDayClick.bind(this));
		});
	}

	handleDayClick(e) {
		this.selectPeriod(e.target);
	}

	selectPeriod(selectDay) {
		const selectedDate = new Date(this.year, this.month, parseInt(selectDay.innerText));

		if (this.selectedDays.length === 2) {
			this.selectedDays = [];
			this.fillCalendar();
		}
		if (this.selectedDays.length === 1 && this.selectedDays[0].getTime() === selectedDate.getTime()) {
			alert("최소 2일 이상 선택해야 합니다.");
			return;
		}

		this.selectedDays.push(selectedDate);
		selectDay.classList.add('selected');
		selectDay.style.backgroundColor = '#808080';
		selectDay.style.color = 'white';

		if (this.selectedDays.length === 1) {
			this.disablePreviousDates(selectedDate);
		}
		if (this.selectedDays.length === 2) {
			this.fillCalendar();
			this.updateReserve();
		}
	}

	disablePreviousDates(firstSelectedDate) {
		document.querySelectorAll(".dayBtn:not(.disabled)").forEach((btn) => {
			const btnDate = new Date(this.year, this.month, parseInt(btn.innerText));
			if (btnDate < firstSelectedDate) {
				btn.classList.add("disabled");
				btn.disabled = true;
				btn.style.backgroundColor = "#E0E0E0"; 
				btn.style.color = "#999";
				btn.style.cursor = "not-allowed";
			}
		});
	}

	updateReserve() {
		const firstDay = this.selectedDays[0];
		const lastDay = this.selectedDays[1];

		const inputFirstDay = document.getElementById('firstDay');
		const inputFirstMonth = document.getElementById('firstMonth');
		const inputLastDay = document.getElementById('lastDay');
		const inputLastMonth = document.getElementById('lastMonth');
		const inputPeriod = document.getElementById('period');

		inputFirstDay.value = firstDay.getDate();
		inputFirstMonth.value = firstDay.getMonth() + 1;
		inputLastDay.value = lastDay.getDate();
		inputLastMonth.value = lastDay.getMonth() + 1;

		const periodValue = Math.ceil((lastDay - firstDay) / (1000 * 60 * 60 * 24)) + 1;
		inputPeriod.value = periodValue;
	}
}

document.addEventListener("DOMContentLoaded", () => {
	const today = new Date();
	const cal = new Calendar(today.getFullYear(), today.getMonth());
});