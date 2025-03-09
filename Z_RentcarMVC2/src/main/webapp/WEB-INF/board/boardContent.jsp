<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/parts/header.jsp"%>


<div class="reserve-img">
	<a href="">이미지 넣을거임</a>
</div>


<table class="contentTable">
	<form action="${ctx}/boardUpdate.do" method="post">
		<input type="hidden" id="writer" name="writer" value="${writer}">
		<input type="hidden" id="subject" name="subject" value="${subject}">
		<input type="hidden" id="contents" name="contents" value="${contents}">
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" id="writer"
				value="${writer}" readonly></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject" id="subject"
				value="${subject}" readonly></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="contents" id="contents" readonly>${contents}</textarea>
			</td>
		</tr>
		<tr>
			<c:if test="${writer eq userid}">
				<td colspan="2">
					<button type="submit">수정하기</button>
				</td>
			</c:if>
			<td colspan="2">
				<form>
					<button onclick="history.back()">뒤로가기</button>
				</form>
			</td>
		</tr>
	</form>
</table>

<%@ include file="/WEB-INF/parts/footer.jsp"%>