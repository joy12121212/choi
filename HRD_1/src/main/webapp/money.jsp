<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
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
	
			<h3>회원매출조회</h3>
		<center>
		
			<table border="1">
				<tr>
				<th>회원번호</th><th>회원성명</th><th>고객등급</th><th>매출</th>
				</tr>
				
				<%
					Dao dao = new Dao();
				List<Map<String , String>> list = dao.getMoney();
				for(int i = 0; i<list.size(); i++){
					Map<String ,String> map = list.get(i);
					
				
				String price = map.get("grade").equals("A") ? "VIP" : map.get("grade").equals("B") ? "일반" : "직원";	
					
				%>
				
				<tr>
				<td><%= map.get("custno")%></td><td><%= map.get("custname")%>
				</td><td><%= price%></td><td><%= map.get("sum")%></td>
				</tr>
				
				<%
					}//for end
				%>	
			</table>
		
		</center>	
		

			
			
	<!-- jsp 파일안에 다른 jsp 파일 import 하기 -->
	<%@include file = "footer.jsp" %>
	
</body>
</html>