
let loginState = false; // 로그인 상태 확인하는 스위치 변수 // true -로그인 , false - 비로그인
// 얘는 헤더에 있기 때문에 모든 페이지에서 사용된다 편리


// 현재 로그인된 회원정보 
getMemberInfo();
function getMemberInfo(){
		console.log('겟멤버 인포 돌아감')
	  $.ajax({
      url :  "/jspweb/MemberInfoController",
      method : "get" , 
      data : {type : "info"} ,
      success : r => {console.log(r)
      let submenu = document.querySelector('.submenu')
      let html = ``;
      	if(r==null){
			  html +=`
			<li> <a href="/jspweb/member/signup.jsp">회원가입</a> </li>	
			<li> <a href="/jspweb/member/login.jsp">로그인</a> </li>			  
			  `			
		}
		else{
			loginState = true;
			html +=`
			<li> ${r.mid}님 </li>	
			<li> <img class="himg" src="/jspweb/member/img/${r.mimg}"/></li>	
			<li> <a href="/jspweb/member/info.jsp">마이페이지</a> </li>
			<li> <a onclick="logout()" href="#">로그아웃</a> </li>
			`
		}
		submenu.innerHTML = html;
			
      } ,
      error :  e => {e}
      });
	
}

// 컨트롤러에서 doget 을 1개만 쓸거라면 data 에 type 줘서 구분해라
//로그아웃 함수 [ 서블릿에 세션을 삭제 / 로그아웃 성공시 메인 페이지로 이동]
function logout(){
	
	  $.ajax({
      url :  "/jspweb/MemberInfoController",
      method : "get" , 
      data : {type : "logout"} ,
      success : r => {console.log(r)
      alert('로그인이 필요합니다')
      	location.href="/jspweb/index.jsp"
      },
      error :  e => {e}
      });	
	
	
	
	
}