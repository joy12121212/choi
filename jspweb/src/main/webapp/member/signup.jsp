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
	아이디 : <input class="mid" type="text">
	비밀번호 : <input class="mpwd" type="text">
	비밀번호 확인 : <input class="mpwdconfirm" type="text">
	이메일 :  <input class="memail" type="text">
	이메일 인증 : <input class="ecode" type="text">
	프로필 :  <input class="mimg" type="file">
	<button onclick="signup()" type="button">회원가입</button>
	</div>
	
	
	
	
	
	<!-- js import -->
	<script src="../js/signup.js" type="text/javascript"></script>
	
</body>
</html>