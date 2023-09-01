<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/board/list.css" rel="stylesheet">
</head>
<body>
	<%@include file = "../header.jsp" %>

	<!-- 전체구역 -->
	<div class="webcontainer">
		<!-- 글쓰기 구역 -->
		<button type="button" onclick="onWrite()">글쓰기</button>

		<!-- 글쓰기 구역 끝 -->

		<!-- 글 목록 구역 -->
		<div>
			
			<table>
				<tr>
					<th>글번호</th><th>글제목</th><th>작성자</th><th>게시일</th><th>조회수</th>
				</tr>
			</table>
		
		</div>
		<!-- 글 목록 구역 끝 -->


	</div><!-- 전체구역 끝 -->








<script src="../js/board/list.js" type="text/javascript"></script>


</body>
</html>