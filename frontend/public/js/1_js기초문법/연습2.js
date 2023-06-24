
output = ``;

let value10 = prompt('문제 10 : 7을 입력 하세요')
let a = 1;
let z = 7;


for (let i =1; i<=value10; i++){//for 시작
	
	for(let j = 1; j <=value10; j++){ //for 시작
		if (a ==j || z==j){
			output += `*`
			}else{output += ` `}
	}//for 끝
	output+=`\n`
	a++;
	z--;
}//for 끝
console.log(output)


