<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/parts/header.jsp"%>

<div class="mainScreen">
	<div class="swiper mySwiper">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<img src="${ctx}/image/1.jpg">
			</div>
			<div class="swiper-slide">
				<img src="${ctx}/image/2.jpg">
			</div>
			<div class="swiper-slide">
				<img src="${ctx}/image/3.jpg">
			</div>
		</div>
		<div class="swiper-pagination"></div>
		<div class="swiper-button-next"></div>
		<div class="swiper-button-prev"></div>
	</div>
</div>

<script src="${ctx}/script/swiper.js"></script>

<%@ include file="/WEB-INF/parts/footer.jsp"%>
