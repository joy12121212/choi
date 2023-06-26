/*

	함수 형태
		1. 인수x 반환x 함수
		<선언>
		function 함수1(){console.log('함수1 실행')}
		<호출>
		함수1()
		<button type="button" onclick="함수1()">함수1 실행</button>

		2. 인수 o 반환 x 함수


*/

//1. 인수, 반환 없는 함수 정의
function 함수1(){console.log('함수1 실행')}
함수1() // *js 에서의 함수 호출 방법 [스크립트 실행시 1회 실행, 그리고 클릭마다 추가]

//2. 인수 2개, 반환은 없는 함수 정의
function 함수2(x , y){
	console.log(x + y)
}
함수2(3 , 5); // 8 출력
함수2('소' , '땡') // 소땡 출력

//3. 인수 2개 , 반환o 함수의 정의
function 함수3(x, y){
	console.log(x + y)
	return x+y;
}
let 결과 = 함수3 (3 , 5); console.log(결과)

//4. 인수x , 반환o 함수의 정의
function 함수4(){if(3>=10)return 3;} // 함수 강제 종료
function 함수4(){return 3 + 8;} // 함수 강제 종료

let 결과2 = 함수4(); console.log('함수4 결과/리턴 : '+ 결과2)


// 5. 함수 정의시 함수 호출 가능
function 함수5(){console.log('함수5 실행시 함수1 호출 ' + 함수1() )}

함수5()



















