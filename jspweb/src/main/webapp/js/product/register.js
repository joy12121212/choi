console.log('레지스터js 실행')

if(loginState == false){
	alert('로그인 해주세요')
	location.href="/jspweb/member/login.jsp";
}


//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅋ카ㅏ오 지도 표시ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//

	// 1. 현재 접속한 클라이언트의 위치 좌표 구하기
	navigator.geolocation.getCurrentPosition(position=>{
		console.log('뭐들었니'+position)
		console.log(position.coords)
		console.log(position.coords.latitude)
		console.log(position.coords.longitude)
		
		let currentlat = position.coords.latitude; 
		let currentlng = position.coords.longitude;
		
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(currentlat, currentlng), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    plat = latlng.getLat();
    plng = latlng.getLng();
    
	});
})

let plat = 0;	// 현재 카카오 지도에서 선택한 좌표
let plng = 0;


// 제품 등록
function onRegister(){
	// 1. form dom 객체 호출
	let registerForm = document.querySelectorAll('.registerForm')[0];
	let formdata = new FormData(registerForm);
	console.log(formdata)
	
	
		// 카카오 지도에서 선택된 좌표 사용했을때
		if(plat == 0 || plng == 0){
			alert('제품위치를 선택해주세요'); return;
		}
		formdata.set('plat' , plat)
		formdata.set('plng' , plng)
	
	
	
		// 드래그 앤 드랍 사용할때
			// 현재 드랍된 파일들을 form 같이 추가하기 [ 드랍된 파일은 input 에 들어가는게 아님]
	
	if(fileList.length >= 1){ // 드랍된 파일이 존재 하면
		fileList.forEach(e=>{
			// 폼 데이터 객체에 데이터 추가//formdata.set( 키 , 값 )
			// 폼 데이터 객체에 데이터 여러개 추가
			formdata.append('fileList' , e);
		})
		
	}
	
	
	$.ajax({	
		url : "/jspweb//productInfoController",
		method : "post",
		data : formdata,
		contentType : false,
		processData : false,
		success : result => {console.log(result)
			if(result==true){alert('제품등록성공'); location.href="/jspweb/index.jsp"}
		
		}
	});
	
	
}

// 드래그 앤 드랍
	// 1. 드래그 앤 드랍 할 구역 dom 객체 호출
let fileDropBox = document.querySelector('.fileDropBox');

	// 2. 해당 dom 객체 구역내 드래그 들어올때
fileDropBox.addEventListener("dragenter" ,(e)=>{ // e 는 ? dragenter 결과물/반환값
	console.log("드래그 들어옴")
	e.preventDefault(); //-> 브라우저 이벤트 무시하고 내꺼 씀
} )
	// 3. 해당 dom 객체 구역내 드래그가 올라와 있는중
fileDropBox.addEventListener("dragover" , (e)=>{
	console.log("드래그 위치중")
	e.preventDefault(); //-> 브라우저 이벤트 무시하고 내꺼 씀	
	fileDropBox.style.backgroundColor='#e8e8e8';
})

fileDropBox.addEventListener("dragleave" , (e)=>{
	console.log("드래그 나갔어")
	e.preventDefault(); //-> 브라우저 이벤트 무시하고 내꺼 씀	
	fileDropBox.style.backgroundColor='#ffffff';
		
})

fileDropBox.addEventListener('drop' , (e)=>{
	console.log("드래그 후 떨궈야지?")	
	//브라우저 자체 drop 이벤트 있어서 안먹힘
	// 해결방안 : 기존 브라우저 이벤트 무시
	e.preventDefault(); //-> 브라우저 이벤트 무시하고 내꺼 씀
	console.log(e.dataTransfer)
	console.log(e.dataTransfer.files)
	console.log(e.dataTransfer.files[0])
	console.log(e.dataTransfer.files[0].name)
	
	let files = e.dataTransfer.files;
	
	for(let i = 0; i<files.length; i++){
		if(files[i] != null && files[i] != undefined){
			//드랍된 파일의 정보가 존재한다면[null + nudefined]
			fileList.push(files[i]);
		}//if
	}//for
	// 3. 배경색 초기화
	fileDropBox.style.backgroundColor='#ffffff';
	// 4. 
	fileListPrint()
	
	
	
})

let fileList = []; // 현재 드래그앤드랍으로 등록된 파일 저장

// 3. 현재 드랍된 파일들의 저보를 구역에 표시하는 함수
function fileListPrint(){
	// 1. 어디에 fileDropBox에 
	// 2. 무엇을 html 구성
	
	let html = ``;
	fileList.forEach((f , i)=>{
		let fname = f.name; // 파일의 이름
		let size = (f.size/1024).toFixed(1); // 파일의 용랑[바이트로 줌] kb로 변환 필요
					//toFixed(소수점 몇자리까지) : 소수점자르기
		html +=`<div>
				<span>${fname}</span>
				<span>${size}</span>
				<span> <button onclick="fileDelete(${i}) type="button">삭제</button>
				</span>
				</div>`
	})
	fileDropBox.innerHTML=html;
}

function fileDelete(i){
	fileList.splice(i , 1);fileListPrint()
}









// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ드랍된 파일의 정보 ? ㅡㅡㅡㅡㅡㅡㅡ//
	// 1. 드랍된 데이터 정보를 이벤트 결과에서 찾기


/*

	dom 객체 이벤트 추가 방법
		가정 : 특정 구역에 클릭 이벤트 추가
		1. onclick = "함수()"

		2. .addEventListener('이벤트명' , 함수)
			let fileDropBox = document.querySelector('.fileDropBox');
			fileDropBox.addEventListener("onclick" , 함수)

	이벤트 
		종류 : click , keyup , keydown 등~
		- 정의 : 특정 조건을 충족하면 자동으로 발생, 발생한 이벤트 결과물을 반환



	드래그 앤 드랍 관련 이벤트
		1. dragenter
		2. dragover
		3. dragleave
		4. drop

*/







