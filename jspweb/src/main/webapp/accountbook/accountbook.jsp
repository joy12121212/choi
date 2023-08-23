<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- css import -->
<link herf = "accountbook.css" rel="stylesheet">
</head>
<body>

	<div class = "acbwrap"> <!-- 전체 구역 -->

	
		<div class = "acb_Write"> <!-- 글 작성 구역 -->
			<input class="acbContent" type="text" placeholder="가계부 입력">
			<input class="acbMoney" type="text" placeholder="금액">
			<input class="acbDate" type="date" placeholder="날짜">
			<button onclick="acbwrite()" type="button">등록</button>	
		
		</div> <!-- 글 작성 구역 끝 -->
	
	<!--------------------------------------------------->
	
		<div class = "acb_Frint"> <!-- 가계부 출력 구역 -->

	
		</div> <!-- 가계부 출력 구역 끝 -->
	
	<!--------------------------------------------------->

	
	</div> <!-- 전체 구역 끝 -->


	<!-- jquery 호출 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- js import -->
	<script src="accountbook.js" type="text/javascript"></script>
</body>
</html>