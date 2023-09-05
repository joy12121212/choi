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
/* 게시물 조회 조건 객체 */

let pageObject = {type : 1 , bcno : 0 , listsize : 10 , page : 1}
	// type : 1 - 전체 조회 , 2 - 개별조회
	// bcno : 조회할 카테고리번호[기본값 전체보기]
	// listsize : 하나의 페이지에 최대 표시할 페이지 수 [기본값 10개]
	// page: 조회할 페이지 번호
function onCategory(bcno){
	console.log('카테고리넘버 bcno' + bcno)
	
	pageObject.bcno = bcno;
	blistAll(1);
}

// 한페이지 최대 표시할 개수를 변경했을때.

function onlistsize(){
	pageObject.listsize = document.querySelector('.listsize').value;
	blistAll(1);
}

// 게시물 조회
blistAll(1);
function blistAll(page){//page: 조회할 페이지 번호
	
	pageObject.page=page; // 현재 클릭된 페이지 번호 대입
	
	  $.ajax({
      url :  "/jspweb/BoardInfoController",
      method : "get" , 
      data :pageObject ,
      success : r => {
     				 /*게시물 출력*/
     	let boardTable = document.querySelector('.boardTable')
      	let html = `<tr>
						<th>글번호</th><th>카테고리</th><th>글제목</th>
						<th>작성자</th><th>조회수</th><th>작성일</th>
					</tr>`;
			// 서브릿으로부터 전달 받은 내용 [배열] 반복해서 html 전송
			// 배열명.forEach()
		r.boardList.forEach(b => {
			html+=`<tr >
						
						<td>${b.bno}</td><td>${b.bcname}</td><td><a href="/jspweb/board/view.jsp?bno=${b.bno}" onclick="viewUp()"> ${b.btitle}</a></td>
						<td>${b.mid}/<img src="/jspweb/member/img/${b.mimg}" width="50px"/> </td><td>${b.bview}</td><td>${b.bdate}</td>
					</tr>`;
			})//forEach

      	boardTable.innerHTML=html;
      				/*게시물 출력*/
      				
      				/*페이지 번호 출력*/
      	html=``; // 위에서 사용한 html 초기화
      	
      		// 이전버튼 / 1보다 작아지면 페이지-1
      	html +=`<button type="button" onclick="blistAll(${page<=1 ? page : page-1})"> < </button> <!-- 이전 버튼 -->`
		
		console.log('토탈페이지 : ' + r.totalpage)
		
 			// 페이지 번호 버튼
		for(let i = 1; i <=r.totalpage; i++){
			//만약에 현재페이지와 i번째 페이지와 일치하면 버튼 태그에 class="selectpage" 추가

			html +=	`<button class="${page==i ? 'selectpage':''}" onclick="blistAll(${i})" type="button"> ${i} </button> <!-- 이전 버튼 -->`}
  			
			// 다음 버튼			  
		html +=		`<button type="button" onclick="blistAll(${page>=r.totalpage ? page : page+1})"> > </button> <!-- 다음 버튼 -->`
   
       	document.querySelector('.pagebox').innerHTML=html;
      				
      				/*게시물 수 출력*/

		let boardcount = document.querySelector('.boardcount');
		
		boardcount.innerHTML=`총 게시물 수 :${r.totalsize} `

				

      				
      } ,//suc
      error :  e => {e}
      });
	
}//blistAll










/*

	http url 에 매개변수(파라미터) 전달 [ 쿼리 스트링 방식]
	- 페이지 전환시 매개변수(pk,식별) 전달
	url ? 변수명 = 데이터
	url ? 변수명 = 데이터 & 변수명 = 데이터 
	<a href="/jspweb/board/view.jsp?bno=${b.bno}">
	http://localhost:80/jspweb/board/view.jsp?bno=3
		- 정의 : 페이지 전환시 매개변수(pk) 전달

	- url 에서 매개변수 호출
		// new URL(location.href).searchParams.get("매개변수명")

*/





