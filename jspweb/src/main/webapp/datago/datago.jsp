<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/datago/datago.css" rel="stylesheet">
</head>
<body>
	<%@include file = "../header.jsp" %>
	<div class="webcontainer">
		<h3>공공데이터</h3>
		<div>
			<h2>카카오지도</h2>
			<div class="detailbox">
			</div>
			
			
			<div id="map" style="width:800px; height:600px;"></div>
		
		
			<h6>안산시 착한가격 업소 현황</h6>
				<table class="apiTable1">
				</table>
		</div>
	</div>

	<!-- jquery 호출 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e0a3b6e2c0022f6972c3d293e2130dce&libraries=clusterer"></script>
	<script  src="/jspweb/js/datago/datago.js" type="text/javascript"></script>
</body>
</html>