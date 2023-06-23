

// 문제 1) 입력받은 수 만큼 * 출력 
let output = ``; // 출력용 변수

let value1 = Number(prompt('문제1 : ')) //입력값

for (let i = 1; i<=value1; i++ ) {
	output += `*`
}
	console.log(output)


// 문제 2) 입력받은 수 만큼 * 출력 [  - 3줄(3배수)마다 줄바꿈 ]
output = ``; // 출력용 변수	

let value2 = Number(prompt('문제2 : ')) //입력값
	
for (let i = 1; i<=value2; i++ ) {
	output += `*`
	//만약에 i의 값이 3배수 이면
	if(i % 3 == 0){	output += `\n`} // 줄바꿈 추가 
}
	console.log(output)
	

// 문제3) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]

/*output = ``; // 출력용 변수

let value3 = Number(prompt('문제3 : ')) //입력값

for(let i =0; i <value3; i++){
	output += `*`
	console.log(output)
}*/

output = ``;
let line1 = prompt( '문제3:') 
for( let i = 1 ; i<=line1 ; i++ ){
	// [별찍기]
	for( let s = 1 ; s <= i ; s++){ output += `*`}
	// [줄바꿈] i는 1부터 입력받은 줄수까지 1씩증가
	output +=`\n`;
}
console.log( output )



// 문제4) 입력받은 줄 수 만큼 * 출력 [ ex) 5 ]


output = ``; // 출력용 변수

let value4 = Number(prompt('문제4 : ')) //입력값5

for(let i = 1; i<=value4; i++){
	for(let s = 1; s<=value4-i+1; s++ ){output += `*`}
	output += `\n`
}
console.log(output)


// 문제5) 입력받은 줄 수 만큼 * 출력 [ ex) 5 ]

output = ``; // 출력용 변수

let value5 = prompt('문제 5 : ')

for(let i =1; i<=value5; i++){
	for(let b=1; b <=value5-i; b++){output += ` `}
	for(let s=1; s <=i; s++ ){output += `*`}
	
	output += `\n`
}
	console.log(output)
	

// 문제6) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]

output = ``; // 출력용 변수

let value6 = prompt('문제 6 : ')

for(let i =1; i <=value6; i++){
	for(let b =1; b <=i-1; b++){output += ` `}
	for(let s =1; s <=value6-i+1; s++){output += `*`}
	output += `\n`
}
	console.log(output)


// 문제7) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]

output = ``; // 출력용 변수

let value7 = prompt('문제 7 : ')

for(let i = 1; i<= value7; i++){
	for(let b = 1; b <= value7-i; b++){output += ` `}
	for(let s = 1; s <= i; s++){output += `*`}
	for(let s2 = 1; s2<=i-1; s2++){output += `*`}
	
	output += `\n`	
}
	console.log(output)
	
// 문제8) 입력받은 줄 수 만큼 * 출력 
output = ``; // 출력용 변수

let value8 = prompt('문제 8 : ')

for (let i = 1; i <=value8; i++ ){
	for(let b = 1; b<=i-1; b++){output += ` `}
	for(let s = 1; s <=value8-i+1; s++){output += `*`}
	for(let s2 = 1; s2 <=value8-i; s2++){output += `*`}

	output += `\n`	
}
	console.log(output)

// 문제9) 입력받은 줄 수 만큼 * 출력  [ ex) 10 ]
output = ``; // 출력용 변수

let value9 = prompt('문제 9 : ')
 
for(let i = 1; i<= value9; i++){
	for(let b = 1; b <= value9-i; b++){output += ` `}
	for(let s = 1; s <= i; s++){output += `*`}
	for(let s2 = 1; s2<=i-1; s2++){output += `*`}
	
	output += `\n`	
}
	console.log(output)
for (let i = 1; i <=value9; i++ ){
	for(let b = 1; b<=i-1; b++){output += ` `}
	for(let s = 1; s <=value9-i+1; s++){output += `*`}
	for(let s2 = 1; s2 <=value9-i; s2++){output += `*`}

	output += `\n`	
}
	console.log(output)


// 문제10) 입력받은 줄 수 만큼 * 출력  [ ex) 5 ]

output = ``; // 출력용 변수

let value10 = prompt('문제 10 : ')
for(let i = 1; i <= value10; i++){
	for(let lb = 1; lb<=value10-i; lb++){output += ` `}
	for(let ls = 1; ls<=1; ls++){output += `*`}
	for(let lb1 = 1; lb1<i; lb1++){output += ` `}
	for(let rb =2; rb<i; rb++){output += ` `}
	for(let rs =1; rs<i; rs++){output += `*`}
	output += `\n`	
}
	console.log(output)   





