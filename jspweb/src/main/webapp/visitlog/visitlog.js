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
		success : function f(r){console.log("통신성공");
			if(r == true){
				alert('등록 성공'); vread(); // 등록 성공 했을때 목록 호출
				
				vwriterInput.value='';
				vpwdInput.value='';
				vcontentInput.value='';				
			}
			else{alert('등록 실패');}
		} ,
		error :  function f (r){}
	});
	
		// 5. 결과에 따른 코드
	
	
	
	
	
}//  vwrite

// 2. Read
vread(); // 스크립트 열릴때 최초 1회  목록 호출
function vread(){ // 실행 조건 : js 열릴때, 등록, 수정, 삭제 - > 최신화 필요 함 계속 열려
	
		$.ajax({
		url : "/jspweb/VisitlogController",
		method : "get" , 
		data : "" ,
		success : function f(r){console.log('vread 콘솔 돌아간다')
			console.log(r)
			// 응답 받은 체를 HMTL에 출력
			// 1. 어디에 HTML 출력 ? 
			let output = document.querySelector('.visit_Bottom')
			// 2. 무엇을 출력할건지 반복문으로 HTML 형식으로 만들건지
			let html =``;
			
				for(let i = 0; i<r.length;i++){
					html +=`			
					<div class="visitbox">
						<div class="visitbox_top">
							<div> ${r[i].writer}</div>
							<div class="visitdate"> ${r[i].date}</div>
						</div>
			
						<div class="visitvox_center">${r[i].content}</div>
			
						<div class="visitvox_bottom">
							<button type="button">수정</button>
							<button type="button">삭제</button>
						</div>
					</div>`
				}
			output.innerHTML = html;
			
			
			// 3. 출력객체 HTML 형식 대입
		} ,
		error :  function f (r){}
	});
	
	
	
}

// 3. Update
function vupdate(){
	alert('수정 성공'); vread(); // 등록 수정 했을때 목록 호출
}


// 4. Delete
function vdelete(){
	alert('삭제 성공'); vread(); // 등록 삭제 했을때 목록 호출
}