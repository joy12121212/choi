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
	<h3>회원가입 왓어요</h3>
	
	<div> <!-- 회원가입 전체 구역 -->
		<form class="signupForm">
			아이디 : <input onkeyup="idcheck()" name="mid" class="mid" type="text"><br/>
			<span class="idcheckbox" ></span>
			<br/>
			비밀번호 : <input onkeyup="pwcheck()" name="mpwd" class="mpwd" type="text">
			비밀번호 확인 : <input onkeyup="pwcheck()" class="mpwdconfirm" type="text"><br/>
			
			<span class="pwcheckbox"></span>
			<br/>
			이메일 :  <input onkeyup="emailcheck()" name="memail" class="memail" type="text"> <button onclick="authReq()" class="authReqBtn" disabled type="button">인증요청</button><br/>
			<!-- 이메일 인증검사 통과시 사용 가능 -->
			<span class="emailchechbox"></span><br/>
			
			<div class="authbox">
			</div>
			
			프로필 :  <input onchange="preimg(this)" name="mimg" class="mimg" type="file">
			<img  class="preimg" alt="" src="">
			<button onclick="signup()" type="button">회원가입</button>
	
		</form>
	</div>
	
	
	
	
	
	<!-- js import -->
	<script src="../js/signup.js" type="text/javascript"></script>
	
</body>
</html>