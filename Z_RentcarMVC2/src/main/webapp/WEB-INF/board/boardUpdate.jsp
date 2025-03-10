<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/parts/header.jsp"%>

<table class="updateTable">
	<tr>
		<td>
			<h1>문의글 수정하기</h1>
		<td>
	</tr>
	<form action="${ctx}/boardUpdate.do" method="post">
	<tr>
		<td>작성자</td>
		<td><input type="text" name="writer" id="writer"
			value="${writer}" readonly></td>
	</tr>
	<tr>
		<td>제목</td>
		<td>
			<input type="text" name="newSubject" id="newSubject" value="${subject}" required>
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea name="newContents" id="newContents" required> </textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="submit">수정하기</button>
		</td>

		<td colspan="2">
			<form>
				<button type="button" onclick="history.back()">뒤로가기</button>
			</form>
		</td>
	</tr>
	</form>
</table>

<%@ include file="/WEB-INF/parts/footer.jsp"%>