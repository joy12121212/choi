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
				midInput = '';
				mpwdInput = '';
				mpwdconfirmInput = '';
				memailInput = '';
			} else { alert('회원가입실패') }
		},
		error: e => { }
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
				 } else {
					 emailchechbox.innerHTML = `사용가능하다`;
				 }


			 },
			 error: e => { e }
		 });
	 } else { console.log('실패') }
}//email










