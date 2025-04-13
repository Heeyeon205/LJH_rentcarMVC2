<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/parts/header.jsp"%>

<div class="inquiry-container">
	<h1>문의 하기</h1>
	<form action="${ctx}/boardInsert.do" method="post">
		<table class="inserTable">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" id="writer"
					value="${userid}" readonly></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" id="subject" required></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="contents" id="contents" required></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit" class="btn-submit">작성 완료</button>
				</td>
				<td colspan="2">
					<button type="button" class="btn-cancel" onclick="history.back()">뒤로가기</button>
				</td>
			</tr>
		</table>
	</form>
</div>


<%@ include file="/WEB-INF/parts/footer.jsp"%>