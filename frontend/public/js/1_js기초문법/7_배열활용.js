/*
	변수
		지역변수 : 지역{ }에서 태어났으면 지역 밖으로 못나감
			{안산}	
			- {} 안에서 선언된 변수는 {} 밖에서 사용 불가
		전역변수 : 지역{ }밖에서 태어났으면 자유롭게 이동 가능
			[대한민국] {안산}{성남} 등등 이동 가능
			- {} 밖에서 선언된 변수는 {1} {2} 자유롭게 사용 가능
			
			
	문자열내 변수/배열/객체 등등 포함하는 방법 [js 안에서 HTML 작성시 문자 처리]
		1. 작은따움표(연결연산자)	= '<td>'+변수명/배열명+'</td>'
		2. 백틱( `${}` )		= `<td>${변수명/배열명}</td>` // + 안써서 오류 덜함
	
	
*/


console.log('ㅇㅇㅇㅇㅇㅇㅇ') // 한번찍어봐//js 땡겨졌나

let 방문록배열 = [] //여러 함수에서 사용하려고 함수 밖에 생성
		//인덱스 = 배열에 저장된 순서
let 방문록배열2 = []

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
	
	
	방문록배열2.push(document.querySelector('.writer').value)
	
	// 5. html에 배열 출력
		//1. table 호출
	let contentTable = document.querySelector('.contentTable')

		//2. table 안에 있는 html 호출
	//let tableHTML = contentTable.innerHTML
	//console.log(tableHTML)

		//3.innerHTML 내용 (+= 추가)
		// *배열내 존재하는 인덱스까지만 출력
		// *반복문을 이용한 0번 인덱스부터 마지막 인덱스까지 출력
		// *0번부터 (초기값); 마지막인덱스까지(조건); 1개씩(증감식)

	//1안
	let tableHTML = `<tr><th>내용</th><th>작성자</th></tr>`
	for(let i = 0; i < 방문록배열.length; i ++) {
	
	//tableHTML += '<tr><td>'+방문록배열[0]+'</td><td></td></tr>'
	tableHTML += `<tr><td>${방문록배열[i]}</td><td>${방문록배열2[i]}</td></tr>`
	}
	
	
	//2안
	//let tableHTML = contentTable.innerHTML
	//tableHTML += `<tr><td>${방문록배열.length-1}</td></tr>`




	
	

		//4. 추가된 HTML 내용 (=) 대입
	contentTable.innerHTML = tableHTML
	
	
	
}
























