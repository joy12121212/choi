<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 부트스트랩 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<link href="/jspweb/css/product/list.css" rel="stylesheet">
</head>
<body>
		<%@include file = "../header.jsp" %>


		<div class="mapcontent">
			<!-- 지도를 표시할 div 입니다 -->
			<div id="map"></div><!-- map -->

			<!-- 사이드바 구역 -->
			<div class="sidebar"></div>
			

		</div>	

	

	<!-- 부트스트랩 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

	<!-- 카카오지도 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e0a3b6e2c0022f6972c3d293e2130dce&libraries=clusterer"></script>

	<script  src="/jspweb/js/product/list.js" type="text/javascript"></script>

</body>
</html>