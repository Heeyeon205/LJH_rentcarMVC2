<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/parts/header.jsp"%>

<section class="insert">
	<form id="userForm" action="${ctx}/userInsert.do" method="post">
		<table>
			<h1>회원가입</h1>
			<tr>
				<td>Name</td>
				<td><input type="text" id="name" name="name" value="${vo.name}"
					class="name-insert" required></td>
			</tr>

			<tr>
				<td>ID</td>
				<td><input type="text" id="userid" name="userid"
					value="${vo.userid}" class="id-insert" required>
					<button type="button" id="checkId" class="btn-submit">아이디
						중복 확인</button></td>
			</tr>

			<tr>
				<td>PW</td>
				<td><input type="password" id="pwd" name="pwd"
					class="pw-insert" required></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="email" id="email" name="email"
					class="email-insert" required></td>
			</tr>

			<tr>
				<td>Phone</td>
				<td><input type="text" id="phone" name="phone"
					class="phone-insert" required></td>
			</tr>

			<tr>
				<td>
					<button type="button" class="btn-cancel"
						onclick="window.location.href='${ctx}/rentcarMain.jsp'">취소</button>
				</td>
				<td>
					<button type="submit" class="btn-submit">회원가입</button>
				</td>
			</tr>
		</table>
	</form>

	<script src="${ctx}/script/insert.js"></script>
</section>

<%@ include file="/WEB-INF/parts/footer.jsp"%>
