<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OHMYSHOP</title>
<!-- css -->
<link rel="stylesheet" href="./css/write.css">
<!-- jquery -->
<script src="https://code.jquery.com/jquery-1.12.4.js"
	integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
	crossorigin="anonymous">
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
		<form action="./bbswrite.do" method="post" id="bbs_writer" enctype="multipart/form-data">
			<div class="center_wrap">
				<div class="center_font">
					<h2>게시판</h2>
				</div>
				<div>
					<h2>COMMUNITY</h2>
				</div>
				<div class="title">
					<span>WRITER</span> <input type="text" name="bbsTitle" id="title">
				</div>
				<div>
					<textarea class="bbs" name="bbsContent"></textarea>
					<div class="count_size">
						문자 : <span id="count">0</span>
					</div>
				</div>
				
				<table class="file_tb">
                    <tr>
                        <th>FILE</th>
                        <td><input type="file" name="photo"></td>
                    </tr>
                </table>
				
				<div class="bbs_btn_size">
					<input type="submit" value="REGISTER" id="dd"> <input type="button"
						value="CANCLE" onclick="history.back(-1)">
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
	
<script>
$(document).ready(function(){
    $('textarea').keyup(function(){

        var cnt = $(this).val().length;
        var remain = 10000 - cnt;

        console.log(cnt, remain);

        if(remain < 0){
            alert('글작성은 10000자 까지만 가능합니다.');
            var str = $(this).val().substr(0, 10000);
            $(this).val(str);
            $('#count').text('10000');
            return false;
        }
        $('#count').text(cnt);
    });
});
</script>

</body>

</html>