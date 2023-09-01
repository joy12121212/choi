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
			
			<h2>마이페이지</h2>
		
			<div class="intitle">프로필 변경</div>
			<input onchange="preimg(this)" name="mimg" class="mimg" type="file" accept="image/*">
			<img  class="preimg" alt="" src="img/default.webp">
			
			<div class="intitle">아이디</div>
			<div class="mid"></div>
			
			<div class="intitle">이메일</div>
			<div class="memail"></div>
			
			<!-- 아래는 수정 가능 -->
			
			
			<div class="intitle">기존 비밀번호</div>
			<input maxlength="20" onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password"><br/>
			
			<div class="intitle">새로운 비밀번호</div>
			<input maxlength="20" onkeyup="pwcheck()" name="newmpwd" class="mpwdconfirm" type="password"><br/>

			<button class="signupbtn" onclick="mupdate()" type="button">수정</button>
			<button class="signupbtn" onclick="mdelete()" type="button">탈퇴</button>
	
		</form>
	</div>
	
	
	
	
	
	<!-- js import -->
	
	<script src="../js/signup.js" type="text/javascript"></script>
	<script src="../js/info.js" type="text/javascript"></script>
	
</body>
</html>