/*
	변수
		지역변수 : 지역{ }에서 태어났으면 지역 밖으로 못나감
			{안산}	
			- {} 안에서 선언된 변수는 {} 밖에서 사용 불가
		전역변수 : 지역{ }밖에서 태어났으면 자유롭게 이동 가능
			[대한민국] {안산}{성남} 등등 이동 가능
			- {} 밖에서 선언된 변수는 {1} {2} 자유롭게 사용 가능
*/


console.log('ㅇㅇㅇㅇㅇㅇㅇ') // 한번찍어봐//js 땡겨졌나

let 방문록배열 = [] //여러 함수에서 사용하려고 함수 밖에 생성


// 배열을 함수 아래 만들면 배열이 초기화 된다 // 중요
// 배열은 함수 위, 아래 상관없음// 안에만 안만들면 된다

// 1. 이벤트 함수 만들기
function 등록(){ //
	
	// 1. 함수가 잘 작동하는지 체크
	console.log('등록함수 실행')
	
	// 2. input 태그 호출
	let contentinput = document.querySelector('.content')
	console.log(contentinput);
	
	// 3. 입력받은 값 호출
	let value = contentinput.value;
	console.log(value);
	
	// 4. 배열 등록
	방문록배열.push(value)
	console.log(방문록배열)
}