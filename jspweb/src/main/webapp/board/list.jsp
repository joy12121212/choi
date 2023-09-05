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
		<div class="boardtop">
			<h2>게시판</h2>
			<p> 다양한 사람들과 정보르 ㄹ공유 하세요</p>
		</div>
	
	<div class="boardtopetc">
		<span class="boardcount"></span>
			<select class="listsize" onchange="onlistsize()">
				<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>					
		</select>
	</div>
			
	<!-- 카테고리구역 -->

		<div class="listbtn"> <!-- 버튼 구역 -->
			<div>
			<button onclick="onCategory(0)" type="button">전체보기</button>
			<button onclick="onCategory(1)" type="button">공지사항</button>
			<button onclick="onCategory(2)" type="button">자유게시판</button>
			<button onclick="onCategory(3)" type="button">노하우</button>
			</div>
			<div>
			<button type="button" onclick="onWrite()">글쓰기</button>
			</div>
		</div> <!-- 버튼 구역 -->
		
		<!-- 글 목록 구역 -->
		<table class = "boardTable"></table>
		
		
		<div class="boardbottom">
		
			<!-- 페이징 처리 구역 -->
			<div class="pagebox"></div>
			
			<!-- 검색 구역 -->
			<div class="pageboxbt">
			<select class="skey"> <!-- 검색 키워드 -->
				<option>제목</option>
				<option>내용</option>
				<option>작성자</option>
			</select>
			<input type="text" class="keyword"> <!-- 검색할 내용 -->
			<button type="button" class="search">검색</button>
			</div>
		</div> <!-- board bottom -->
		
		
		
	</div><!-- 전체구역 끝 -->

<script src="../js/board/list.js" type="text/javascript"></script>


</body>
</html>