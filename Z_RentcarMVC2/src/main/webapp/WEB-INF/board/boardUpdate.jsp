<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/parts/header.jsp"%>


<div class="reserve-img">
	<a href="">이미지 넣을거임</a>
</div>


<table class="inserTable">
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
				<button onclick="history.back()">뒤로가기</button>
			</form>
		</td>
	</tr>
	</form>
</table>

<%@ include file="/WEB-INF/parts/footer.jsp"%>