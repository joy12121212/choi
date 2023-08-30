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
		<h2>소땡 커뮤니티 회원가입</h2>
		<p>환영합니다. 다양한 커뮤니티 플렛폼 입니다</p>
				
			<div class="intitle">아이디</div>
		
			<input maxlength="30" onkeyup="idcheck()" name="mid" class="mid" type="text"><br/>
				<div class="idcheckbox" ></div>
			
			<div class="intitle">비밀번호</div>
						
			<input maxlength="20" onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password"><br/>
				<div class="pwcheckbox"></div>
			
			<div class="intitle">비밀번호 확인</div>
				<input maxlength="20" onkeyup="pwcheck()" class="mpwdconfirm" type="password"><br/>

			<div class="intitle">이메일</div>
				<div class="emailbox">
					<input maxlength="30" onkeyup="emailcheck()" name="memail" class="memail" type="text">
					<button onclick="authReq()" class="authReqBtn" disabled type="button">인증요청</button><br/>
				</div>
			<!-- 이메일 인증검사 통과시 사용 가능 -->
			<div class="emailchechbox"></div>
			
			<div class="authbox"></div>
			
			<div class="intitle">프로필</div>
			<input onchange="preimg(this)" name="mimg" class="mimg" type="file">
			<img  class="preimg" alt="" src="img/default.webp">
			<button class="signupbtn" onclick="signup()" type="button">회원가입</button>
	
		</form>
	</div>
	
	
	
	
	
	<!-- js import -->
	<script src="../js/signup.js" type="text/javascript"></script>
	
</body>
</html>