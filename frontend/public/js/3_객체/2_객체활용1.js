console.log('js되니')
// 1. 등록 함수 실행조건 : 회원가입 버튼을 클릭 했을때

// * 모든 함수에 접근할 수 있는 배열(member 객체 여러개를 저장하는) 선언
let 회원리스트 = []


function 등록(){console.log('등록 작동 하니')
	//1. 입력값 가져오기
		// 1. document.querySeletor('.클래스').value
		// 1. document.querySeletor('#id').value
		
	let mid = document.querySelector('#mid').value;		console.log(mid)
	let mpwd = document.querySelector('#mpwd').value;	console.log(mpwd)

	
	//2. 객체 담기
	let member = { mid : mid , mpwd : mpwd }; // 속성명 : 데이터 , 속성명 : 데이터
		//필드 = 상태
		// 속도 (속성명) = 현재속도수치(데이터)

		회원리스트.push(member);
		
	//3. 등록할때(함수 실행될때) 마다 객체 생성되고, 실행 끝나면 사라짐 == 지역변수
		//함수 밖에 전역변수 만들어서 저장해야 사라지지 않는다
	
	//코드 간소화
	// 회원리스트.push({아이디 : document.querySelector('#mid').value 
	// , 비밀번호 :pwd = document.querySelector('#mpwd').value })

	
}	// 함수가 끝나면 mid, mpwd member 다 사라짐	

console.log(회원리스트)


// 2. 로그인 [ 실행조건 : 로그인 버튼을 클릭 했을때]

function 로그인() {
		//1. 입력된 값 가져오기
	let mid2 = document.querySelector('#mid2').value;		console.log(mid2)
	let mpwd2 = document.querySelector('#mpwd2').value; 	console.log(mpwd2)


	let login = false; // 스위치 변수
	
		//2. 입력된 값이 존재 하는지 검사
	for ( let i=0; i<회원리스트.length; i++){
		let member = 회원리스트[i]; // i번째 인덱스의객체 1개 꺼내기
		if(member.아이디 == mid2){ // 꺼낸 객체의 id가 입력한 아이다와 같으면
			if(member.비밀번호 == mpwd2 ){
				login = true ;  // 로그인 성공 했다는 증거를 변수에 저장
				i=회원리스트.length; // 로그인 성송시 더 할게 없으니 반복문 종료 시키기
								// 종료 방법 1 : 조건을 false 로 만든다
				break;			// 종료 방법 2 : break; 가장 가까운 반복문 종료
			} // if 2번
		}// if 1번
	} // for 끝
	if (login) {alert('로그인 성공')}
	else {alert('로그인 실패')}
}
















