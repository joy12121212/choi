

// 문제11 : 정수 3개를 입력받아 오름차순 으로 출력    [ 7 5 9 -> 5 7 9]

let num1 = Number(prompt('정수1을 입력 하세요')); // 5
let num2 = Number(prompt('정수2를 입력 하세요')); // 2
let num3 = Number(prompt('정수3를 입력 하세요')); // 10


if (num1 > num2){
	let temp = num1;
	num1 = num2;
	num2 = temp;
}

if (num1 > num3){
	let temp = num1;
	num1 = num3;
	num3 = temp;
}

if (num2 > num3){
	let temp = num2;
	num1 = num3;
	num3 = temp;
}
console.log( num1 + ' ' + num2 +' '+ num3)

/* 문제12 : [ 가위바위보 게임 ] 
   - 가위가 '0' 이고 바위가 '1' 이고 보가 '2' 일때 플레이어1와 플레이어2 가 있습니다. 
   - 승리자 판단과 무승부 경우의수를 출력하시오.
*/

let n1 = Number(prompt('가위는0 바위는 1 보는 2를 입력 하세요')); 
let n2 = Number(prompt('가위는0 바위는 1 보는 2를 입력 하세요'));

if (n1 > n2){
	console.log('플레이어 1이 이겼습니다')
}

if (n1 < n2){
	console.log('플레이어 2가 이겼습니다')
}

if (n1 == n2){
	console.log('비겼습니다')
}

























