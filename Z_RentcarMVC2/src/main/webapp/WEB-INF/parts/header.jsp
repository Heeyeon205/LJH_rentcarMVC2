<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Header</title>
<script src="${ctx}/script/alert.js"></script>
<script>
    console.log("✅ alert.js 로드됨!");
</script>

</head>

<body>

	<header>
		<c:choose>
			<c:when test="${log eq null}">
				<form action="${ctx}/userInsert.do" method="post">
					<button type="submit">회원가입</button>
				</form>
				<form action="${ctx}/userLogin.do" method="post">
					<button type="submit">로그인</button>
				</form>
			</c:when>
			<c:otherwise>
				<span>${log} 님 환영합니다.</span>
				<a href="${ctx}/userInfo.do?name=${log}">내 정보</a>
				<form action="${ctx}/userLogout.do" method="post">
					<button type="submit">로그아웃</button>
				</form>
			</c:otherwise>
		</c:choose>
	</header>

	<main>