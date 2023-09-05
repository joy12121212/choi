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
	<div> <!-- 전체구역 -->
		<h2>글쓰기 페이지</h2>
		 <a href="list.jsp">목록보기</a>
		
		<form class="writeform"><!-- 쓰기 구역 -->
		
		
			카테고리 : <select name="bcno" class="bcno">
						<option value="1">공지사항</option>
						<option value="2">자유게시판</option>
						<option value="3">노하우</option>
					</select><br/>
		
			제목 : <input type="text" name="btitle" class="btitle"><br/>
			내요 : <textarea name="bcontent" class="bcontent"></textarea><br/>
			첨부파일 : <input type="file" name="bfile" class="bfile"><br/>
			<div class="oldfile"></div>
			<button onclick="onUpdate()" type="button">글수정</button>
			<a href="list.jsp">목록보기</a>

			
			
		</form><!-- 쓰기 구역 끝-->

	</div> <!-- 전체구역 끝-->
	
	<script src="../js/board/update.js" type="text/javascript"></script>

</body>
</html>