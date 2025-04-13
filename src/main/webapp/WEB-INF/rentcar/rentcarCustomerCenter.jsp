<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/parts/header.jsp"%>

<div class="customerCenterContainer">
	<div class="centerHeader">
		<h1>자주 묻는 질문</h1>
		<p>궁금해하시는 질문들을 모아 보았어요</p>
	</div>

	<div class="centerSearch">
		<!-- 시간 있으면 개발 -->
		<input type="text">
		<button>검색</button>
	</div>

	<div class="board">
		<table>
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td><i class="fa-solid fa-q"></i></td>
					<td><a href="${ctx}/boardContent.do?no=${board.getNo()}">${board.getSubject()}</a></td>
					<td>${board.getWriter()}</td>
					<c:if test="${log eq '관리자'}">
						<td colspan="2">
							<form action="${ctx}/boardDelete.do" method="post">
								<input type="hidden" name="no" value="${board.getNo()}">
								<button class="btn-del">삭제</button>
							</form>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>

		<div class="pageingBtn">
			<c:if test="${startPage > 1}">
				<a href="${ctx}/rentcarCustomerCenter.do?page=${startPage - 1}">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="${ctx}/rentcarCustomerCenter.do?page=${i}">${i}</a>
			</c:forEach>

			<c:if test="${endPage < totalPages}">
				<a href="${ctx}/rentcarCustomerCenter.do?page=${endPage + 1}">[다음]</a>
			</c:if>
		</div>

		<div class="inquireBtn">
			<a href="${ctx}/boardInsert.do">문의하기</a>
		</div>

	</div>

</div>

<%@ include file="/WEB-INF/parts/footer.jsp"%>