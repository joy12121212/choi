console.log('키오스크열리니')

// 1. 광고이지미 변경
	// 1. 광고 이미지 여러개 = 배열
let bimhList = ['himg1.png' , 'himg2.png' , 'himg3.jpg' , 'himg4.png' , 'himg5.png']
	// 2. 특정 시간마다 src 변경 하기
		// - setInterval(함수 , 밀리초) : 1/1000초
		// 1. function , function 익명 , ()=>{} 익명 화살표  /  익명, 화살표는 함수 안에서만 사용
		//setInterval( ()=> {}, 2000 ) ; // 2초마다 코드가 실행 된다

let viewhimg = 0; // 현재 출력중인 광고이미지 인덱스 저장하고있는 변수

setInterval ( ()=> {
	// 1. 해당 이미지 태그 객체 호출	
	let himg = document.querySelector('.himg');
	// 2. 호출된 객체 에서 src 속성 대입( 변경 )
	viewhimg ++; // 인덱스 증가 [다음이미지로 변경]
	// 배열의 마지막 인덱스 보다 viewhimg 가 크거나 같으면 viewhimg 를 0 으로 돌린다 - 첫번째 이미지
	if(viewhimg >= bimhList.length){viewhimg = 0;}
	himg.src = `../img/${bimhList[viewhimg]}`;// 이미지 파일을 넣을거다 bimhList 배열에 있는 배열대로/01234
} , 2000);


// 2. 카테고리 출력[어디에 무엇을 출력할 것인가?] 함수
	// 1. 카테고리 여러개를 저장하는 배열
let categoryList = ['신제품(New' , '프리미엄' ,'와퍼&주니어' ,'치킨&슈림프버거' , '올데이킹&킹모닝' ]

	// 2. 카테고리를 출력하는 함수 정의 [ 실행 조건 : 1. 페이지 열렸을때]
categoryPrint(0);//최초 1번 실행 [가장 앞에 있는 카테고리를 선택했다고 가정]
function categoryPrint(selectNo) {
	// 1. 어디에
	let categorymenu = document.querySelector('.categorymenu')
	// 2. 무엇을
	let html = ``;
		// html 구성 : 배열 내 모든 데이터 (for) 를 li 형식으로 출력
	for( let i = 0; i <categoryList.length; i++){
		if(i == selectNo){
			html += `<li onclick="categoryselect(${i})" class = "categoryselect">${categoryList[i]}</li>`;
		}else{html += `<li onclick="categoryselect(${i})">${categoryList[i]}</li>`;}
	}
	categorymenu.innerHTML = html;
}

// 3. 케테고리 클릭 함수 [실행 조건 : li 에서 클릭 했을때]
function categoryselect(selectNo){
	// <li> 는 여러개 존재 한다 // 무엇을 선택 했는지 식별 해야 된다

	let categoryli = document.querySelectorAll('.categorymenu li') // ul 안에 모든 li 호출
	console.log(categoryli)
	
	// 해당 선택된 인덱스의 class 추가 // js에서 class 추가 / 삭제 가능
	for( let i = 0; i <categoryList.length; i++){
		// 2. 선택된 카테고리 selectNo 의 i번째 카테고리 찾기
		if (selectNo ==i ){
			// 해당 li에 class 추가  //dom객체명.classList.add ('새로운 클래스 명')
			categoryli[i].classList.add('categoryselect')
		}else{
			// 해당 li에 class 삭제  //dom객체명.classList.remove ('삭제할 클래스 명')
			categoryli[i].classList.remove('categoryselect')
		}//if
	}//for
}







