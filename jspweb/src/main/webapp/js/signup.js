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
		
		
		예시) 
			1.[a-z]				: 소문자 패턴
			2.[a-zA-Z]			: 영문 대,소문자 패턴
			3.[a-zA-Z0-9]		: 영어 + 숫자 패턴
			4.[a-zA-Z0-9가-힣]	: 영어 + 숫자 + 한글 패턴
			5.[ac]				: a와c 패턴
		
			6./^[a-z0-9]{5,30}$/ : 영문소 + 숫자 조합에 5글자이상 30글자 이하
		패턴 검사
		"패턴".test (검사할 데이터) : 해당 데이터가 패턴에 일치하면 true / 아니면 false
*/	
//1. 아이디 유효성 검사
function idcheck(){
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
	if(midj.test(mid)){
		idcheckbox.innerHTML = '합격'
		// -- 입력한 아이디가 패턴과 일치하면 아이디 중복 검사 진행
		$.ajax({
	      url :  "http://localhost/jspweb/MemberFindController",
	      method : "get" , 
	      data : {mid : mid} ,
	      success : r=>{console.log('idhceck 통신성공')
	      if(r){idcheckbox.innerHTML = '사용중인 아이디'}
	      else{idcheckbox.innerHTML = '사용 가능한 아이디'}
	      } ,
	      error :  e=> {}
  	    });
  	    
	}else{
		idcheckbox.innerHTML = '영문(소문자) + 숫자 조합의 5~30글자만 입력 가능 합니다'
	}
	
}




//1. 회원가입 메소드
function signup(){ console.log('signup 왔어요')

	// html 정보 가져오기
	let midInput = document.querySelector('.mid');
	let mpwdInput = document.querySelector('.mpwd');
	let mpwdconfirmInput = document.querySelector('.mpwdconfirm');
	let memailInput = document.querySelector('.memail');
	let mimgInput = document.querySelector('.mimg');

	// 객체화
	let info = {
		mid : midInput.value, mpwd : mpwdInput.value , memail : memailInput.value,
		mimg : mimgInput.value
	}
	console.log(info);

	// 아작스
	  $.ajax({
      url :  "/jspweb/MemberController",
      method : "post" , 
      data : info ,
      success : r=>{console.log('통신성공')
      	if(r == true){
			  alert('회원가입성공');
			  midInput = '';
			  mpwdInput = '';
			  mpwdconfirmInput= '';
			  memailInput= '';
		  }else{alert('회원가입실패')}
      } ,
      error :  e=>{}
      });

}