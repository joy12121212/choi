console.log('index js 실행 정상')

//findByPno(2);
//findByLatLng()
//findByAll();
// 1. N개 제품들을 최신순으로 출력 함수 


findByTop(20);//메인페이지에 최신 등록된 제품 10개 출력


function findByTop( count ) {
	$.ajax({
		url : "/jspweb/productInfoController" , method : "get" , 
		data : { type: "findByTop" , count : count } ,
		success : jsonArray => { console.log( jsonArray ) 
		
		let productBox = document.querySelector('.productBox')
		let html =``;
			jsonArray.forEach((p)=>{
				
				let firstImg = Object.values(p.imgList)[0];
				
				
				html+=`
				<div class="col">
				    <div class="card" style="height:450px; border: none;">
				      <a href="/jspweb/product/view.jsp?pno=${ p.pno }" >
				     	 <img src="/jspweb/product/img/${firstImg}" class="card-img-top" alt="..." style="height:300px; border-radius: 50px; box-shadow: 0px 0px 5px #e8e8e8;">
				      </a>
				      <div class="card-body">
				        <h5 class="card-title">${ p.pname }</h5>
				        <p class="card-text">
				        	<div> ${ p.pcontent } </div>
				        	<div> ${ p.pprice.toLocaleString() }원 </div>
				        </p>
				      </div>
				    </div>
				  </div>`
				
			})
		productBox.innerHTML=html;		
		},
		error : e=>{console.log(e)}
	})
}

/*
// 2. 현재카카오지도내 보고있는 동서남북 기준내 제품들을 출력 함수 
function findByLatLng( east , west  ,  south  , north  ) {
	$.ajax({
		url : "/jspweb/productInfoController" , method : "get" , 
		data : { type: "findByLatLng" 	, 
				east :  east , west  : west ,  
				south  : south , north  :  north  
				} ,
		success : jsonArray => { console.log( jsonArray ) },
		error: e=>{console.log(e)}
	})
}


// 3. 선택된 제품번호에 해당하는 제품 출력 함수  // ★이거 view js 에서 갖다 썻음
function findByPno( pno ) {
	$.ajax({
		url : "/jspweb/productInfoController" , method : "get" , 
		data : { type: "findByPno" 	, pno : pno  } ,
		success : jsonObject => { console.log( jsonObject ) 
			location.href="/jspweb/product/item.jsp"
		},
		error: e=>{console.log(e)}
	})
}
// 4. 모든 제품들을 출력하는 함수 
function findByAll() {
	$.ajax({
		url : "/jspweb/productInfoController" , method : "get" , 
		data : { type: "findByAll" 	 } ,
		success : jsonArray => { console.log( jsonArray ) },
		error: e=>{console.log(e)}
	})
}
*/

/*
	자바스크립트 객체
		형태 : let 변수명 = {속성명 : 데이터 , 속성명 : 데이터 }
			- 데이터 : 데이터 ,변수
			객체명.새로운속성명 = 데이터
			
	자바스크립트 배열/리스트
		형태 : let 변수명 = [데이터 ,데이터, 데이터]		
			배열명.push(데이터)
			배열명.splice(인덱스, 개수)
			배열명[인덱스]
			
			
			
			
			
*/