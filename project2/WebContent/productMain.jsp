<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYSHOP</title>
<link rel="stylesheet" href="./css/product_full.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"
        integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" crossorigin="anonymous">
</script>
<script type="text/javascript">
	function submit2(frm){
		
		var result = confirm('장바구니에 담으셨습니다. 이동하시겠습니까?');
		if(result == true){
			alert('장바구니 이동합니다.');
			frm.submit();
			frm.action = 'cart.do';
		} else {
			frm.submit();
			frm.action = 'cartBack.do';
		}
	};
</script>

</head>
<body>
	<div id="wrap">
		<!-- 상단 -->
		<div>
			<!-- 로고 -->
			<%@ include file="../frame/header.jsp" %>
			<!-- 로고 끝 -->

			<!-- 메뉴 -->
			<%@ include file="../frame/nav.jsp" %>
			<!-- 메뉴 끝 -->
		</div>
		<!-- 상단 끝 -->

	
		<!-- 센터 -->
		<form action="order.do" method="post">
		<input type="hidden" name="iCode" value="${ProductContent.iCode}">
		<input type="hidden" name="iName" value="${ProductContent.iName}">
		<input type="hidden" name="iPrice" value="${ProductContent.iPrice}">
		<input type="hidden" name="photo" value="${ProductContent.iPhoto}">
		<input type="hidden" name="id" value="${id}">
		<%-- <input type="hidden" name="count" value="${ProductContent.count}"> --%>
			<div id="center_wrap">
	            <div class="main_img">
	                <img src="<c:url value="/upload/${ProductContent.iPhoto}"/>">
	            </div>
	            <div class="main_content">
	                <div class="main_a">
	                    <h2><b>${ProductContent.iName}</b></h2>
	                </div>
	                <div class="main_a">
	                    <p><b>${ProductContent.iName}</b></p>
	                    <p>-${ProductContent.content1}</p>
	                    <p>-${ProductContent.content2}</p>
	                    <p>-${ProductContent.content3}</p>
	
	                </div>
	                <div class="main_a font_sizes">
	                    <h3>${ProductContent.iPrice} 원</h3>
	                </div>
	                <div class="main_b">
	                    <select class="select_size">
	                        <option>size</option>
	                        <option>250</option>
	                        <option>260</option>
	                        <option>270</option>
	                        <option>280</option>
	                        <option>290</option>
	                    </select>
	                    <p class="fonts">[필수]옵션을 선택해주세요.</p>
	                </div>
	                <div class="in_number main_b">
                   		<input type="number" value="1" name="count"><p class="fonts">수량 선택</p>
               		</div>
	                <div class="button_size">
	                    <input type="submit" value="ADD TO CART" onclick="return submit2(this.form);">
	                    <input type="submit" value="BUY NOW" onclick="<c:if test="${id == null}">alert('로그인 하셔야합니다.')</c:if>">
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