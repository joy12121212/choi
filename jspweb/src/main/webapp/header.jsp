<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/header.css" rel="stylesheet">

</head>
<body>


		<!-- 헤더 -->
		
		<div id="header">
		
			<div class="mainlogo">
				<!-- 로고 -->
				<a href="/jspweb/index.jsp">
					<img alt="" src="/jspweb/img/logo2.png"/>
				</a>
			</div>
		
			<ul class="mainmenu">
					<!--본메뉴  -->
				<li> <a href="/jspweb/visitlog/visitlog.jsp">방문록</a> </li>	
				<li> <a href="#">기능1</a> </li>
				<li> <a href="#">기능2</a> </li>
				<li> <a href="#">기능3</a> </li>				
				<li> <a href="/jspweb/accountbook/accountbook.jsp">가계부</a> </li>						
				<li> <a href="#">과제2</a> </li>						
				<li> <a href="#">인사관리</a> </li>						
			
			</ul>
			
			<ul class="submenu">
				<!--서브메뉴  -->
			<li> <a href="/jspweb/member/signup.jsp">회원가입</a> </li>	
				<li> <a href="/jspweb/member/login.jsp">로그인</a> </li>
				<li> <a href="#">로그아웃</a> </li>
				<li> <a href="#">마이페이지</a> </li>
				<li> <img class="himg" src="/jspweb/member/img/default.webp"/></li>			
						
			</ul>
			
		</div>
		
		
		
		
	<!-- jquery 호출 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		

</body>
</html>