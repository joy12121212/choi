<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp 파일안에 다른 jsp 파일 import 하기 -->
	<%@include file = "header.jsp" %>
	
			<h3>회원매출조회</h3>
		<center>
		
			<table border="1">
				<tr>
				<th>회원번호</th><th>회원성명</th><th>고객등급</th><th>매출</th>
				</tr>
				<tr>
				<td>100001</td><td>김행복</td><td>VIP</td><td>8000</td>
				</tr>	
			</table>
		
		</center>	
		

			
			
	<!-- jsp 파일안에 다른 jsp 파일 import 하기 -->
	<%@include file = "footer.jsp" %>
	
</body>
</html>