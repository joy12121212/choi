<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<!-- css 호출 -->

	<head>
	
		<link href="/frontendProject/css/index.css" rel="stylesheet">
	</head>


	<h2>헤더 입니다</h2>
	<ul class="head_menu">
		<li> <a href="/frontendProject/index.jsp">home</a></li> <!-- a태그 이용한 링크(다른페이지 이동) -->
		<li> <a href="/frontendProject/kiosk/kiosk.jsp">키오스크</a></li> <!-- a태그 이용한 링크(다른페이지 이동) -->
		<li> <a href="/frontendProject/board/list.jsp">게시판</a></li> <!-- a태그 이용한 링크(다른페이지 이동) -->
		<li> <a href="/frontendProject/calendar/calendar.jsp">캘린더</a></li> <!-- a태그 이용한 링크(다른페이지 이동) -->
	
	
	</ul>
	
	<!-- http: 404 - 찾을 수 없음 // 페이지를 찾지 못하였다(경로문제, 오타, 존재하지 않는 파일

		절대경로
			로컬(pc)기준 절대경로 : c:\user\~~~~~~~~~~~~ full
			서버기준 절대경로 : http://192.168~~~~~~ full
				http:// ip주소:포트번호
				port : 내부망 접속 경로
				- 프로젝트명 -> 파일
				
		상대경로 (헤더에서는 사용 불가 / 모든 페이지에서 동일하게 작동해야 함)
			현재 파일 기준 [ ]
	-->

	<!-- js 호출 -->
		<script src ="/frontendProject/js/index.js" type="text/javascript"></script>
