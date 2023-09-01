<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/hrm.css" rel="stylesheet">
</head>
<body>
	<%@include file = "../header.jsp" %>

	<div id="wrap"><!-- 전체 감싸기 -->
		
		<form class="hrmForm">
			
			<div>직원명</div>
			<input name="sname" class="sname" type="text">
			
			<div>직원전화번호</div>
			<input name="sphone"  class="sphone" type="tel">
			
			<div>직급</div>
			<select name="sposition" class="sposition">
				<option>사장</option>
				<option>부장</option>
				<option>과장</option>
				<option>대리</option>
				<option>사원</option>
			
			</select>
			
			<div>사진등록</div>
			<input onchange="preimg(this)" name="smig" class="" type="file" accept="image/*">
			<img class="preimg" alt="" src="img/default.webp"><br/>
						
			<button class="sbtn" onclick="signup()" type="button">직원등록</button>
		</form>
	
		<div class="sprint">
			<div class="smenu">
			<div>사번</div><div>직원명</div><div>연락처</div><div>직책</div><div>사진</div><div>등록일</div>
			</div>
			<!-- 정보 출력 구역 -->
			<div class="sinfo"></div>
		</div>
		
	</div><!-- 전체 감싸기 -->


	
	<!-- js import -->
	<script src="../js/hrm.js" type="text/javascript"></script>
</body>
</html>