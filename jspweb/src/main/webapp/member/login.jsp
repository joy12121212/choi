<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/member.css" rel="stylesheet">



</head>
<body>
	<%@include file = "../header.jsp" %>

	
	<div id="wrap"> <!-- 회원가입 전체 구역 -->
		<form class="signupForm">
		<h2>소땡 커뮤니티 로그인</h2>
				
			<div class="intitle">아이디</div>
		
			<input maxlength="30" name="mid" class="mid" type="text"><br/>
			
			
			<div class="intitle">비밀번호</div>						
			<input maxlength="20"  name="mpwd" class="mpwd" type="text"><br/>
			
			<div class="logincheckbox" ></div>
			
			<div class="findbtnbox">
				<a href="#">아이디찾기</a>
				<a href="#">비밀번호찾기</a>
			
			</div>
			
			
			
			
			
			
			
			<button class="signupbtn" onclick="login()" type="button">로그인</button>
			
				
		</form>
	</div>
	
	
	
	
	
	<!-- js import -->
	<script src="../js/login.js" type="text/javascript"></script>
	
</body>
</html>