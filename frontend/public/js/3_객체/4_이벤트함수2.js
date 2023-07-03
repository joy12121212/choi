/*

	이벤트 함수
	html 이벤트 적용하는 방법
	1.
		<태그 이벤트속성명 = "함수명()"> </태그명>
		
	2.
		document.addEventListener('이벤트명' , 함수명)			// 기존 함수에 적용
		document.addEventListener('이벤트명' , ()=> {})		// 익명 화살표 함수에 정의 해서 적용
		document.addEventListener('이벤트명' , function (){})	// 익명 함수 정의해서 적용
		
	3. 이벤트
		이벤트명
		1. DOMContentLoaded : html 이 완전히 열렸을대 실행 되는 이벤트
		2. window.onload	: 해당 객체가 호출 되었을때
		3. click			: 해당 객체를 클릭 했을때
		4. keyup			: 해당 객체에서 키보드를 누르고 떼어있을때
		4. keydown			: 해당 객체에서 키보드를 눌렀을때

 */
// 1. 
let text = document.querySelector('.textbox')
text.addEventListener( 'keyup' , ( event )=>{		console.log('키보드 입력하고 떼어있을때');
	let h3 = document.querySelector('.h3box')
	console.log( text.value.length );
	h3.innerHTML = `입력된 문자 길이 : ${ text.value.length }`
	// 1. 키 상태 확인 => 키보드 제어 
	console.log( event );
	console.log( event.altKey );		// alt 눌렀는지??
	console.log( event.ctrlKey );		// ctrl 눌렀는지??
	console.log( event.shiftKey );		// ctrl 눌렀는지??
	console.log( event.code );			// 입력된 키보드의 코드네임
	console.log( event.key );			//
	console.log( event.keyCode )		// 입력된 키보드의 코드번호	[ C : 대문자 ]
	// 만약에 키보드에서 엔터를 쳤을때
	if( event.keyCode == 13 ){ alert('엔터입력했습니다.'); }
})