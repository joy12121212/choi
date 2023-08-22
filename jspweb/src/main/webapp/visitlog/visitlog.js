console.log('js가 실행 됐읍니다');




// 1. Create
function vwrite(){
	
	// 1. html  input 태그 호출
	let vwriterInput = document.querySelector('.vwriter');
	console.log(vwriterInput)
	let vpwdInput = document.querySelector('.vpwd');
	console.log(vpwdInput)
	let vcontentInput = document.querySelector('.vcontent');
	console.log(vcontentInput)
	// 2. 객체화
	
	let info = {
		vwriter : vcontentInput.value ,
		vpwd : vpwdInput.value ,
		vcontent : vcontentInput.value
	}
	console.log(info);
	
	// 3. 유효성 검사
	
	// 4. ajax
	
	$.ajax({
		url : "/jspweb/VisitlogController",
		method : "post" , 
		data : info ,
		success : function f(r){console.log("통신성공");} ,
		error :  function f (r){}
	});
	
		// 5. 결과에 따른 코드
	
	
	
	
	
}//  vwrite

// 2. Read
function vpwd(){}

// 3. Update
function vupdate(){}


// 4. Delete
function vdelete(){}