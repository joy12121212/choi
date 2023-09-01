console.log('list js 왔으요')
blistAll();
function onWrite(){
	if(loginState == true){// 만약에 로그인이면
		location.href="/jspweb/board/write.jsp"; 
		
	}
	else{// 만약에 비로그인이면
		alert('로그인 후 작성 가능 합니다')
		location.href="/jspweb/member/login.jsp"
	}

	
	
}
blistAll();
function blistAll(){
	console.log('리스트 전체 출력 함수 실행')
	
	  $.ajax({
      url :  "/jspweb/BoardInfoController",
      method : "get" , 
      data :"" ,
      success : r => {r
      
      	let output = document.querySelector('.bprint')
      	let html = ``;
      	
      	for (let i = 0; i < r.length; i++){
			  html +=`
			  <th>${r[i].bno}</th><th>${r[i].btitle}</th><th>${r[i].bmno}</th>
			  <th>${r[i].bdate}</th><th>${r[i].bview}</th>
			  `
		  }//for
      	output.innerHTML=html;blistAll();
      } ,//suc
      error :  e => {e}
      });
	
}//blistAll

