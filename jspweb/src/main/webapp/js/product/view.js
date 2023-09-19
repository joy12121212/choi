
// 게시판 상세페이지, 제품 상세페이지 등등에서는 클릭된 제품번호[식별자-제품번호] 전달

// url 에서 매개변수(쿼리스트링) 가져오기
let pno = new URL(location.href).searchParams.get("pno")

findByPno( pno )
// 1. pno 에 해당하는 제품1개 출력
function findByPno( pno ) {
	$.ajax({
		url : "/jspweb/productInfoController" , method : "get" , 
		data : { type: "findByPno" 	, pno : pno  } ,
		success : jsonObject => { console.log( jsonObject ) 
			
			// 캐러셀에 이미지 여러개 대입
			let imgbox = document.querySelector('.imgbox');
			let html =``;
			
			Object.values(jsonObject.imgList).forEach((img,i)=>{
				
				html +=`				
					<div class="carousel-item ${i==0 ? 'active' : ''}">
						<img src="/jspweb/product/img/${img}" class="d-block w-100" alt="...">
					</div>
				`
			})
			imgbox.innerHTML=html;
			
			
			// 각 위치에 데이터 넣어주기
			
			document.querySelector('.mid').innerHTML=`판매자 : ${jsonObject.mid}`;
			document.querySelector('.pcname').innerHTML=`카테고리 : ${jsonObject.pcname}`;
			document.querySelector('.pdate').innerHTML=`등록일 : ${jsonObject.pdate}`;
			document.querySelector('.pname').innerHTML=`제목 : ${jsonObject.pname}`;
			document.querySelector('.pprice').innerHTML=`가격 : ${jsonObject.pprice}`;
			document.querySelector('.pcontent').innerHTML=`내용 : ${jsonObject.pcontent}`;
			
			
			
			
			
			
			
		},//success
		error: e=>{console.log(e)}
	})
}

