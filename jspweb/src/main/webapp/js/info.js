
// 0. 로그인된 회원의 정보
getInfo();
function getInfo(){
	console.log('겟인포 왓나')
	  $.ajax({
      url :  "/jspweb/MemberInfoController",
      method : "get" , 
      data : {type : "info"} ,
      success : r => {
	      if(r==null){//비로그인 상태
			  alert('회원전용 페이지 입니다[로그인 페이지]로 이동 합니다')
			  location.href="/jspweb/member/login.jsp";
			  }
	      else{//로그인 상태
			  document.querySelector('.preimg').src=`img/${r.mimg}`;
			  document.querySelector('.mid').innerHTML=r.mid;
			  document.querySelector('.memail').innerHTML=r.memail;		  
			  }
	      } ,
      error :  e => {e}
    });
}


// 1. 수정
function mupdate(){
	console.log('정보수정함수 돌아간다')
	
	let form = document.querySelectorAll('.signupForm')[0];
	
	let formdata = new FormData(form)	// 첨부파일시 필수 [ 대용량 데이터 ]
			console.log('정정보수정함수에서 '+ formdata)
			//3. ajax에게 첨부파일 전송 하기
	    $.ajax({
	      url :  "/jspweb/MemberInfoController",
	      method : "put" , 
	      data : formdata ,
	      contentType : false,
	      processData : false,
	      success : r => {console.log('사인업 통신 성공?')
	      
	      if(r){
			  alert('정보수정 성공'); logout();
		  }
	      else{
			  alert('정보수정 실패')
		  }
	      
	      } ,
	      error :  e => {e}
	      });
}


// 2. 탈퇴
function mdelete(){
	console.log('mel 작동함') 
	
	
	let dconfirm = confirm('정말탈퇴?');
	
	if(dconfirm == true){
		let mpwd = prompt('비밀번호확인')
		//로그인된 회원 번호와 입력받은 비밀번호와 일치하면 탈퇴 성공
		console.log('비밀번호들어온거확인'+mpwd)
	  $.ajax({
      url :  "/jspweb/MemberInfoController",
      method : "delete" , 
      data : {mpwd : mpwd} ,
      success : r => {r
      	if(r==true){
			  alert('회원탈퇴 성공')
			  logout();
		  }
		else{alert('비밀번호가 다릅니다')} 
      } ,
      error :  e => {e}
      
      
      });
		
	}
	
	
	
	
	
	
	
	
}