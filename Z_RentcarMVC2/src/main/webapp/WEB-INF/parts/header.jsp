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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
<!-- Swiper CDN -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
</head>

<body>

	<header>

		<section class="rentcar-logo">
			<a href="${ctx}/rentcarMain.do"> <img
				src="${ctx}/image/rent_logo.jpg" alt="로고"
				style="width: 150px; height: auto;">
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
					<a href="${ctx}/userLogin.do">로그인</a>
				</c:when>
				<c:otherwise>
					<span>${log}님 환영합니다.</span>
					<a href="${ctx}/userInfo.do?name=${log}"> <i
						class="fa-regular fa-user"></i>
					</a>
					<a href="${ctx}/userLogout.do">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</section>

	</header>

	<main>

		<script>
			window.ctx = "${pageContext.request.contextPath}";
		</script>