<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<h6> AJAX [JS ----- 자바[서블릿] 통신]</h6>
		<h6> 1. js에서 servlet [자바웹클래스] 에게 통신하고 데이터 반환</h6>
		<button onclick="예제1()" type="button">예제1</button>


		<h6> 2. 한글 인코딩 js에서 servlet [자바웹클래스] 에게 통신하고 데이터 반환 받기</h6>
		<button onclick="예제2()" type="button">예제2</button>

		<h6> 3. 직접 json js에서 servlet [자바웹클래스] 에게 통신하고 데이터 반환 받기</h6>
		<button onclick="예제3()" type="button">예제3</button>

		<h6> 4. 라이브러리 json js에서 servlet [자바웹클래스] 에게 통신하고 데이터 반환 받기</h6>
		<button onclick="예제4()" type="button">예제4</button>
		
		
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src = "1_AJAX통신.js" type="text/javascript"></script>
	
</body>
</html>