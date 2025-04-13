<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/parts/header.jsp"%>

<div class="ReservationList-container">
	<table class="reserveList">
	<h1>내 예약 정보</h1>
		<tr class="listInfo">
			<td>예약 번호</td>
			<td>차량 번호</td>
			<td>예약자 ID</td>
			<td>예약 대수</td>
			<td>랜트 기간</td>
			<td>렌트 일</td>
			<td>운전자 보험 가입 여부</td>
			<td>와이파이 신청 여부</td>
			<td>네비게이션 신청 여부</td>
			<td>아기 의자 신청 여부</td>
		</tr>
		<c:forEach var="reserve" items="${list}">
			<tr>
				<td>${reserve.reserve_seq}</td>
				<td>${reserve.num}</td>
				<td>${reserve.userid}</td>
				<td>${reserve.qty}</td>
				<td>${reserve.dday}</td>
				<td>${reserve.rday}</td>
				<td>${reserve.usein == 1 ? "O" : "X"}</td>
				<td>${reserve.usewifi == 1 ? "O" : "X"}</td>
				<td>${reserve.usenavi == 1 ? "O" : "X"}</td>
				<td>${reserve.useseat == 1 ? "O" : "X"}</td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@ include file="/WEB-INF/parts/footer.jsp"%>