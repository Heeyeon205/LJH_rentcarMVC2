<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/parts/header.jsp"%>

<section class="login">
	<form action="${ctx}/userUpdate.do" method="post">
		<table>

			<tr>
				<td>Name</td>
				<td><input type="text" id="name" name="name" value="${vo.name}"
					class="name-info" readonly required></td>
			</tr>

			<tr>
				<td>ID</td>
				<td><input type="text" id="id" name="id" value="${vo.userid}"
					class="id-info" readonly required></td>
			</tr>

			<tr>
				<td>PW</td>
				<td><input type="password" id="pw" name="pw" value="${vo.pwd}"
					class="pw-info" readonly required></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="email" id="email" name="email"
					value="${vo.email}" class="email-info" required></td>
			</tr>

			<tr>
				<td>Phone</td>
				<td><input type="text" id="phone" name="phone"
					value="${vo.phone}" class="phone-info" required></td>
			</tr>

			<tr>
				<td>
					<button type="submit" class="btn-submit">수정</button>
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

