
// 누구를?
// 1. 조작, 제어 할 html 호출
	// 1. 입력 2. 출력 3. 이동
let userbox = document.querySelector('.userbox');

// 유저 위치 = x 좌표
let u_left = 50;


// 어떻게? : 현재 페이지에서 키보드를 누르면 

	//dom 객체명.addEventListener('이벤트명' , ()=> {})
document.body.addEventListener('keydown' , (e)=>{  /*document.body 를 사용한 이유 : div에는 이벤트 안돼 그래서 바디*/
	console.log('aaa')
	// 1. 눌린 키 입력 확인 e.keyCode (카멜표기법)
	console.log(e);	// ekydown 이벤트 상태 객체
userbox.style.backgroundImage=`url("img/마리오이동.png")`
	// 2. 왼쪽 , 오른쪽 누를때 css left 변경
	if( e.keyCode == 37) {
		console.log('왼쪽으로 이동')	// css left 차감
		u_left -= 10; // 10 차감
		// * 유효성 검사로 배경 밖으로 못나가게 해야 한다
		if (u_left <0) {u_left =0;} // 만약에 위치가 0보다 작아지면 위치를 0으로 고정
		
	}else if ( e.keyCode == 39){
		console.log('오른쪽으로 이동')	// css left 증가
		u_left += 10; // 10 증가
		if (u_left > 920) {u_left = 920;} // 만약에 위치가 920보다 커지면 위치를 920으로 고정		
	}else if (e.keyCode == 65){ // a키를 눌렀을때 
		console.log('공격')
		userbox.style.backgroundImage=`url("img/마리오공격.png")`
	}
	
	
	
	// 3. 현재 위치값을 대입
	userbox.style.left = `${u_left}px`
	
	console.log(userbox.style.left)

})


// 2. 키 누르고 떼었을때 = keyup

document.body.addEventListener( 'keyup' , (e)=>{ 
	//키 누르고있다가 손 떼었을때 원래 이미지로 변경
	userbox.style.backgroundImage=`url("img/마리오이동.png")`
})




















