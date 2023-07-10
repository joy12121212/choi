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
		html += `<div> ${day} </div>`
	}
	calendar.innerHTML = html; // calendar 부분에 html 을 표시해준다	
}


// 2. 버튼 클릭시 현재 월 변화 해주는 함수
function onNext(check) {
	console.log(check)
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

















