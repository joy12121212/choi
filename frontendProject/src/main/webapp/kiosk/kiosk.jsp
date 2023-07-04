<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/frontendProject/css/kiosk.css" rel="stylesheet">

</head>
<body>
<%@include file="../header.jsp" %>



		
	<div class="kioskwrap"> <!-- 전체 -->
	
<!------------------------------헤더---------------------------------->	
		<div> <!--  광고 이미지가 표시되는 구역 -->
			<!--광고 이미지 -->
			<img class="himg" src="../img/main1.png">

			<!-- 카테고리 -->
			<ul class="categorymenu">
				<li class="categoryselect">신제품(New)</li>
				<li>프리미엄</li>
				<li>와퍼&주니어</li>
				<li>치킨&슈림프버거</li>
				<li>올데이킹&킹모닝</li>
			</ul>
		</div> <!-- 광고 이미지가 표시되는 구역 끝-->
<!------------------------------헤더---------------------------------->	

<!------------------------------본문---------------------------------->	
		<div class="kioskcontent"> 
			<div class="productbox"> <!-- 제품 구역 -->

				<div class="product"> <!-- product -->
					<img src="../img/헬로디아블로와퍼.png"/>
					<div class="pinfo"> <!-- pinfo -->
						<div class="pname">헬로 디아블로 와퍼</div>
						<div class="pprice">15,000원</div>
					</div><!-- pinfo -->
				</div> <!-- product -->
	
			</div> <!-- 제품 구역 -->
		

			<div class="cartbox"> <!-- 카트 구역 -->
				<div class="cartcontent"> <!-- 제품 개수, 총가격 -->

					<div class="carttop"> <!-- 위 -->
						<div> 카트 <span class="ccount">3</span></div>
						<div>총 주문금액 <span class="ctotal">30,000</span></div>
					</div><!-- 위 -->

					<div class="cartbot"><!-- 아래 -->
						<!-- 카트내 제품 1개 -->
						<div class="citem">
							<div class="iname">더블비프불고기버거</div> <!-- 제품명 -->
							<div class="iprice">12000원</div> <!-- 제품가격 -->
							<div class="icencel">x</div> <!-- 제품취소 -->
						</div>
					
					</div><!-- 아래 -->

				</div><!-- 제품 개수, 총가격 -->


				
				<div class="cartbtn">
				
				</div>
			
			</div> <!-- 카트 구역 -->
		</div><!-- 본문 : 카테고리, 제품, 장바구니 출력 구역-->
<!------------------------------본문---------------------------------->	

	</div> <!-- 전체 -->

			
<%@include file="../footer.jsp" %>
	
	
	
	<script src="/frontendProject/js/kiosk.js" type="text/javascript"></script>
</body>
</html>