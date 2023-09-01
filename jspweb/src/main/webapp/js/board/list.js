console.log('list js 왔으요')
function onWrite(){
	if(loginState == true){// 만약에 로그인이면
		location.href="/jspweb/board/write.jsp"; 
		
	}
	else{// 만약에 비로그인이면
		alert('로그인 후 작성 가능 합니다')
		location.href="/jspweb/member/login.jsp"
	}

	
	
}

function write(){

	// form 가져오기
	// form 객체화 하기
	// ajax로 대용량 form 전송하기

}