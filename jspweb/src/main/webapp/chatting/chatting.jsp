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

	<div class="webcontainer">
		<h3>채팅</h3>
		<div>
			<div class="contentbox"></div>
		
			<input class="inputcontent" type="text">
			<button class="sendbtn" onclick="msgsend()" type="button">전송</button>
		</div>
		
	</div>


<script src="../js/chatting/chatting.js" type="text/javascript"></script>
</body>
</html>