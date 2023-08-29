/*

onchange : 포커스 변경될때
onkeyup : 키보드에서 키를 누르다 떼면
onkeydown : 코드에서 키를 눌렀을때

정규표현식 : 문자열에 특정 규칠 / 패턴 집합 표현할때 사용되는 언어
	문법
		/^		: 정규식 표현 시작
		$/ 		: 정규식 표현 끝
		[a-z]	: 소문자 a-z 패턴 검색
		[A-A]	: 대문자 A-Z 패턴 검색
		[0-9]	: 숫자 0~9 패턴 검색
		[가-힣]	: 한글 패턴
		{최소길이, 최대길이} : 문자열 길이 패턴
		+ : 앞에 있는 패턴 1개 이상 반복
		? : 앞에 있는 패턴 0개 혹은 1개 이상 반복
		* : 앞에 있는 패턴 0개 반복
		
		예시) 
			1.[a-z]				: 소문자 패턴
			2.[a-zA-Z]			: 영문 대,소문자 패턴
			3.[a-zA-Z0-9]		: 영어 + 숫자 패턴
			4.[a-zA-Z0-9가-힣]	: 영어 + 숫자 + 한글 패턴
			5.[ac]				: a와c 패턴
		
			6./^[a-z0-9]{5,30}$/ : 영문소 + 숫자 조합에 5글자이상 30글자 이하
			
			7. (?=.*[패턴문자]})	: 해당 패턴 문자가 한개 이상 포함된 패턴
				(?=.*[a-z]})	: 소문자 한개 이상 필수
				(?=.*[A-Z]})	: 대문자 한개 이상 필수
				(?=.*[0-9]})	: 숫자 한개 이상 필수
				(?=.*[\d]})		: 정수(숫자) 한개 이상 필수
				(?=.*[!@#$%^&*]})	: 패턴문자내 특수문자 한개 이상 필수
				
			/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z-0-9]{5,20}$/
			대문자 1개, 소문자 1개 숫자 1개 이상 필수로 넣는 5~2-글자 사이
			/^(?=.*[A-Z])(?=.*[!@#$])[A-Za-z0-9]{8,20}$/
			
			
			
			
			
			
		패턴 검사
		"패턴".test (검사할 데이터) : 해당 데이터가 패턴에 일치하면 true / 아니면 false
*/	
//1. 아이디 유효성 검사
function idcheck() {
	console.log('아이디체크 함수 실행')



	// 아이디 호출
	let mid = document.querySelector('.mid').value;
	let idcheckbox = document.querySelector('.idcheckbox');
	// 유효성 검사
	// 제어문을 이용한 검사 if(mid.length < 5 %% mid.length >=30){}
	// 아이디는 영문+숫자 조합에 5글자~30글자 사이 라면
	// 정규식 표현 작성
	let midj = /^[a-z0-9]{5,30}$/
	// 정규표현식 검사
	console.log(midj.test(mid));
	if (midj.test(mid)) {
		idcheckbox.innerHTML = '합격'
		// -- 입력한 아이디가 패턴과 일치하면 아이디 중복 검사 진행
		$.ajax({
			url: "/jspweb/MemberFindController",
			method: "get",
			data: { type: "mid", data: mid },
			success: r => {
				console.log('idhceck 통신성공')
				if (r) { idcheckbox.innerHTML = '사용중인 아이디' }
				else { idcheckbox.innerHTML = '사용 가능한 아이디' }
			},
			error: e => { }
		});

	} else {
		idcheckbox.innerHTML = '영문(소문자) + 숫자 조합의 5~30글자만 입력 가능 합니다'
	}

}




//1. 회원가입 메소드
function signup() {
	console.log('signup 왔어요')

	// html 정보 가져오기
	let midInput = document.querySelector('.mid');
	let mpwdInput = document.querySelector('.mpwd');
	let mpwdconfirmInput = document.querySelector('.mpwdconfirm');
	let memailInput = document.querySelector('.memail');
	let mimgInput = document.querySelector('.mimg');

	// 객체화
	let info = {
		mid: midInput.value, mpwd: mpwdInput.value, memail: memailInput.value,
		mimg: mimgInput.value
	}
	console.log(info);

	// 아작스
	$.ajax({
		url: "/jspweb/MemberController",
		method: "post",
		data: info,
		success: r => {
			console.log('통신성공')
			if (r == true) {
				alert('회원가입성공');
				midInput.value = ``;
				mpwdInput.value =``;
				mpwdconfirmInput.value = ``;
				memailInput.value = ``;
			} else { alert('회원가입실패') }
		},
		error: e => {e }
	});

}


// 2. 비밀번호 확인 [정규표현식 검사 , 비밀번호와 비밀번호확인 일치여부]
function pwcheck() {
	console.log('비밀번호 확인 돌아가나')
	let pwcheckbox = document.querySelector('.pwcheckbox');

	//1. 입력값 호출
	let mpwd = document.querySelector('.mpwd').value; console.log(mpwd)
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value; console.log(mpwdconfirm)


	//2. 유효성 검사
	// 정규표현식 만들기 영대,소문자 + 숫자 조합 5~20글자 사이
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/

	if (mpwdj.test(mpwd)) { //비밀번호 정규표현식 검사

		if (mpwdj.test(mpwdconfirm)) { // 비밀번호확인 정규표현식 검사
			//비밀번호랑 비밀번호확인이랑 일치하는지 검사
			if (mpwd == mpwdconfirm) {
				pwcheckbox.innerHTML = `사용가능한 비밀번호`
			} else { pwcheckbox.innerHTML = `비밀번호가 일치하지 않습니다` }

		} else {
			pwcheckbox.innerHTML = `영어 대,소문자 1개 이상 + 숫자 1개이상 조합으로 5글자~20글자 까지 가능`
		}

	} else {
		pwcheckbox.innerHTML = `영어 대,소문자 1개 이상 + 숫자 1개이상 조합으로 5글자~20글자 까지 가능`
	}

}



// 3. 이메일 유효성 검사 [ 정규포현식 , 중복검사 ]

function emailcheck(){
		// 1. 입력된 값 호출
	let emailchechbox = document.querySelector('.emailchechbox');

	let memail = document.querySelector('.memail').value;
	// 2. 이메일 앞부분 [ @ 기준으로 앞쪽]
	// joy_1-2		이메일 앞부분은 영어 대,소문자 숫자, _- 패턴
	// @			+@ 앞에 패턴 1가지 이상 필수
	// .			+\. . 앞에 패턴 1가지 이상 필수
	// 도메인			. 뒤에 패턴은 a-zA-Z
	let memailj = /^[a-zA-Z\d_-]+@[a-zA-Z\d_-]+\.[a-zA-Z]+$/
	
	 if(memailj.test(memail)){
		 console.log('통과')
		 $.ajax({
			 url: "/jspweb/MemberFindController",
			 method: "get",
			 //type 사용하는 이유 : 서로 다른 ajax 가 동일한 서블릿과 동일한 get 메소드 사용하려고 할때
			 data: { type: "memail", data: memail },
			 success: r => {
				 if (r) {
					 emailchechbox.innerHTML = `사용중이다`;
					 document.querySelector('.authReqBtn').disabled=true;
				 } else {
					 emailchechbox.innerHTML = `사용가능하다`;
					 document.querySelector('.authReqBtn').disabled=false;
				 }


			 },
			 error: e => { e }
		 });
	 } else { console.log('실패') 
	 document.querySelector('.authReqBtn').disabled=true;}
}//email


// 4. 인증 요청 버튼을 눌렀을때
function authReq() {
	console.log('이메일증인증요청 정상')
	
	// 1. authbox div 호출
	let authbox = document.querySelector('.authbox');
	
	// 2. auth html 구성
	let html= `
			이메일 인증 : <input class="ecode" type="text">
			<span class="timebox">남은시간 02:00 </span>
			<button onclick="auth()" type="button">인증</button><br/>`
	authbox.innerHTML=html;
	//타이머 실행
	authcode = '1234';	// 테스트용 인증번호
	timer = 30;			// 인증 시간 테스트
	setTimer();			// 타이머 실행
	
	
}

// 4번, 5번, 6번에서 같이 사용할거라서 전역변수로 선언

let authcode = '';
let timer = 0;
let timerInter;



// 5. 타이머 만들기
function setTimer(){
	//정의
		//setInterval (함수명 , 실행간격[밀리초])  특정 시간마다 함수를 실행하는 함수
		//setInterval (funtion 함수명(){} , 밀리초)
		//setInterval (함수명() , 밀리초)
		//setInterval (()=> {} , 밀리초)
	//종료
		//clearInterval( 변수명 );
	timerInter = setInterval(()=> {
		
		//시간 형식 만들기
			// 분 단위 만들기
			let m = parseInt(timer/60)
			let s = parseInt(timer%60);
			// 두자리수 맞추기
			m = m < 10 ? "0" + m : m; // 만약 m이 10보다 작으면(1~9) 앞에 0 붙이고 아니면(10이상) 그대로
			s = s < 10 ? "0" + s : s;
		document.querySelector('.timebox').innerHTML = `남은시간 ${m}:${s}`; // 현재 인증 시간 html 대입
		timer--;
		
		//만약에 타이머가 0 이면 종료
		if(timer < 0) {
			// 1. setInterval 종료 [누구를 종료할건지 변수 선언 = timerInter]
			clearInterval(timerInter);
			// 2. 인증 실패
			document.querySelector('.emailchechbox').innerHTML=`인증실패`;
			// 3. authbox 숨기기
			document.querySelector('.authbox').innerHTML=``;
		}
		
	}, 1000)
}


// 6. 인증입력 버튼
function auth(){
	
	let ecode = document.querySelector('.ecode').value;
	
	if (authcode == ecode){
		console.log('인증코드 일치')
		//interval 종료
		clearInterval(timerInter);
		//인증 성공 알림
		document.querySelector('.emailchechbox').innerHTML=`인증성공`;
		//박스 초기화
 		document.querySelector('.authbox').innerHTML=``;
	}//if
	else{console.log('인증코드불일치')
		document.querySelector('.emailchechbox').innerHTML=`인증실패`;
	}
}//auth

function preimg(object){
	console.log(object)
	console.log(document.querySelector('mimg'))
	
	console.log(object.files)
	console.log(object.files[0])
	
	let file = new FileReader();
	
	file.readAsDataURL(object.files[0])
	
	file.onload = e=>{
		console.log(e.target.result)
		document.querySelector('.preimg').src=e.target.result;}
	
}











