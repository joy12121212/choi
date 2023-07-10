<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="../css/calendar.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	
		<div class="wrap"> <!-- 캘린더 전체 구역 -->
			<div class="caltop"> <!-- 상단 메뉴 -->
					<!-- 이전 달 버튼 -->
				<button onclick="onNext(0)" type="button"> < </button>  <!-- 이전달 -->
					<!-- 현재 월 / 표시 구역 -->
				<h3 class="caldate"> </h3>
					<!-- 다음 달 버튼 버튼 -->
				<button onclick="onNext(1)" type="button"> > </button>  <!-- 다음달 -->
			</div> <!-- 상단 메뉴 -->

			<div class="calendar"> <!-- 날짜 표시 구역 -->
				<!-- 상단 요일 출력 -->
				<!-- 상단 일 출력 -->
				<!-- 내용 출력 -->

			</div> <!-- 날짜 표시 구역 -->
		
		</div> <!-- 캘린더 전체 구역 -->
	
		<div class="modalwrap"> <!-- 모달 전체 -->
			<div class="modal"> <!-- 모달 상자 -->
				<h3>일정 추가</h3>
				<input class="color" type="color">
				<div class="date"></div>
				<textarea class="contentinput" rows="10" cols="65"></textarea>
					<div class="modalbtn"><!-- 모달 버튼 -->
						<button onclick="onWrite()" type="button">일정등록</button>
						<button onclick="closeModal()">닫기</button>
					
					</div>
			</div> <!-- 모달 상자 -->
		
		</div> <!-- 모달 전체 -->
		
		
	
	
	

	<%@include file="../footer.jsp" %>		
	
	<script src="../js/calendar.js" type="text/javascript"></script>
</body>
</html>