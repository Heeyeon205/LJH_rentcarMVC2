<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/parts/header.jsp"%>

<section class="user-delete">
	<form action="${ctx}/userDelete.do" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" id="userid" name="userid" value="${vo.userid}"
					class="id-delete" readonly required></td>
			</tr>

			<tr>
				<td>PW</td>
				<td><input type="password" id="pwd" name="pwd" class="pw-delete"
					required></td>
			</tr>

			<tr>
				<td>
					<button type="submit" class="btn-submit">회원탈퇴</button>
				</td>
				<td>
					<button class="btn-cancel"
						onclick="window.location.href='${ctx}/rentcarMain.jsp'">취소</button>
				</td>
			</tr>
		</table>
	</form>
</section>

<%@ include file="/WEB-INF/parts/footer.jsp"%>

