<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/parts/header.jsp"%>

<div class="reserve-main">

	<div class="reserve-img">
		<a href="">이미지 넣을거임</a>
	</div>

	<div class="calendar-container">
		<button class="left-btn"><</button>
		<p class="calTitle">달력 불러오는 중</p>
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
		<button class="right-btn">></button>
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
