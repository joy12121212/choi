console.log('dddddddddddddd')


// 0. 현재 연도/월 [초기값]
	// new Date()	 				: 현재 날짜와 시간을 반환해주는 클래스
	// ★ new Date( 연도 , 월, 일 )	: 사용자 정의 날짜 반환 해주는 클래스
		// .getFullYear() , 
		// .getMonth() , 
		// .getDay() : 요일 [일 월 ~토 , 0 1 ~6]  
		// .getDate() : 일 [1 2 3 ~]  
		
let year = new Date().getFullYear();		//현재 연도
let month = new Date().getMonth()+1;		//현재 월 0~11 표시 되므로 +1 해줘야된다 // 화면에 출력되는게 7월이 되도록 하기 위해 +1
console.log(year);console.log(month);
// 1. 현재 연도/월 기주으로 달력 출력 하는 함수

// 전역 배열
let contents = [] // 여러개 일정 객체를 저장하는 배열


calPrint()
function calPrint(){
	// 1. 현재 연도와 월 출력
	document.querySelector('.caldate').innerHTML = `${year}년 ${month}월`
	// 2. 요일과 월 출력

		// 시작 요일
	let now = new Date( year , month-1 , 1) // 현재 보고있는 캘린더의 날짜 // 위에서 +1을 해줬으므로 -1을 해줘야 달력은 8월이 아닌 7월로 인식 한다
	let sweek = now.getDay(); console.log(sweek) //now 의 요일을 가져온다/ 요일은 토요일 , 일 0 , 월 1 ~ 토 6
	
	let now2 = new Date ( year , month , 0 ); // 일 에 0을 넣으면 전 날이(일수) 표시 된다 // 머리에 박고 있어라 // 
	let eDay = now2.getDate(); console.log(eDay)


	let calendar = document.querySelector('.calendar');
	let html = '';

	html += `<div class="week sunday"> 일 </div><div class="week"> 월 </div>
			 <div class="week"> 화 </div><div class="week"> 수 </div><div class="week"> 목 </div>
			 <div class="week"> 금 </div><div class="week"> 토 </div>`
	
	// 현재 달ㄹ력 1일의 요일까지 공백
	for ( let b = 1 ; b<=sweek; b++){ // 1부터 1일의 요일까지 공백 구역 출력
		html += `<div></div>`
	}
	
	// 현재 달력 마지막 일 까지 일수 출력
	for(let day = 1; day<=eDay; day++){
		html += `<div onclick="openModal(${day})"> ${day}
				${contentPrint(`${year}-${month}-${day}`)}
				</div>`
		
	}
	calendar.innerHTML = html; // calendar 부분에 html 을 표시해준다	
	
}

// 6. 일정 출력 함수 [ 실행 조건 : 현재 날짜와 일정 날짜가 같으면 출력]
	// 인수 : 함수 안으로 들어오는 수 / 값 / 데이터
	// 반환 : 함수 끝나고 호출 했던 곳으로 수 / 값 / 데이터 돌려줌 = 해당 날짜의 일정 내용 html

function contentPrint(date){
	// 인수로 들어온 날짜와 같은 일정목록에서 일정 찾기
	let html =``;
	for(let i = 0; i<contents.length; i++){
		if(date == contents[i].date){
			html +=`<span class="content" style="background-color:${ contents[i].color  }">
					${contents[i].content}</span>`
		}
	}
	return html;
}

// 2. 버튼 클릭시 현재 월 변화 해주는 함수
function onNext(check) {console.log(check)

	if (check == 0){ // 이전달
		month --;
		//만약에 월이 차감 했는데 1보다 작아지면 12로 변경 + 연도 1 차감
		if(month < 1){month = 12; year--;}
	}else if (check ==1 ){ // 다음달
		month ++;
		if(month >12){month = 1; year++;}
	}
		calPrint() // 작업을 했으면 화면 새로고침을 해줘라
}
// 3. 모달 열기 // 날짜 클릭시
function openModal(day){
	document.querySelector('.modalwrap').style.display= 'flex'; // 날짜 div 클릭하면 보이기
	// 현재 클릭한 일수의 날짜 출력
	document.querySelector('.date').innerHTML = `${year}-${month}-${day}`
}

// 4. 모달 닫기 // 닫기 버튼 클릭시
function closeModal(){
	document.querySelector('.modalwrap').style.display= 'none';	// 닫기 버튼 누르면 사라지기
}

//<input value="값"/> 여기엔 value를 사용
//<div>값</div> 여기엔 innerHtml을 사용


// 5. 일정등록 버튼 클릭할때
function onWrite(){
	// 1. 이력 받은 값 호출
	let color = document.querySelector('.color');
	let contentinput = document.querySelector('.contentinput');
	let date = document.querySelector('.date');
	console.log(color)
	console.log(contentinput)
	console.log(date)
	
	// 2. 가공 [ 유효성 검사 , 객체화]
	let object = {
		color : color.value ,
		content : contentinput.value ,
		date : date.innerHTML
	}	
	// 3. 저장
	contents.push(object);	
	// 4. 비워주기
	color.value = ''; contentinput.value = '';
	closeModal(); calPrint(); console.log(contents)
}











