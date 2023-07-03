/*
	함수 : 미리 정의된 코드의집합
		1.내장함수 : JS언어 기본적으로 사용할수 있는 함수 = 라이브러리
			1. console.log('하고싶은말')		
			2. alert('하고싶은말')				
			3. confirm('하고싶은말')		
			4. prompt('하고싶은말')			
			5. document.write('html형식문자열')
			6. parseInt()
			7. Number()
			8. 배열명.push( 새로운값 )	
			9. 배열명.splice( 위치인덱스 , 0 , 새로운값 )
			10. 배열명.pop()
			11. 배열명.indexOf('찾을데이터')
			12. document.querySelector()
			13. Math.random()
			14. new Date();
			15. toLocaleString()
			
		2.내장객체 : JS언어 기본적으로 사용할수 있는 객체 
			console 
			*document
			Math
			new Date();
			
		3.정의함수 : 개발자 정의해서 사용하는 함수 
			function 함수명(){}		===	>   함수명();
			
	DOM 객체 : Document Object Model : 문서 객체 모델
		- HTML 정적언어(메모리X이벤트X) 	-JS 동적언어(메모리O이벤트O)
		1. 정의 : HTML문서을 각 항목을 계층으로 표현된 JS객체
		2. 
			document // 중요하다


 */
// 1. document.태그 호출 가능
console.log(document) // 현재 스크립트가 포함된 html 문서 전체를 객체로 가져온다
console.log(document.body) // body 호출 // 2개 못씀 // 그래서 호출 가능
console.log(document.head) // head 호출 // 2개 못씀 // 그래서 호출 가능
console.log(document.div)	// 중복 가능한 태그는 제공 안한다
console.log(document.querySelector('div'))	// 그래서 쿼리 셀렉터로 가져와야된다
 					// 뭐할거야? 선택? -> 누구 가져올거야
console.log(document.querySelector('.box1'))	// class 명으로 호출
console.log(document.querySelector('#box2'))	// id 명으로 호출
					// 얘는 1개씩 가져오기 때문에 변수에 담겨짐
let div변수 = document.querySelector('#box2')
console.log(document.querySelectorAll('div'))	// ★All 은 모든걸 다 가져온다 / 배열로 저장해서★
					// 얘는 all로 가져오기 때문에 배열에 저장된다
let div배열 = document.querySelectorAll('div')

console.log(div배열[2]) //  0 1 2 3 ~

div배열[2].innerHTML='안녕하세요 수정한다' // 2번 index 에 있는 내용 수정

// = 대입 ( 기존 데이터 사라짐 , ) += 추가 (기존 데이터 + 새로운 데이터)
document.body.innerHTML = ''; //body 내 모든 html 지우기
document.body.innerHTML += '<h3>html 추가</h3>'; // 추가 하기


//3. style 속성 : <태그 style="cssㅈ가성"> </태그>
document.body.style = `background-color : yellow; font-size : 20px;`;
// 이거 많이 사용함

//4. addEvintListener('이벤트명' , 함수 )
/*
	1. function 함수명(){}
	addEventListener ('이벤트명' , 함수명)
	
	2. - 익명함수 [ 함수명이 없는 함수 (인수) => {실행코드}]를 이용한 이벤트 추가
	 // 이미 객체의 속성명에 함수를 저장해 놨으니 굳이 또 함수명을 만들필요 없음
	addEventListener ( '이벤트명' , ()=> {}; )

*/

	// DOMContentLoaded : HTML이 완전히 모두 열렸을대 , 호출이 됐을때 실행되는 이벤트
	// window.onload	: 해당 객체가 호출 되었을때 실행되는 이벤트
	//

// 1. HTML 이 완전히 열렸을때 실행 됨
document.addEventListener('DOMContentLoaded' , ()=>{console.log('js에서 이벤트 실행')})
// 2. 해당 객체가 호출 되었을때 실행 됨
window.onload = () => {console.log('js에서 이벤트실행 2')}
// 3. 스크립트가 실행될때 1번 실행 됨
console.log('js에서 이벤트실행3')

// 4. 
let h3  = document.querySelector('h3'); console.log(h3)

h3.addEventListener( 'click' , () => { console.log('h3 클릭 함')})






