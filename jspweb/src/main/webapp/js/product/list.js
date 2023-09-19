



var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
    center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
    level : 12 // 지도의 확대 레벨
});


var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
    minLevel: 10, // 클러스터 할 최소 지도 레벨
    disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
});



        
getInfo();
function getInfo() {

    let 동 = map.getBounds().oa; console.log( "동:"+동 ) // 동
    let 서 = map.getBounds().ha; console.log( "서:"+서 )// 서
    let 남 = map.getBounds().qa; console.log( "남:"+남 )// 남 
    let 북 = map.getBounds().pa; console.log( "북:"+북 )// 북 
	
	findByLatLng(동 , 서 , 남 , 북);

}
    // 현재 카카오 지도내 보고있는 동서남북 기준내 제품들 출력
function findByLatLng(east , west , south , north){
	clusterer.clear();
	console.log(east)
	$.ajax({
		url : "/jspweb/productInfoController",
		method : "get",
		async : false,
		data : {type : "findByLatLng" , east : east , west : west , south : south , north : north},
		success : jsonArray =>{console.log(jsonArray)
		
			//마커 생성해서 클러스터에 저장
			var markers = jsonArray.map((p) => {
				return new kakao.maps.Marker({
					position: new kakao.maps.LatLng(p.plat, p.plng)
				});
			});	
			// 클러스터러에 마커들을 추가합니다
			clusterer.addMarkers(markers);
			
			
			// 사이드바에 제품 출력
			let sidebar = document.querySelector('.sidebar')
			let html = ``;
			
				jsonArray.forEach ((p)=> {
					
						html+=`<div class="card mb-3" style="max-width: 540px;">	
							  <div class="row g-0">	
							    <div class="col-md-5">
							    	<a href="/jspweb/product/view.jsp?pno=${ p.pno }" >
							      		<img src="/jspweb/product/img/${ Object.values(p.imgList)[0] }" class="img-fluid rounded-start" alt="...">
							    	</a>
							    </div>
							    <div class="col-md-7">
							      <div class="card-body">
							        <h5 class="card-title">${ p.pname }</h5>
							        <p class="card-text">
							        	<div> ${ p.pcontent } </div>
							        	<div> ${ p.pprice.toLocaleString() } 원 </div>
							        </p>
							      </div>
							    </div>
							  </div>
							</div>`
					
				})		
			sidebar.innerHTML=html;
			
		},
		error: e => { console.log(e) }
	})
}
    
    
// 3 카카오 지도에서 드래그를 하고 끝났을때   1번함수 재실행
kakao.maps.event.addListener(map, 'dragend', function(){getInfo()});




