<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/parts/header.jsp"%>

<section class="login">
	<form action="${ctx}/userLogin.do" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" id="id" name="id" class="id-input" required></td>
			</tr>

			<tr>
				<td>PW</td>
				<td><input type="password" id="pw" name="pw" class="pw-input" required></td>
			</tr>

			<tr>
				<td>
					<button type="submit" class="btn-submit">확인</button>
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

