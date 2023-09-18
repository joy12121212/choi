<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 부트스트랩 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<link href="/jspweb/css/index.css" rel="stylesheet">
</head>
<body>
	<!-- jsp 파일안에 다른 jsp 파일 import 하기 -->
	<%@include file = "header.jsp" %>

<!--       /jspweb/img/샘플1.jpeg           -->
	<!-- 캐러샐 이미지 슬라이드 -->
	<div class="container">

	<div id="carouselExampleInterval" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active" data-bs-interval="5000">
				<img src="/jspweb/img/샘플1.jpeg" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item" data-bs-interval="5000">
				<img src="/jspweb/img/샘플2.jpeg" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="/jspweb/img/샘플3.jpeg" class="d-block w-100" alt="...">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleInterval" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<div class="container">
		<div class="productBox row row-cols-1 row-cols-md-4 g-4">
	
		</div>
	</div>

</div>

	<!-- 부트스트랩 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

	<script src="/jspweb/js/index.js" type="text/javascript"></script>
	

	<!-- jsp 파일안에 다른 jsp 파일 import 하기 -->
	<%@include file = "footer.jsp" %>
</body>
</html>