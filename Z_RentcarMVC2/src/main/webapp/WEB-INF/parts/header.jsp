<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Header</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />

<script
	src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
</head>


<body>

	<header>

		<section class="rentcar-logo">
			<a href="${ctx}/rentcarMain.do"> <img
				src="${ctx}/image/rent_logo.jpg" alt="로고">
			</a>

		</section>

		<section class="rentcar-header">
			<a href="${ctx}/rentcarReservation.do">빠른 예약</a> <a
				href="${ctx}/rentcarReservationList.do">내 예약 정보</a> <a
				href="${ctx}/rentcarCustomerCenter.do">고객센터</a>
		</section>

		<section class="user-header">
			<c:choose>
				<c:when test="${log eq null}">
					<a href="${ctx}/userInsert.do">회원가입</a>
					<a class="open-modal-btn" onclick="openModal()">로그인</a>
				</c:when>
				<c:otherwise>
					<a href="${ctx}/userInfo.do?name=${log}"> <i
						class="fa-regular fa-user"></i>
					</a>
					<a href="${ctx}/userLogout.do">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</section>

		<div class="modal" id="loginModal">
			<div class="modal-content">
				<button class="close-btn">&times;</button>
				<h3>로그인</h3>
				<form action="${ctx}/userLogin.do" method="post">
					<table>
						<tr>
							<td>ID</td>
							<td><input type="text" id="id" name="id" required></td>
						</tr>

						<tr>
							<td>PW</td>
							<td><input type="password" id="pw" name="pw" required></td>
						</tr>

						<tr>
							<td colspan="2">
								<button type="submit" class="btn-submit">로그인</button>
							</td>
						</tr>

						<tr>
							<td colspan="2">
								<button type="button" class="btn-cancel">취소</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>

	</header>
	<main>

		<script src="${ctx}/script/modal.js"></script>
		<script>
			window.ctx = "${pageContext.request.contextPath}";
		</script>