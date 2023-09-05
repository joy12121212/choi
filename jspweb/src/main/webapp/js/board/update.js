// 수정할 게시물의 기존 정보를 보여주기


let bno = new URL(location.href).searchParams.get("bno");
getBoard()
function getBoard(){

	
	    $.ajax({
      url :  "/jspweb/BoardInfoController",
      method : "get" , 
      data : {type : 2 , bno : bno} ,
      success : r => {
		  document.querySelector('.bcno').value=`${r.bcno}`
		  document.querySelector('.btitle').value=`${r.btitle}`
		  document.querySelector('.bcontent').value=`${r.bcontent}`
		  document.querySelector('.oldfile').value=`${r.bfile}`
		  
	  } ,
      error :  e => {e}
      });
}

function onUpdate(){
	// 전체 정보 가져오기
	let formData = new FormData(document.querySelectorAll('.writeform')[0]);
	console.log("글수정 formData 값 : " + formData);
	
		// form 객체에 데이터 추가[ bno]  
		// form객체.set("변수명" , 값)
	formData.set("bno" , bno)
	      //3. ajax에게 첨부파일 전송 하기 // multipart
       $.ajax({
         url :  "/jspweb/BoardInfoController",
         method : "put" , 
         data : formData ,
         contentType : false,
         processData : false,
         success : r => {
			if(r){
				alert('게시물 수정 완료')
				location.href=`/jspweb/board/view.jsp?bno=${bno}`
			}
			else{alert('게시물 등록 실패')}
         } ,
         error :  e => {e}
         });
         //첨부파일 있을경우 json 방식 불가 , form 객체 전송 타입으로 변환해야된다
	
	
	
	
}