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
	
	<div class="container">
	
		<div>
			<button onclick="onAmount(1000)" type="button"> 1,000p</button>
			<button onclick="onAmount(5000)" type="button"> 5,000p</button>
			<button onclick="onAmount(10000)" type="button"> 10,000p</button>
			<button onclick="onAmount(50000)" type="button"> 50,000p</button>
			<button onclick="onAmount(100000)" type="button"> 100,000p</button>
		
		</div>
	
	
		<button onclick="onPayMethod('card')" type="button">신용카드</button>
		<button onclick="onPayMethod('trans')" type="button">실시간 계좌이체</button>
		<button onclick="onPayMethod('vbank')" type="button">가상계좌</button>
		<button onclick="onPayMethod('phone')" type="button">휴대폰</button>
		<!-- HTML에서 매개변수 전달시 문자일경우 ' ' 로 문자처리 해줘야 됨 -->


		<button onclick="requestPay()" type="button">결제하기</button>
	
	
	
	
	</div>
	
	
	
	<!-- 결제 api 연동 -->
	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	
	<!-- js import -->
	<script src="/jspweb/js/payment.js" type="text/javascript"></script>
</body>
</html>