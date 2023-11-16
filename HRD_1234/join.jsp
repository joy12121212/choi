<%@page import="model.dao.Dao"%>
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
	

	
	
	<%
	
		Dao dao = new Dao();
		int custno = dao.lastNo();//마지막 번호에 + 가져오기
		
		System.out.print("커스트넘버" + custno);
	%>
	
	
	<center>
		<h3>홈쇼핑 회원 등록</h3>
		
		<form method="post" action="joinLogic.jsp" name="joinForm">
		<table>
		
			<tr><td>회원정보(자동발생)</td> <td><input name="custno" type="text" value=<%=custno%> /></tr>
		
			<tr><td>회원성명</td> <td><input name="custname" type="text"/></tr>
		
			<tr><td>회원전화</td> <td><input name="phone" type="text"/></tr>
		
			<tr><td>회원주소</td> <td><input name="address" type="text"/></tr>
		
			<tr><td>가입일자</td> <td><input name="joindate" type="text"/></tr>
		
			<tr><td>고객등급[A:Vip , B: 일반 , C: 직원]</td> <td><input name="grade" type="text"/></tr>
		
			<tr><td>도시코드</td> <td><input name="city" type="text"/></tr>
			
			<tr> <td colspan="2">
				<center>
				<button type="button" onclick="onJoin()">등록</button>
				<a href="list.jsp"></a> <button type="button">조회</button> </a>
				</center>
				</td>
		</table>		
		</form>

	</center>
		
		
		
		
		
		
	<!-- jsp 파일안에 다른 jsp 파일 import 하기 -->
	<%@include file = "footer.jsp" %>
	<script type="text/javascript" src="join.js"></script>
</body>
</html>