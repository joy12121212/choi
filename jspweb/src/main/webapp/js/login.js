function login(){
	console.log('f로그인js들어왓냐')
	
	
	//입력 받은 아이디, 비밀번호 가져온다
	
	
	// ajax에게 전달해서 회원이 존재 하는지 반환 받는다.
		// 로그인 성공시  index.jsp 로 이동
		//		실패시	
	
	let mid = document.querySelector('.mid').value
	let mpwd = document.querySelector('.mpwd').value
	
	  $.ajax({
      url :  "/jspweb/MemberFindController",
      method : "post" ,   // get 메소드는 정송하는 data 노출=보안에 취약 // 
      data : {mid : mid , mpwd : mpwd} ,
      success : r => {
		  if(r){
			  alert('로그인성공')
			  location.href="/jspweb/index.jsp";
		  }
		  else{alert('로그인실패')
		  document.querySelector('.logincheckbox').innerHTML=`회원 정보가 없습니다`;
		  }
	  } ,
      error :  e => {e}
      });
	
	
	
	
}



/*

	get vs post
	
	get : http://localhost:8080/jspweb/MemberFindController?mid=~!@~&mpwd=~!@~!
	-> 정보 노출 됨
	- 추후에 다시 전송시 속도 빠름 / 캐시 남음
	- 보안 불가
	
	post : http://localhost:8080/jspweb/MemberFindController
	-? 정보 노출 안됨
	- 추후에 다시 전송시 속도 동일 / 캐시 안남음
	- 보안 가능





*/