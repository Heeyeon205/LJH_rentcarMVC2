<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/parts/header.jsp"%>

<div class="reserve-main">
	<h2>대여 날짜를 선택해주세요</h1><hr>
	<div class="calendar-container">
		<div class="calendarHeader">
			<button class="left-btn"><</button>
			<p class="calTitle">달력 불러오는 중</p>
			<button class="right-btn">></button>
		</div>
		<table class="calendar" border="1">
			<tbody>
				<tr class="week">
					<td class="day">일</td>
					<td class="day">월</td>
					<td class="day">화</td>
					<td class="day">수</td>
					<td class="day">목</td>
					<td class="day">금</td>
					<td class="day">토</td>
				</tr>

				<tr>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
				</tr>
				<tr>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
				</tr>
				<tr>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
				</tr>
				<tr>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
				</tr>
				<tr>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
				</tr>
				<tr>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
					<td class="calendar-days" role="button"></td>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="btn">
		<form action="${ctx}/rentcarReservation.do" method="post">
			<input type="hidden" id="firstDay" name="firstDay"
				value="${firstDay}"> <input type="hidden" id="firstMonth"
				name="firstMonth" value="${firstMonth}"> <input
				type="hidden" id="lastDay" name="lastDay" value="${lastDay}">
			<input type="hidden" id="lastMonth" name="lastMonth"
				value="${lastMonth}"> <input type="hidden" id="period"
				name="period" value="${period}">
			<button type="submit">차량 선택하기</button>
		</form>
	</div>


	<script src="${ctx}/script/calendar.js"></script>
</div>

<%@ include file="/WEB-INF/parts/footer.jsp"%>
