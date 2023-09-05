console.log('뷰 js 실행 함')

// 1. list.jsp 에서 클릭된 제목의 bno를 전달받아 게시물 1개 가져오기
getBoard();
function getBoard(){
			console.log("getBoard 실행 함")
	// url에 있는 매개변수 ( 쿼리스트링 ) 가져오기
		// 현재 주소상의 매개변수 가져오기
	let urlParams = new URL(location.href).searchParams
		console.log("urlParams : " + urlParams)
	let bno = urlParams.get("bno");
		// new URL(location.href).searchParams.get("매개변수명")
		console.log(" bno : " +bno)
		
	// ajax 이용한 bno 전달해서 게시물의 상세 정보 모두 가져오기

       $.ajax({
         url :  "/jspweb/BoardInfoController",
         method : "get" , 
         data : {type : 2 , bno : bno} ,
         success : r => {
			// 어디에
         	let boardBox = document.querySelector('.boardBox')
         	
         	//html 구성
         	let html = `
         	
				부가정보 : <div>${r.bcname} ${r.bview} ${r.bdate}</div>
				부가정보2 : <div>${r.mid} <img src="/jspweb/member/img/${r.mimg}" width="50px"/></div>
				제목 : <div>${r.btitle}</div>
				내용 : <div>${r.bcontent}</div>
				첨부파일 : <div>${r.bfile}</div>

				`
         	html+=`<a href="list.jsp"><button type="button">목록보기</button></a>`
				if(r.ishost){
					
					html+=`
					<button onclick="onupdate(${r.bno})" type="button">수정</button>
					<button onclick="ondelete(${r.bno})" type="button">삭제</button>`
				}
         	boardBox.innerHTML=html;
         } ,
         error :  e => {e}
         });	
}//getBoard end



// 게시물 수정 페이지로 이동
function onupdate(bno){
	console.log('게시물 수정 함수 실행')
	// 수정페이지로 이동 // 게시물번호 넘겨야됨
	location.href=`/jspweb/board/update.jsp?bno=${bno}`;
	
	
}

//글 삭제 함수
function ondelete(bno) {	
	console.log('글 삭제 함수 실행')
	
	console.log('글삭제 bno 값'+bno)

	
	  $.ajax({
      url :  "/jspweb/BoardInfoController",
      method : "delete" , 
      data : {bno : bno} ,
      success : r => {
      	if(r){
			  alert('삭제성공')
			  location.href="/jspweb/board/list.jsp"
		  }else{
			  alert('삭제실패')
		  }
      
      } ,
      error :  e => {e}
      });

}//ondelete

