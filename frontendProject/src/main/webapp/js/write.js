console.log('write.js 실행')
// 1. 썸머 노트 실행할대 사용되는 코드
$(document).ready(function() {
  $('#summernote').summernote({
	  
	  lang : 'ko-KR' ,   // 한글 적용 [한글.js cdn 필요]
	  height : 500,
	  placeholder : '여기에 내용작성'
  });
});
// 로그인제 게시판 
let loginId = 'soso'
/*
	스크립트는 html에서 포함된 문서
	- html 새로고침[F5] / 페이지 전환[a태그] 시 js도 재호출/메모리 휘발성/다 사라진다
	- 영구적인 저장 [ 서버 담당 = db ]
	- 브라우저 저장소 : 1. 세션 , 2. 쿠키
		- 세선 : 모든 브라우저가 꺼지면 초기화
		- 쿠키 : 모든 브라우저/os 꺼져도 데이터 보관 됨 / 직접 삭제 전까지 보관 됨

	- 사용방법 = 스크립트에서 객체 제공 = 키와 값으로 이루어진 객체
		- 자료형이 문자 타입으로만 저장 가능하다
		sessionStorage : 세선
			sessionStorage.setItem('데이터 이름' , 데이터)	// ( '키' , 값 )
			sessionStorage.getItem('데이터 이름')			// 저장된 값이 호출됨
			sessionStorage.clear()						// 삭제
						
		localStorage : 쿠키
			localStorage.setItem('데이터 이름' , 데이터)	// ( '키' , 값 )		
			localStorage.getItem('데이터 이름')			// 저장된 값이 호출됨
			localStorage.clear()						// 삭제
			
	- JSON : JS 객체 문법으로 구조화된 데이터를 표현하기 위한 문자 기반의 포멧[형식/자료형/타입]
		- 구조는 객체/배열인데 포멧[형식/자료형/타입]
		- 
			js : {id : 'qwe' , pw : 'qwed' }
			JSON : "{ id : 'qwe' , pw : 'qedd' }"  // 문자처리 " " 를 한다
		- 사용방법
			1. JSON.parse()			: 문자 타입을 객체/배열 타입으로 변환
			2. JSON.stringify()		: 객체/배열 타입을 문자 타입으로 변환
*/

// 1. 등록 함수 [ 실행조건 : 등록 버튼을 클릭 했을때]
function onWrite(){
	// 1. 입력 받은 값을 가져온다
	let title = document.querySelector('.title').value;
	let content = document.querySelector('#summernote').value;
	


// 3. 해당 객체/변수를 배열에 저장한다
	// 기존에 쿠키엣 게시물들이 저장된 게시물 배열 호출
let boardList = JSON.parse(localStorage.getItem('boardList'))	
	// 만약에 쿠키가 존재하지 않으면 // 숫자가 없으면 0 , 문자가 없으면 mull 또는 공백 // 객체가 없다는걸 null 표기
	if(boardList == null) boardList = [] // 쿠키가 없으면 빈배열 생성
	
	// 마지막 인덱스의 게시물에 해당하는 게시물 번호에 +1 더한 수	
let no = boardList.length ==0 ? 1 : boardList[boardList.length-1].no + 1
		// 게시물 길이가 0 이라면(게시물이 없다면) no 를 1로 , 0이 아니라면 no + 1


	//2번을 3번 밑으로 옮겼음
// 2. 입력받은 값이 여러개 이면 객체화
	let board = {
		title : title ,			// 입력받은 값 넣기
		content : content ,		// 입력받은 값 넣기
		no : no ,				// 게시물 번호 [ 마지막게시물 +1]
		date : `${new Date().getFullYear()}-${new Date().getMonth()+1}-${new Date().getDate()}`,
				// 연도								//월						//일
		view : 0 ,				// 조회수 기본 0 부터 시작
		like : 0 ,				// 추천 기본 0 부터 시작
		writer : loginId
	}
	console.log(board)	
	
	
	
	
	// 위에서 생성된 board를 bardList 저장
	boardList.push( board )
	// boardList를 다시 쿠키에 저장한다
	localStorage.setItem('boardList' , JSON.stringify(boardList))
	// 화긴
	console.log(JSON.parse(localStorage.getItem('boardList')))
	alert('글쓰기 성공')
		// html : <a href="경로"></a>  ★html에서 페이지 전환 방법★
		// js : location.href="경로"
	location.href='list.jsp' // ★스크립트에서 페이지 전환★
	
	
/*	
		// 함수 {} 안에 선언된 배열 : 지역 변수
		// 함수 {} 밖에 선언된 배열 : 전역 변수
		// 세션(서버)/쿠키(사용자pc) : 브라우저에 저장 하는 방식 / js 외 저장 가능 / js 새로고침해도 유지 됨
		
	sessionStorage.setItem( '세션' , 1 );
	localStorage.setItem( '쿠키' , 2 );
	
	console.log(sessionStorage.getItem('세션'));
	console.log(localStorage.getItem('쿠키'));
	*/
	
	
}