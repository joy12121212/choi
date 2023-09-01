console.log('write js 왔음')

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
         success : r => {r} ,
         error :  e => {e}
         });
         //첨부파일 있을경우 json 방식 불가 , form 객체 전송 타입으로 변환해야된다
	
	
	
}