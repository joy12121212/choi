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
blistAll();
function blistAll(){
	console.log('리스트 전체 출력 함수 실행')
	
	  $.ajax({
      url :  "/jspweb/BoardInfoController",
      method : "get" , 
      data :"" ,
      success : r => {console.log(r)
      
     	let boardTable = document.querySelector('.boardTable')
      	let html = `<tr>
						<th>글번호</th><th>카테고리</th><th>글제목</th>
						<th>작성자</th><th>조회수</th><th>작성일</th>
					</tr>`;
			// 서브릿으로부터 전달 받은 내용 [배열] 반복해서 html 전송
			// 배열명.forEach()
		r.forEach(b => {
			html+=`<tr>
						<th>${b.bno}</th><th>${b.bcname}</th><th>${b.btitle}</th>
						<th>${b.mid}/<img src="/jspweb/member/img/${b.mimg}"/> </th><th>${b.bview}</th><th>${b.bdate}</th>
					</tr>`;
			})//forEach

      	boardTable.innerHTML=html;
      } ,//suc
      error :  e => {e}
      });
	
}//blistAll

