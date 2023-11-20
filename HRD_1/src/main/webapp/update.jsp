<%@page import="java.util.Map"%>
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
	
		int custno = Integer.parseInt(request.getParameter("custno"));
	
		Dao dao = new Dao();
		Map<String , String> map = dao.getMember(custno);
	
	%>

	<script type="text/javascript">
		function onUpdate(){
			document.updateForm.submit(); alert('회원정보 수정이 완료되었습니다.')
			
			
		}
	
	</script>
	
	
	
	<center>
		<h3>홈쇼핑 회원 수정</h3>
		
		<form method="post" action="updateLogic.jsp" name="updateForm">
		<table>
		
			<tr><td>회원정보(자동발생)</td> <td><input name="custno" type="text" value="<%=map.get("custno") %>" /></tr>
		
			<tr><td>회원성명</td> <td><input name="custname" type="text" value="<%=map.get("custname") %>" /></tr>
		
			<tr><td>회원전화</td> <td><input name="phone" type="text" value="<%=map.get("phone") %>" /></tr>
		
			<tr><td>회원주소</td> <td><input name="address" type="text" value="<%=map.get("address") %>" /></tr>
		
			<tr><td>가입일자</td> <td><input name="joindate" type="text" value=<%=map.get("joindate") %> /></tr>
		
			<tr><td>고객등급[A:Vip , B: 일반 , C: 직원]</td> <td><input name="grade" type="text" value="<%=map.get("grade") %>" /></tr>
		
			<tr><td>도시코드</td> <td><input name="city" type="text" value="<%=map.get("city") %>" /></tr>
			
			<tr> <td colspan="2">
				<center>
				<button type="button" onclick="onUpdate()">수정</button>
				<a href="list.jsp"> <button type="button">조회</button> </a>
				</center>
				</td>
		</table>		
		</form>

	</center>
		
		
		

	<!-- jsp 파일안에 다른 jsp 파일 import 하기 -->
	<%@include file = "footer.jsp" %>
	

</body>

</html>