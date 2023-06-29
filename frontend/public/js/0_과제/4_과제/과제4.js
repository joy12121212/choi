/*
	과제4
	
	1. 저장
		누가 작성했는지 = 작성자
		무엇 작성했는지 = 제목
		게시판 작성자 식별 방법 = 비밀번호 [ 동명이인 가능성 있기에]

	2. 무엇을 입력하도록 요구 할것인가
		작성자, 제목, 내용, 비밀번호
			
	3. 기능 상태 데이터 자장
		1. 작성일 = 등록기능이 실행된 시간상태 저장
		2. 조회수 = 해당 게시물 조회 기능 실행된 상태 저장
		
	4. 데이터 구조 구성 = js
		변수, 배열, 객체
		1. 여러개 데이터 저장하기 위해 ( 배열 vs 객체 )
		2. 게시물 1개 = 객체 => 게시물(객체) 여러개 저장공간 => 배열 저장
			// 같이 작업할 경우 미리 배열명이나 겹치는 변수명 조율 해서 오류를 최소화 하자
	기능 설계
	1. 글등록 기능 = 함수/행동			= onWrite()		: C reate
	2. 글 전체 출력 기능 = 함수/행동		= onPrint()		: R ead
	3. 글 개별 출력 기능 = 함수/행동		= onView()		: U pdate
	4. 글 삭제 기능  = 함수/행동			= onDelete()	: D elete
	

ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

작업 순서

1. onWrite()

	1. 등록에 필요한 데이터 입력받은 html 구성 [ 작성자, 비밀번호, 제목, 내용]
	2. 입력받은 데이터를 등록했을때 이벤트 구성
		1) 언제 이벤트 실행 ? ? -> 버튼 클릭시 -> 버튼을 만들자
		2) 이벤트 상세 정보 -> onclick 필요/ 함수 만들어라
	3. 함수 정의
		1) 사용자에게 입력받은 데이터  ( input value ) 호출
			document.querySelector(식별자).value
		2) 

2. onPrint()
	1. 출력 필요한 HTML 구성 [ 테이블 ] 
	2. 출력 이벤트 구성 
		1. 언제 이벤트 실행 ??? 1.입장했을때(JS열렸을때만 / 2.등록할때마다 3.삭제될때마다 4.수정될때마다 5.조회수증가할때마다 )
		 	- 다시 출력해주는 이유 => 변화가 있으니까 화면 업데이트/새로고침 => 렌더링
	 	2. 함수 상세 정의
	 		function onPrint(){}
	3. 출력 
		저장 : 객체 생성 { } -> 배열 저장 [ ] 
		출력 : 배열 호출 [ ] -> 객체 호출  .
	
		1. 반복문을 이용한 배열내 하나씩 객체 호출 
			for( let i = 0 ; i<boardlist.length ; i++ ){
				let board = boardlist[i];
			}
		
		2. 객체내 정보를 HTML형식으로 구성 
		
		
3. onView()
	1. 개별출력 필요한 html 구성 [div]
	2. 개별출력 이벤트구성
		1) 언제 이벤트 실행 ? 게시물의 제목을 클릭 할때 발생
		
		2) 함수 상세 정의
			function onView(){}		
	3. 함수 정의
		내용 , 작성자 , 제목 = 1개 출력하고 싶은데 => 객체1개 => 배열내 몇번째 인덱스??????
		1. 클릭한 제목의 해당하는 객체의 인덱스(식별가능=중복없음)를 인수로 전달
		 	onclick="onView( ${ i } )" : i번째 인덱스의 객체를 클릭했다는 증거 
	 	2. function onView( index ){}

		3. 배열내 출력하고자하는 객체의 위치[인덱스]의 정보 출력 
				1. 어디에 출력할껀지 ???? div
				2. div 무엇을 대입/출력 할껀지 ??? 인수로 전달받은 인덱스에 해당하는 객체정보
				3. 대입
		4. 조회수 
			1. 인수로 전달받은 인덱스 객체의 view 속성의 값을 1증가
				board.view++   /  
				board.view += 1  / 
				board.view = board.view+1
			2. 메모리(JS)의 변화( 객체/배열 ) 있으면 HTML 반영 	

	4. onDelete()
		1. 삭제 필요한 HTML 구성 [ button ] 
		2. 삭제 이벤트 구성 
			1. 언제 이벤트 실행 ??? 삭제 버튼을 클릭했을때
				<button onclick="onDelete()">삭제</button>
			2. 함수 정의
				function onDelete(){}
	
		3. 함수 정의 
			누구를 개별적으로 삭제할껀지??? 현재 개별출력으로 보고 있는 객체을 배열에서 삭제
			1. 삭제할 객체의 인덱스 번호 = 현재 개별출력 보고 있는객체 = 내가 제목을 클릭한 객체 
			 		index			<=			index		<=	i
			2. 인덱스를 인수로 받자
			
			3. 삭제할 객체의 비밀번호와 입력받은 비밀번호가 일치하면 [ 로그인 비슷 ]
				만약에 일치하면 삭제 아니면 삭제불가
				
			4. 배열내 해당 객체 삭제 
			
			5. 새로 고침 			
			
			
			
			
			
			
			
*/
let boardlist = [];

onPrint()

//1. 등록 함수
function onWrite(){	

	
	// 입력 받은 데이터 호출
	
	let write = document.querySelector('#write').value;
	let pass = document.querySelector('#pass').value;
	let title = document.querySelector('#title').value;
	let content = document.querySelector('#content').value;
	
	
		//날짜 모양 변경
	let now = new Date(); // 1 현재 시스템(pc)의 날짜/시간 호출
	let year = now.getFullYear();		// 현재 연도
	let month = now.getMonth();			// 현재 월 0~11월 [+1 해줘야된다]
	let week = now.getDay();			// 현재 요일 [0 일 1 월 2 화~ ]
	let day = now.getDate();			// 현재 일 
	let hour = now.getHours();			// 현재 시
	let minute = now.getMinutes();		// 현재 분
	let second = now.getSeconds();		// 현재 초
	//이거 없어도 실행되게 아래에 바로 때려 박음
	
	
	
	// 게시물 1개당 객체 1개 선언
	let board = {write : write , pass : pass ,title : title , content : content ,
					date : 
					`${now.getFullYear()}년 
					 ${now.getMonth()+1}월
					 ${now.getDate()}일
					 ${now.getHours()}시간
					 ${now.getMinutes()}분
					 ${now.getSeconds()}초
					  ` 
					  , view : 0}
	console.log('객체 생성 확인' + board); // 잘 작동하니
	
	//유효성 검사는 푸시 전에 해야 된다
	
	boardlist.push(board); // 푸시

	onPrint()
	
}console.log(boardlist);


//2. 출력 함수
function onPrint() {console.log('나오냐2')

	//1. 어디에 출력 할건지 ? 
		let boardTable = document.querySelector('.boardTable')
	//2. 테이블에 무엇을 대입, 출력 할건지 ?? tr 한줄씩 출력
	
	let html =`<tr> <th> 번호 </th> <th>제목</th> <th>작성일 </th> <th>조회수</th> </tr>`
	//3. 

	//배열 내 순차적으로 하나씩 열어보자
		for( let i = 0 ; i<boardlist.length ; i++ ){

			let board = boardlist[i];	// i번째 배열 인덱스의 객체 호출 
			// 로그인=비교=if		// HTML출력 => HTML 구성 

			html += `<tr>
						<td> ${ i+1 } </td>  
						<td onclick="onView(${i})"> ${ board.title } </td> 
						<td> ${ board.date } </td> 
						<td> ${ board.view } </td>
					</tr>`
		} // for end 
		boardTable.innerHTML = html;
		
}// 함수 끝

function onView( index ){console.log('onView() 함수' + index)

		let viewbox = document.querySelector('#viewbox')
		
		let board = boardlist[index]
		
		let html = 	`<h2>글보기 페이지</h2>
					<div>제목 : ${board.title}</div>
					<div>내용 : ${board.content}</div>
					<div>작성자 : ${board.write}</div>
					<button onclick="onDelete( ${ index } )">삭제</button>
					<button>수정</button>`
			viewbox.innerHTML = html;
	board.view++;
	onPrint()
}


// 4. 삭제함수 
function onDelete( index ){ console.log('onDelete()함수' + index )
	
	// 1. 배열내 삭제할 인덱스의 해당하는 객체 호출 
	let board = boardlist[index];
	
	// 2. prompt() 함수로 입력받은 값을 password 변수 에 저장 
	let passowrd = prompt('비밀번호 : ')
	
	// 3. 비교 [ 삭제할 객체내 비밀번호와 입력받은 비밀번호와 일치하면 삭제 성공 ] 
	if( board.pass == passowrd ){
		// 4. 배열내 해당 객체 삭제 
		boardlist.splice( index , 1 ); // 삭제할 인덱스번호부터 1개 삭제 
		// 5. 화면 새로고침 
		onPrint(); // 전체 게시물 출력 화면 새로고침 
		document.querySelector('#viewbox').innerHTML = `` // 삭제 하고 새로 고침
		alert('[삭제성공] 게시물이 삭제 되었습니다.')
	}else{ // 일치하지 않으면 
		alert('[삭제실패] 비밀번호가 틀렸습니다. ')
	}
}



























