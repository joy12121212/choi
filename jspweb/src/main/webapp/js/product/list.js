



var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
    center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
    level : 14 // 지도의 확대 레벨
});


var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
    minLevel: 10, // 클러스터 할 최소 지도 레벨
    disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
});

// 마커 클러스터러에 클릭이벤트를 등록합니다
// 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
// 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {

    var level = map.getLevel()-1;
   map.setLevel(level, {anchor: cluster.getCenter()});
});   
    

        
getInfo();
function getInfo() {

    let 동 = map.getBounds().pa; console.log( "동:"+동 ) // 동
    let 서 = map.getBounds().qa; console.log( "서:"+서 )// 서
    let 남 = map.getBounds().ha; console.log( "남:"+남 )// 남 
    let 북 = map.getBounds().oa; console.log( "북:"+북 )// 북 
	
	findByLatLng(동 , 서 , 남 , 북);

}
    
function findByLatLng(east , west , south , north){
	console.log(east)
	$.ajax({
		url : "/jspweb/productInfoController",
		method : "get",
		async : false,
		data : {type : "findByLatLng" , east : east , west : west , south : south , north : north},
		success : jsonArray =>{console.log(jsonArray)
			var markers = jsonArray.map((p) => {
				return new kakao.maps.Marker({
					position: new kakao.maps.LatLng(p.plat, p.plng)
				});
			});	
			// 클러스터러에 마커들을 추가합니다
			clusterer.addMarkers(markers);
		},
		error: e => { console.log(e) }
	})
}
    
    
    
    
// 3 카카오 지도에서 드래그를 하고 끝났을때   1번함수 재실행
kakao.maps.event.addListener(map, 'dragend', function(){getInfo()});
















