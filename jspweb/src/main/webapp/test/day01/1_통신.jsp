<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h6> 1. 외부 링크에 데이터 통신 </h6>
	<button onclick="예제1()" type="button"> 예제1 </button>


	<h6> 2. 외부 링크[java] </h6>
	<button onclick="예제2()" type="button"> 예제1 </button>
	<h3>안녕하시라요</h3>
	
	
	
	<!--  Uncaught ReferenceError: $ is not defined   밑에 링크 빠지면 이거 뜸 --> 
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="1_통신.js" type="text/javascript"></script>
</body>
</html>