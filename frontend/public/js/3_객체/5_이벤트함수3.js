

// 1. select 목록상자에서 변경될때 선택된 value 가져오기

let selectbox = document.querySelector('.selectbox')

	// 이벤트 등록 [addEventListener vs <select onchange=""> ]

selectbox.addEventListener( 'change' , ()=>{
	
	console.log('목록 상자가 변경 되었네요.')
	
});

// 2. input 체크 상자에서 체크 여부 가져오기

let checkbox = document.querySelector('.checkbox')

checkbox.addEventListener( 'change' , ()=>{
	
	console.log('체크박스를 선택 하였스빈다') // 체크하면 내용 출력
	console.log(checkbox.checked) // 체크 했나 안했나 확인
});

// 3. 타이머 예제
	// 해당 태그 호출 // 정보 먼저 가져와서 저장해놓고 변수로 사용 해라
let timer = document.querySelector('.timer')
let timerbox = document.querySelector('.timerbox')

	// 시간 함수에 필요한 변수
let time = 0;		// 타이머 시간을 저장하는 변수
let timerId = 0; 	// 타이머 함수가[setInterval] 저장되는 변수   

	// 이벤트 등록
timer.addEventListener ('change' , ()=>{
	
	if(timer.Checked){
		timerId = setInterval( ()=>{
			time++;	// 시간 증가 //
			timerbox.innerHTML = `${time} + 초`;
		} , 1000) // 1초마다 앞에 코드{} 실행
	}else{
			clearInterval(timerId)
	}
	
})


/* setInterval () : 특정 시간마다 특정 함수 재호출 함수
	1. setInterval ( 함수 , 시간 )
	함수
		1. 기존 함수명
		2. ()=> {}
		3. function () {}
		
	시간 : 밀리초 [ 1 / 1000초]
		1000=>1초
		100=>0.1초
		10=>0.01초
		1=>0.001초
	clearInterval



*/










