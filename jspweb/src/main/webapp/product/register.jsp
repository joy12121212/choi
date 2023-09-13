<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 부트스트랩 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>
		<%@include file = "../header.jsp" %>

	<div class="container">
		<form class="registerForm">
			카테고리 : <select name = "pcno">
						<option value="1">노트북</option>
						<option value="2">컴퓨터</option>
						<option value="3">핸드폰</option>
					</select> <br/>
			제품명 : <input name="pname" type="text"> 
			제품설명 :  <textarea name="pcontent" rows="" cols=""></textarea>
			제품가격 : <input name="pprice" type="number">
			<!-- 첨부파일 1개 일때 -->
			<!-- 제품이미지 : <input name="pimg" type="file">-->
		
			<!-- 첨부파일 2~개 일때 -->
			제품이미지 : <input name="pimg" type="file" multiple="multiple">
			<!-- multiple 사용할거면 commons 사용 -->

			<button onclick="onRegister()" type="button">등록</button>
			
			
		</form>
	</div>




	<!-- 부트스트랩 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

	<script  src="/jspweb/js/product/register.js" type="text/javascript"></script>

</body>
</html>