console.log('write js 왔음')

/* 썸머노트 실행 */
$(document).ready(function() {

	let option = { // 썸머노트 옵션관련 객체 만들기 
		lang : 'ko-KR' , 
		height : 500 , 
		placeholder : '여기에 내용작성'
	}
	
	$('#summernote').summernote( option );
  
});







function bwrite(){
	//1 form 가져오기
	let form = document.querySelectorAll('.writeform')[0];
	
	//2 form 객체화
	let formData = new FormData(form);
	
	//3 ajax
	
	      //3. ajax에게 첨부파일 전송 하기
       $.ajax({
         url :  "/jspweb/BoardInfoController",
         method : "post" , 
         data : formData ,
         contentType : false,
         processData : false,
         success : r => {
			if(r==true){
				alert('게시물 등록 완료')
				location.href="/jspweb/board/list.jsp"
			}
			else{alert('게시물 등록 실패')}
         } ,
         error :  e => {e}
         });
         //첨부파일 있을경우 json 방식 불가 , form 객체 전송 타입으로 변환해야된다
	
	
	
}