/*

	- 제어문 = if = 만약에

if (a편의점 <=1000){구매 완료}
else if (b편의점 <=1000){구매 완료}
else if (c편의점 <=1000){구매 완료}
else{안사}


		1. 제어문 : 흐름 에 대한 논리적인 제어를 할 수 있다.
		2. if [*] , switch 문법
		3. if 형태
			* 조건 : true or false 결과를 갖는 변수 혹은 연산/계산
			* 조건과 참/거짓의 코드가 이어져야 한다 // ; 들어가면 망가짐
			1) if (조건) 참 일 경우
			2) if (조건) {참1일 경우 코드1; 참2일 경우 코드2}
			3) if (조건) {참일경우코드}
				else{거짓일경우 코드}
					----------vs-----------삼항 연산자라 비슷 조건 ? 참 : 거짓
		4. if (조건1) {참1일 경우 코드}
			else if(조건2) {참2일 경우 코드}
			else if(조건3) {참3일 경우 코드}   // 결과값 1개
			else {거짓}
			
				vs
			if (조건1) {참1일 경우 코드}
			if (조건2) {참2일 경우 코드}
			if (조건3) {참3일 경우 코드}			// 결과값 여러개
		
		5. if 중첩
			if (조건1) {
				if (조건2) {}
				else if (조건3){}
			}else{
				if (조건4){}
				else if (조건5){}
			}

 */

 
/* // 1. if 형태1
 if(10>3) console.log('참[1] 10이 참보다 크다') // 참이라 출력
 if(10>20) console.log('참[2] 10이 20보다 크다') // 거짓이라 미출력
 if(10>20); console.log('참[2] 10이 20보다 크다') // ; 있어서 망가짐
 
 // 2. if 형태2
 if(10 >3) console.log('참1'); console.log('참2');
 if(10 >20) console.log('참3'); console.log('참4'); // 거짓인데도 ; 때문에 참4 출력
 if(10 >20) {console.log('참5'); console.log('참6')}// {}묶어서 제대로 출력
 
 // 3. if 형태3
 
 if(10>3) {console.log('참 10이 더 크다')}
 else{console.log('거짓 10이 더 작다')}
 
 
// 4. if 형태4
if(1 >= 20) {console.log('참1 10이 20보다 이상이다')}
 else if (10 >= 15) {console.log('참2 10이 15보다 이상이다')}
 else if (10 >= 10) {console.log('참3 10이 05보다 이상이다')}
  else{console.log('거짓 10이 10 미만이다')}*/
 
 
// 문제 1

let num1 = Number(prompt('정수1을 입력 하세요')); 
let num2 = Number(prompt('정수2를 입력 하세요')); 

if (num1 > num2){console.log(num1)}
else {console.log(num2)}

// 문제 2

let num11 = Number(prompt('정수1을 입력 하세요')); 
let num22 = Number(prompt('정수2를 입력 하세요')); 
let num33 = Number(prompt('정수3를 입력 하세요')); 
let max1 = num11

if (max1 < num22) {max1 = num22;}
if (max1 < num33) {max1 = num33;}
console.log(max1)



// 문제 3

let num111 = Number(prompt('정수1을 입력 하세요')); 
let num222 = Number(prompt('정수2를 입력 하세요'));
let num333 = Number(prompt('정수3를 입력 하세요')); 
let num444 = Number(prompt('정수4를 입력 하세요')); 
let max2 = num111

if (max2 < num222) {max2 = num222;}
if (max2 < num333) {max2 = num333;}
if (max2 < num444) {max2 = num444;}
console.log(max2)



// 문제 4

let upnum1 = Number(prompt('정수1을 입력 하세요')); // 5
let upnum2 = Number(prompt('정수2를 입력 하세요')); // 2
let upnum3 = Number(prompt('정수3를 입력 하세요')); // 10


if (upnum1 > upnum2){
	let temp = upnum1;
	upnum1 = upnum2;
	upnum2 = temp;
}

if (upnum1 > upnum3){
	let temp = upnum1;
	upnum1 = upnum3;
	upnum3 = temp;
}

if (upnum2 > upnum3){
	let temp = upnum2;
	upnum1 = upnum3;
	upnum3 = temp;
}
console.log( upnum1 + upnum2 + upnum3)


// 문제 5

let int1 = Number(prompt('인트1을 입력 하세요')); //
let int2 = Number(prompt('인트2를 입력 하세요')); //
let int3 = Number(prompt('인트3를 입력 하세요')); // 
let int4 = Number(prompt('인트4를 입력 하세요')); //

if (int1 > int2){
	let temp = int1;
	int1 = int2;
	int2 = temp;
} // 1번과 2번

if (int1 > int3){
	let temp = int1;
	int1 = int3;
	int3 = temp;
} // 1번과 3번

if (int1 > int4){
	let temp = int1;
	int1 = int4;
	int4 = temp;
} // 1번과 4번

if (int2 > int3){
	let temp = int2;
	int2 = int3;
	int3 = temp;
} // 2번과 3번

if (int2 > int4){
	let temp = int2;
	int2 = int4;
	int4 = temp;
} // 2번과 4번

if (int3 > int4){
	let temp = int3;
	int3 = int4;
	int4 = temp;
} // 3번과 4번

console.log( int1 + int2 + int3 + int4 )
// 문제 6
let score1 = Number(prompt('점수를 입력 하세요'))
if(score1 >= 90){console.log('합격')}
else{console.log('불합격')}


// 문제 7

let score2 = Number(prompt('점수를 입력 하세요'))

if (score2 >= 90) {console.log('A')}
else if(score2 >= 80){console.log('B')}
else if(score2 >= 70){console.log('C')}
else {console.log('넌 망함 시험 다시봐라')}

// 문제 8

let id = prompt('아이디를 입력 하세요')
let pw = prompt('비밀번호를 입력 하세요')

if (id == 'admin' && pw == '1234') { console.log('로그인 성공') }
else { console.log('로그인 실패') }


if (id == 'admin') {
	if (pw == '1234') {
			console.log('로그인 성공')
	}else {
			console.log('로그인 실패')
	}

}
else {
	console.log('로그인 실패: 없는 아이디')
}







 
 
 
 
 