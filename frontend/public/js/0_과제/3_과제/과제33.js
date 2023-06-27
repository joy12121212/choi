/*

	<주요기능1 등록>
		1. html 작성 : input 3개 button 1개
		2. 이벤트 발생
			클릭 이벤트
			<button onclick="">등록</button>
		3. 무슨 이벤트를 발생 시킬건지 구체적으로 정의 해라
			등록 버튼 클릭했을대 함수 실행

			1. 인풋에 입력된 3개의 데이터를 모두 가져오자
				1. 마크업의선택자 정의

			2. dom 객체 함수를 이용한 선택자의 마크업 객체로 호출
					document.getElementsByClassName
					document.querySelector
			
			3. dom 객체의 입력된 값 호출
				input, textarea, select => value 속성 가능
				div, span ,table 등등 => value 속성 불가능
				
				
		2. 배열에 저장
			* 배열은 여러개 데이터를 저장할 수 있다
			* 함수는 종료되는 순간 = {} 에서 사용되었던 메모리 모두 초기화, 사라진다
			
			<배열 선언>
				날자, 항목, 금액
				1. 인덱스 순으로 데이터 형태 구분???
					0 3 6 9 12 = 날자 인덱스
					1 4 7 10 13 = 항목 인덱스
					2 5 8 11 14 = 금액 인덱스
					let 가계부 = [ 2023-06-27 , 콜라 , 1000, 2023-06-27 , 사이다, 1000]
				2.
					각 배열당 0번 인덱스가 날짜, 항목, 금액 순으로 저장 됨
					
					let 가계부_날짜 = [ 2023-06-27 , 2023-06-28]
					let 가계부_항목 = [ 콜라 , 사이다 ]
					let 가계부_금액 = [ 1000 , 1000]
			<배열 저장>
				1. (★저장 하기 전) 유효성 검사 = 데이터 검사/필터링
				push
				2. (저장 성공 후) 인풋 value 초기화
	
	<주요기능2 출력>	
		1. html 작성 : 출력 예상 html 작성
		2. 출력 이벤트 ??
			1. 입장할때 -> 스크립트가 열렸을때
			2. 등록했을때 -> 등록함수 하단에 phsh 후에
			3. 삭제 했을때 -> js 삭제 함수 안에 새로고침
		3. 함수 정의	
			* 배열에 있는 값을 테이블에 출력
			1. 테이블에 마크업 객체로 호출
				- document.querySelector
			2. 테이블 안에 넣을 html 구성
				- 반복문 for
			3. 
	
	<주요기능3 삭제>		
		1. html 작성 : 삭제 예상 html 작성// 이미 td에 만들어놨음
		2. 삭제 이벤트는 언제 발생 하도록 할거인가?
			삭제제버튼을 클릭시 삭제되도록 이벤트 발생
			<button onclick="삭제(")>
		3. 누구를 삭제 할건가?			// 배열에서 주로 식별자 역할을 하는것은 인덱스다 / 중복되지 않는다]
			* 인수로 살제할 인덱스 번호 전달 받는다.
			<button onclick="삭제(삭제할인덱스번호)">
			function 삭제(삭제할인덱스번호)
			1) 삭제할 인덱스번호를 인수로 받는다
			2. 인수로 받은 인덱스번호에 해당하는 배열내 인덱스 삭제 = splice
*/	

let 날짜배열 = []
let 항목배열 = []
let 금액배열 = []

console.log('js 열림');
출력(); // 스크립트 실행시 최초 1회 실행

//1. 등록 버튼 클릭시 이벤트 함수
function 등록() { console.log('등록함수 클릭')

	
	//1. html 특정 태그를 가져오기
	//document.getElementsByClassName("클래스명")
	  //dateInput 에 온클릭 이벤트로 가져온 값을 저장한다 
	let dateInput = document.querySelector('.date'); 	console.log(dateInput)	
	let nameInput = document.querySelector('.name');	console.log(nameInput)
	let moneyInput = document.querySelector('.money');	console.log(moneyInput)

	//2. 태그의 입력된 값 호출
	
	let date = dateInput.value;		console.log(date)	
	let name = nameInput.value;		console.log(name)
	let money = moneyInput.value;	console.log(money)	
	
	// * 유효성 검사 // 푸시 전에 해야 된다
	if ( date == '' || name == '' || money == ''){ // 셋중 하나라도 해당 된다면 // 공백 이라면
		alert('모두 입력 후 등록 해주세요')
		return; // 종료 해줘야 된다 // 빠져 나오기
	}
	
	
	//3. 배열에 저장

	
	날짜배열.push(date); console.log(날짜배열); 항목배열.push(name);console.log(항목배열); 금액배열.push(money);console.log(금액배열);

	출력()	

	// * 저장 성공시 인풋 상자 초기화
	alert('항목 등록이 성공 되었습니다')
	dateInput.value = ``; nameInput.value =``; moneyInput.value=``;  // 인풋박스 초기화
	
}

function 출력() {
	console.log('가계부 목록을 출력 합니다')
	
	//1. 어디에 출력 할건지 ? table 가져 오기
	let outputTable = document.querySelector('.outputTable')
	
	//2. 무엇을 ???

	let html =  `<tr class="tr">
			<th> 날짜 </th>
			<th> 항목 </th>
			<th> 금액 </th>
			<th> 비고 </th>
				</tr>`

	for (let 인덱스 =0; 인덱스<날짜배열.length; 인덱스++){

		html+= `<tr>
					<td> ${날짜배열[인덱스]}</td>
					<td> ${항목배열[인덱스]}</td>
					<td> ${Number(금액배열[인덱스]).toLocaleString()}원</td>
					<td> <button onclick="삭제(${인덱스})">삭제</button></td>
				</tr>` // 삭제할 인덱스 번호를 삭제()함수에 인수로 전달
	}

	//요구사항 총합계 출력
	let 총합계 = 0;
	for ( let 인덱스 =0; 인덱스<금액배열.length; 인덱스++){

		총합계 += Number(금액배열[인덱스]);	// 넘버로 지정해줘서 숫자로 인식되게 해야 한다
		console.log(인덱스)		
	}
	
		// html 변수에다가 총합계를 추가 한다
	html += `<tr> 
				<td colspan ="2">총합계</td>
				<td colspan ="2">${총합계.toLocaleString()}원</td>
			</tr>`
	

	//2 .tableㅇ html 넣어주기
	outputTable.innerHTML = html;
	// 아웃테이블 <table> inner 이 사이가 inner 여기에다가 내용을 넣는다 </table>
}

// 3.삭제
function 삭제(삭제할인덱스번호){
		날짜배열.splice(삭제할인덱스번호 , 1) // 날짜배열 에서 삭제할 인덱스번호 1개를 삭제 한다
		항목배열.splice(삭제할인덱스번호 , 1)
		금액배열.splice(삭제할인덱스번호 , 1)
		출력(); // 출력은 변화가 있을때마다 다시 해주면 현행화가 된다
}
 


















