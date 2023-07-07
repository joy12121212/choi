console.log('list.js')

// 1 . 쿠키에 있는 배열 호출 [ 페이지 열리면]
let boardList = JSON.parse(localStorage.getItem('boardList'));
	// 쿠키나 세션에 저장된 객체/배열 '호출' 시에는 JSON.parse( )
	// 쿠키나 세션에 저장된 객체/배열 '저장' 시에는 JSON.stringify( )
if ( boardList == null )boardList = []

boardPrint()

// 게시물 출력 함수 [ 페이지 열리면]
function boardPrint(){
	// 1. 어디에 
	let tcontent = document.querySelector('.tcontent')
	// 2. 무엇을
	let html = ``
	// 3. 대입
		// html 구성 : 쿠키에서 꺼내욘 배열을 반복문 통해서 html 누적 하기
		for ( let i = 0; i < boardList.length; i++){
			let board = boardList[i]; // i번째 게시물 호출

		html+=`	<tr>
					<td> ${board.no} </td> <td onclick="onViewLoad(${board.no})"> ${board.title} </td> <td> ${board.writer}</td>
					<td> ${board.date} </td> <td> ${board.view} </td> <td> ${board.like} </td>				
				</tr>`
				
		}//for
	tcontent.innerHTML = html;
}

// 2. 상세 페이지 이동 [ 실행 조건 : 클린한 게시물 제목 ]
function onViewLoad( no ){// 인수 : 클릭한 제목(게시물의) 번호
	console.log('현재 클릭된 게시물의 게시물 번호' + no)
	// 클릭된 결과를 다른 페이지로 옮기는 방법
		// 스크립트는 페이지가 전환/새로고침 되면 초기화 됨
	sessionStorage.setItem('no' , no) // 클릭된 게시물 번호 세션에 저장

	increaseView(no) // 조회수 증가 함수

	location.href="view.jsp"
	
}

// 3 . 조회수 증가 함수 [ 실행 조건 : 제목 클릭 후 페이지 전환 전에 실행 ]
function increaseView( no ){
	// 1. 클릭된 게시물 번호 게시물 찾기
	for( let i = 0; i<boardList.length; i++){
		if(boardList[i].no == no){
			boardList[i].view++
			// 만약에 세선, 쿠키를 사용 중이라면 
			localStorage.setItem( 'boardList' , JSON.stringify(boardList));
			break;// 키 (호출명)		값(데이터)
		}//if
	}//for	
}











