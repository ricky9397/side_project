<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYGOT</title>
<link rel="stylesheet" href="./css/id_find.css">
<!-- jquery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"
	integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
	crossorigin="anonymous">
	
</script>
<!-- js -->
<script src="./js/id_find.js"></script>
</head>

<body>

	<div id="wrap">
		<!-- 상단 -->
		<div>
			<!-- 로고 -->
			<header>
				<h1>
					<a href="../index/index.html">OH MY SHOP</a>
				</h1>
			</header>
			<!-- 로고 끝 -->

			<!-- 메뉴 -->
			<nav>
				<div>
					<ul class="nav1">
						<li><a href="../login/login.html">LOGIN</a></li>
						<li><a href="../join/join_index.html">JOIN</a></li>
						<li><a href="#">MY PAGE</a></li>
					</ul>
				</div>
				<div>
					<ul>
						<li class="serch_li"><a href="#" class="serch"> <img
								src="./img/header_ico_search.png">
						</a></li>
					</ul>
				</div>
				<ul class="nav2">
					<li><a href="../index/index.html">MAIN</a></li>
					<li><a href="#">OUTWEAR</a></li>
					<li><a href="#">TOP</a></li>
					<li><a href="#">BOTTOM</a></li>
					<li><a href="#">COMMUNITY</a></li>
				</ul>
			</nav>
			<!-- 메뉴 끝 -->
		</div>
		<!-- 상단 끝 -->


		<!-- 센터 -->
		<div>
			<h2>아이디 찾기</h2>
		</div>
		<form action="" id="idFind">
			<div>
				<table class="id_find">
					<tr>
						<th>이름</th>
						<td class="id-find_check"><input type="text" id="userName"
							name="find_name">
							<div class="msg"></div></td>
					</tr>
					<tr>
						<th>이메일로 찾기</th>
						<td class="id-find_check"><input type="text" id="userEmail"
							name="find_mail">
							<div class="msg"></div></td>
					</tr>
				</table>
				<div class="submit_check">
					<input type="submit" value="확인">
				</div>
			</div>
		</form>
		<!-- 센터끝 -->


		<!-- 하단 -->
		<footer>
			<div>
				<h2>카카오톡@OHMYSHOP & Q/A % 070-1234-5678</h2>
				<p>MON-FRI ~ PM 06:00 LUNCH TIME PM 12:00 ~ PM 01:00 SAT.HOLIDAY
					CLOSED</p>
				<P>하나은행 123-123123-1231 예금주:김명호(오마이샵)</P>
			</div>
		</footer>
		<!-- 하단끝 -->


	</div>
</body>
</html>