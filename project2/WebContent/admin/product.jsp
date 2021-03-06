<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYSHOP</title>
<link rel="stylesheet" href="<c:url value="/css/product_full.css"/>">
<script src="https://code.jquery.com/jquery-1.12.4.js"
        integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous">
</script>
</head>
<body>
	<div id="wrap">
		<!-- 상단 -->
		<div>
			<!-- 로고 -->
			<%@ include file="../frame/header.jsp" %>
			<!-- 로고 끝 -->
		</div>
		<!-- 상단 끝 -->
		
		<!-- 센터 -->
		<form action="<c:url value='/productInsert.do'/>" method="POST" enctype="multipart/form-data">
			<div id="center_wrap">
	            <div class="main_img">
					<h1> 관리자 페이지 상품등록</h1>
					<h3>상품 이미지 등록 </h3>
					<input type="file" name="photo">
	            </div>
	            <div class="main_content">
	                <div class="main_a">
	                    <h2><b>의류 이름 : <input type="text" name="iName"></b></h2>
	                </div>
	                <div class="main_a">
	                    <p><b>의류이름</b></p>
	                    <p>-의류내용1 : <input type="text" name="content1"></p>
	                    <p>-의류내용2 : <input type="text" name="content2"></p>
	                    <p>-의류내용3 : <input type="text" name="content3"></p>
	                </div>
	                <div class="main_a font_sizes">
	                    <h3>가격: <input type="text" name="iPrice">원</h3>
	                    <h3>재고: <input type="text" name="count"></h3>
	                </div>
	                <div class="button_size">
	                   <input type="submit" value="상품등록">
	                   <input type="button" value="취소" onclick="history.back(-1)">
	                </div>
	            </div>
	        </div>
		</form>
		<!-- 센터끝 -->

		<!-- 하단 -->
		<footer>
			<%@ include file="../frame/footer.jsp" %>
		</footer>
		<!-- 하단끝 -->
	</div>

</body>

</html>