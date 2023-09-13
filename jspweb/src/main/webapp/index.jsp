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

<div class="row row-cols-1 row-cols-md-4 g-4">
  <div class="col">
    <div class="card">
      <img src="/jspweb/img/햄벅.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">햄버거당</h5>
        <p class="card-text">맛잇겟당...........</p>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <img src="/jspweb/img/햄벅.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">롯데리아를 가야되나</h5>
        <p class="card-text">나는 아직도.. 배가 고프다</p>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <img src="/jspweb/img/햄벅.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">후아후아</h5>
        <p class="card-text">맥도날드도 좋은데</p>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card">
      <img src="/jspweb/img/햄벅.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">근데 밥먹어야되는데</h5>
        <p class="card-text">고민이 되는구나</p>
      </div>
    </div>
  </div>
</div>

</div>

	<!-- 부트스트랩 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<!-- jsp 파일안에 다른 jsp 파일 import 하기 -->
	<%@include file = "footer.jsp" %>
</body>
</html>