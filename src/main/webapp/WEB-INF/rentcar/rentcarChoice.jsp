<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/parts/header.jsp"%>

<div class="reserve-choice">
	<div class="choice-container">
		<div class="reserve-date">
			<span class="firstDay">대여: ${firstMonth}월 ${firstDay}일</span> <span
				class="lastDay">반납: ${lastMonth}월 ${lastDay}일</span> <span
				class="totalDays">대여 기간 총 ${period}일</span>
		</div>

		<form class="filterContainer" id="filterForm">
			<table>
				<tr>
					<td>회사</td>
					<td><label><input type="checkbox" id="company_whole"
							name="company" value="whole"> </label></td>
					<td><label><input type="checkbox" id="company_kia"
							name="company" value="기아"> 기아</label></td>
					<td><label><input type="checkbox" id="company_hyundai"
							name="company" value="현대"> 현대</label></td>
					<td><label><input type="checkbox" id="company_bmw"
							name="company" value="BMW"> BMW</label></td>
				</tr>
				<tr>
					<td>차종</td>
					<td><label><input type="checkbox" id="category_whole"
							name="category" value="whole"> </label></td>
					<td><label><input type="checkbox" id="category_small"
							name="category" value="1"> 소형</label></td>
					<td><label><input type="checkbox" id="category_middle"
							name="category" value="2"> 중형</label></td>
					<td><label><input type="checkbox" id="category_large"
							name="category" value="3"> 대형</label></td>
				</tr>
				<tr>
					<td>인승</td>
					<td><label><input type="checkbox" id="usepeople_whole"
							name="usepeople" value="whole"> </label></td>
					<td><label><input type="checkbox" id="usepeople_5"
							name="usepeople" value="5"> 5인승</label></td>
					<td><label><input type="checkbox" id="usepeople_7"
							name="usepeople" value="7"> 7인승</label></td>
					<td><label><input type="checkbox" id="usepeople_9"
							name="usepeople" value="9"> 9인승</label></td>
				</tr>

			</table>
		</form>

		<div class="carList">
			<div class="carTable">
				<!-- 전체 리스트 js 에서 받아오기 -->
			</div>
		</div>
	</div>

	<form action="${ctx}/rentcarChoice.do" method="post">
		<input type="hidden" id="carNum" name="carNum" value=""> <input
			type="hidden" id="dday" name="dday" value="${period}">

		<div class="result hide">
			<div class="resultCarRow">
				<!-- 선택한 차량 -->
			</div>

			<div class="resultOptionRow">
				<label for="qty">수량 선택:</label> <input type="number" id="qty"
					name="qty" min="1" max="3" value="1"> <input
					type="checkbox" id="usein" name="usein" value="usein"> 운전자
				보험 <input type="checkbox" id="usewifi" name="usewifi"
					value="usewifi"> 무선 인터넷 <input type="checkbox" id="usenavi"
					name="usenavi" value="usenavi"> 네비게이션 <input
					type="checkbox" id="useseat" name="useseat" value="useseat">
				베이비 시트
			</div>
		</div>

		<div class="btn">
			<button type="submit">예약하기</button>
		</div>
	</form>

	<div class="btn">
		<form>
			<button type="button" class="btn-cancel" onclick="history.back()">뒤로가기</button>
		</form>
	</div>

	<script src="${ctx}/script/carFilter.js"></script>
	<script src="${ctx}/script/carChoice.js"></script>
</div>

<%@ include file="/WEB-INF/parts/footer.jsp"%>