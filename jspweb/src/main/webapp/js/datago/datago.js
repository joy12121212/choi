console.log('datago js 실행')

/*

	공공데이터 선택 -> 활용신청 -> 요청 url 확인


*/

api1()
//1. 안산사 착한가격 업소 api 호출
function api1(){
	
	  $.ajax({
      url :  "https://api.odcloud.kr/api/15036759/v1/uddi:577ba1b9-b79f-4865-b31e-a9dc71ce67bc_201909231019?page=1&perPage=45&serviceKey=EWce%2FxRutcXCbbKAK3pNVRPnpm08LpVPTAZxgZuY8VALsdzbehRNCQVHOVQNCAwCLgpat3hHZhAe1%2FDks1m%2FhQ%3D%3D",
      method : "get" , 
      data : {} ,
      success : r => {
		  console.log(r)
		  let data = r.data;
		  console.log(data[0])
		  console.log(data[0].업소명)//data의 0번빼 데이터의 업소명 호출

		  // 1. 출력할 dom 객체
		  	let apiTable1 = document.querySelector('.apiTable1');
		  
		  // 2. html 구성
		  	let html=`		<tr>
					<th>번호</th>
					<th>상호명</th>
					<th>주소</th>
					<th>연락처</th>
					<th>대표메뉴1</th>
					<th>대표메뉴2</th>
					<th>대표메뉴3</th> </tr>`;
		  	
		  	data.forEach((d, i)=> {
				  html +=`	<tr>
					<td>${i+1}</td>
					<td>${d.업소명}</td>
					<td>${d.소재지도로명주소}}</td>
					<td>${d.연락처}</td>
					<td>${d.품목1}/${d.가격1}</td>
					<td>${d.품목2}/${d.가격2}</td>
					<td>${d.품목3}/${d.가격3}</td> 
					</tr>`
				  
			  })
		  // 3. 출력할 위치에  html 대입		  
		  apiTable1.innerHTML=html;
	  } ,
      error :  e => {e}
      });
}


/*
// 1. 접속한 브라우저의 gps 좌표 얻기 [ geolocation ]
navigator.geolocation.getCurrentPosition(pos=>{
	console.log(pos)

	let lat = pos.coords.latitude;
	let lng = pos.coords.longitude;
	console.log('lat' +lat)
	console.log('lng'+lng)
	
// 카카오 지도 출력
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(lat, lng), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(lat, lng); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);


})
*/
// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ카카오 지도 출력하는 객체ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 
        level : 14 // 지도의 확대 레벨 
    });

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ마커 이미지 설정ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

	var markerImageUrl = '/jspweb/img/1.png', 
	    markerImageSize = new kakao.maps.Size(40, 42), // 마커 이미지의 크기
	    markerImageOptions = { 
	        offset : new kakao.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
	    };

	// 마커 이미지를 생성한다
	var markerImage = new kakao.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);




// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ마커 클러스터러를 생성ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 10 // 클러스터 할 최소 지도 레벨 
    });
 
    // 데이터를 가져오기 위해 jQuery를 사용합니다
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
    $.get("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=EWce%2FxRutcXCbbKAK3pNVRPnpm08LpVPTAZxgZuY8VALsdzbehRNCQVHOVQNCAwCLgpat3hHZhAe1%2FDks1m%2FhQ%3D%3D", function(data) {
        console.log(data)

        var markers = $(data.data).map(function(i, position) {
			
			// i = 반복 인덱스
			// position = 목록내 하나씩 대입되는 반복변수명
			
			// 개별마커 생성 
			let marker = new kakao.maps.Marker({
				position : new kakao.maps.LatLng(position['위도(WGS84)'], position['경도(WGS84)']) ,
				img : markerImage,	// 마커 이미지
			 })
			// 생성된 마커 리턴
			
		// 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
		kakao.maps.event.addListener(marker, 'click', function() {
		    
		let html =``;
		
		html+= ` <div>충전소명 : ${position.충전소명}</div>`;
		html+= ` <div>충전기 타입 : ${position.충전기타입명}</div>`;
		html+= ` <div>운영기관 : ${position.운영기관명}</div>`;
		html+= ` <div>충전소 주소 : ${position.소재지도로명주소}</div>`;
		
		document.querySelector('.detailbox').innerHTML=html;


		});
			
			
           return marker;
        });

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
    });

/*

	아작스 간소화 #.get(url , ()=>{})   .post(url , {data} , ()=>{})


	- for 문
		- 배열명 : arrayList
		
		인덱스 0부터 배열 길이만큼
		1. for(let i =0; i<arrayList.length; i++){}
		
		배열의 첫번째 인덱스부터 마지막 인덱스까지
		2. for(let 반복변수 in arrayList){}		

		배열의 첫번째 데이터부터 마지막 데이터까지
		3. for(let 반복변수 of arrayList){}		
		
		배열의 반복변수 or 인덱스를 첫번째부터 마지막까지 [ 리턴 없음 ]
		4. 배열명.forEach((변수명)=>{})	
		
		배열의 반복변수 or 인덱스를 첫번째부터 마지막까지 [ 리턴 있음 ]		
		5. 배열명.map((변수명)=>{})
			배열명.map((변수명,인덱스)=>{})
			배열명.map((변수명,인덱스,배열명)=>{})
			let 새로운배열 = 배열명.map((변수명,인덱스)=>{return})


*/

let arrayList = ['a' ,'b', 'c', 'd']

for (let i = 0; i<arrayList.length; i++){console.log( i + arrayList[i])}
console.log("----------------------------------------")
for (let data1 in arrayList){console.log(data1)}
console.log("----------------------------------------")
for (let data2 of arrayList){console.log(data2)}
console.log("----------------------------------------")
arrayList.forEach((data3)=>{console.log(data3)})
console.log("----------------------------------------")
arrayList.forEach((data4,index4)=>{console.log(data4);console.log(index4)})
console.log("----------------------------------------")
arrayList.map((data5)=>{console.log(data5)})











