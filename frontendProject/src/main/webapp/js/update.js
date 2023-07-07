console.log('write.js 실행')
// 1. 썸머 노트 실행할대 사용되는 코드
$(document).ready(function() {
  $('#summernote').summernote({
	  
	  lang : 'ko-KR' ,   // 한글 적용 [한글.js cdn 필요]
	  height : 500,
	  placeholder : '여기에 내용작성'
  });
});

// 2. 수정할 게시물 = 클릭된 게시물 = 내가 보고있는 게시물 [ 세션에 저장 되어있음 ]
let no = sessionStorage.getItem('no'); console.log(no)
let boardList = JSON.parse(localStorage.getItem('boardList')); console.log(boardList)

onView(); // 먼저 보여줘야 한다
// 3. 수정할 게시물 출력 한다
function onView(){
	// 1. 어디에 [ input , textarea = value // h , p = value 가 없다]
	let title = document.querySelector('.title')
	let content = document.querySelector('#summernote')

	// 2. 무엇을 [ 클릭된 게시물의 정보 1개 ]
	for( let i = 0; i<boardList.length; i++){
		let b = boardList[i]
		if(b.no == no){
			title.value = b.title
			content.value = b.content
			break;
		}
	}
	// 3. 출력 / 대입
	
}


// 4. 수정하기 버튼 [ 실행 조건 : 수정 버튼 클릭시]
function onUpdate(){

	// 누구를 = 현재 보고 있는 게시물
	
		for( let i = 0; i<boardList.length; i++){
		let b = boardList[i]
		if(b.no == no){
				// 새로운 값
			let title = document.querySelector('.title').value;
			let content = document.querySelector('#summernote').value;
			// 수정한거 대입
			b.title = title
			b.content = content
			// * 쿠키나 세션을 사용중이라면 같이 적용 시켜줘야 한다
			localStorage.setItem('boardList' , JSON.stringify(boardList))
			// 알림, 페이지 전환
			alert('수정 완료')
			location.href="view.jsp";
			break;
		}//if
	}//for
}// 함수

// 5. 조회수 증가 [ 실행 조건 / 제목 클릭 이벤트 발생시 조회수 ++]

//summernote onclick - 변수 지정해서 기본값 0 클릭시마다 ++
//board view 여기에 대입 시킨다
















