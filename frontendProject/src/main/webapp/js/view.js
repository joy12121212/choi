// 1. list.js 에서 클릭된 게시물 번호 호출 [세션]
let no = sessionStorage.getItem('no');

//쿠키에 저장된걸 전역 변수에 담음
let boardList = JSON.parse(localStorage.getItem('boardList'));

console.log('ㅇㅇㅇ'+no)

onView();
// 2. 클릭된 게시물 번호의 게시물을 찾아서 출력
function onView(){
	
	let title = document.querySelector('.title')
	let writerdate = document.querySelector('.writerdate')
	let content = document.querySelector('.content')
	
	// 식별자 : 인덱스 , 게시물번호 = 인덱스 찾기
	for(let i = 0; i<boardList.length; i++){
		let b = boardList[i];
		if (b.no == no){
			console.log(b)
			// 대입
			title.innerHTML = b.title
			writerdate.innerHTML = `작성자 : ${b.writer} 작성일 : ${b.date}`;
			content.innerHTML = b.content
			break;	
		}//if
	}//for
}//함수

// 3. 삭제 버튼 [ 실행 조건 : 삭제 버튼 클릭시]
function onDelete() {//인수 필요 없음

	//1. 삭제할 게시물 찾기
	for ( let i =0; i<boardList.length; i++){
		// 2. 클릭된 게시물과 i 번째 게시물과 번호가 같으면
		if(no == boardList[i].no){
			//3. 삭제 하기
			boardList.splice(i , 1); //i 번째 인덱스 1개 삭제하기
			//배열에 변화된 결과를 쿠키에 반영 해야 된다
			localStorage.setItem('boardList' , JSON.stringify(boardList))
			// 게시물이 삭제 되었기 때문에 리무브 아이템(개별삭제) 활용하여 no 지워준다
			sessionStorage.removeItem(no)
			//리스트 화면으로 화면 전환
			location.href="list.jsp"
			break;
		}
	}
}







