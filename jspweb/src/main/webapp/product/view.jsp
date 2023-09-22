<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/product/view.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">


</head>
<body>

	<%@include file = "../header.jsp" %>
	<div class="container">  
		<div class="productBox">

			<div id="carouselExample" class="carousel slide"><!-- 캐러셀 이미지 슬라이드 -->
				<div class="imgbox carousel-inner"><!-- 캐러셀 넣을 구역 -->

				</div>
				<!-- 왼쪽 이동 버튼 -->
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExample" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<!-- 오른쪽 이동 버튼 -->
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExample" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>




			<div class="mid"></div>
			<div class="categorydate">
				<div class="pcname"></div>
				<div class="pdate"></div>
			</div>
			<div class="pname"></div>
			<div class="pprice"></div>
			<div class="pcontent"></div>
			<div class="etcbtnbox">
				<button onclick="setWish()" type="button">찜하기<span class="wish">♡</span></abbr></button>
				<button type="button">바로구매</button>
			</div>
			
		<!-- 탭스 -->
			<!-- 탭 구역 -->
			<ul class="mt-5 my-1 nav nav-tabs nav-pills nav-fill" id="myTab" role="tablist">
				<!-- 탭 1개 항목 data-bs-target : 탭버튼을 클릭했을대 활성화되는 탭 내용의 id -->
				<li class="nav-item" role="presentation">
					<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
						data-bs-target="#home-tab-pane" type="button" role="tab"
						aria-controls="home-tab-pane" aria-selected="true">호오오오오옴</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
						data-bs-target="#profile-tab-pane" type="button" role="tab"
						aria-controls="profile-tab-pane" aria-selected="false">신고</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="contact-tab" data-bs-toggle="tab"
						data-bs-target="#contact-tab-pane" type="button" role="tab"
						aria-controls="contact-tab-pane" aria-selected="false">목록이다</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="disabled-tab" data-bs-toggle="tab"
						data-bs-target="#disabled-tab-pane" type="button" role="tab"
						aria-controls="disabled-tab-pane" aria-selected="false">이거는클릭불가</button>
				</li>
			</ul>
			
			<!-- 탭 내용 -->
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="home-tab-pane"
					role="tabpanel" aria-labelledby="home-tab" tabindex="0">안녕하소~ 홈 입네다<br/>얼마나써지나궁금한데이게계속길어지면자동으로줄바꿈도되려나와아직도글을더적어야되는거네오자동으로줄바꿈되는거괜찮네맘에들어요괜찮아</div>
				<div class="tab-pane fade" id="profile-tab-pane" role="tabpanel"
					aria-labelledby="profile-tab" tabindex="0">신고하는건 좋은데 상금은 없음ㅋ</div>
				<div class="tab-pane fade" id="contact-tab-pane" role="tabpanel"
					aria-labelledby="contact-tab" tabindex="0">이건 무슨 탭이더라...기억이 안나네..??</div>
				<div class="tab-pane fade" id="disabled-tab-pane" role="tabpanel"
					aria-labelledby="disabled-tab" tabindex="0">이거는 비활성화가 맞는데 내가 disabled 지움ㅋ</div>
			</div>



			<!-- 탭스 end -->
			
		</div><!-- productBox -->
	</div><!-- container -->
	
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e0a3b6e2c0022f6972c3d293e2130dce&libraries=clusterer"></script>
	<script src="/jspweb/js/product/view.js" type="text/javascript"></script>


</body>
</html>