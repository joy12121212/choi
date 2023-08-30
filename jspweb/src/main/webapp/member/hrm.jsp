<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file = "../header.jsp" %>

	<div>
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
			<input onchange="preimg(this)" name="smig" type="file">
			<img class="preimg" alt="" src=""><br/>
						
			<button onclick="signup()" type="button">직원등록</button>
		</form>
	</div>


	
	<!-- js import -->
	<script src="../js/hrm.js" type="text/javascript"></script>
</body>
</html>