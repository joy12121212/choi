console.log('chatting js 실행')



// 1. 클라이언트 소캣 만들기
	// 1. js웹소켓 객체('ws://ip주소:포트번호/서버소켓url')
	let 클라이언트소켓 = new WebSocket('ws://localhost:80/jspweb/ChattingSocket');console.log(클라이언트소켓)
	// 2 onopen , onclose , onsend , onmessage
	// 내가 마든 함수를 클라이언트소켓 속성에 대입
	클라이언트소켓.onmessage = (e) =>  onmsg(e);

// 2. 연결된 서버소켓에게 메세지 보내기
function msgsend(){
	// 1. input 값 가져오기
	let msg = document.querySelector('.inputcontent').value;
	// 2. 클라이언트소켓 .send();	
	클라이언트소켓.send(msg);//input 입력받은 데이터 클라이언트소켓 객체에 대입	
	
	document.querySelector('.inputcontent').value=``;
}

// 3. 연결된 서버소켓으로부터 메세지 받음
function onmsg(e){
	console.log(e.data)
	
	document.querySelector('.contentbox').
	innerHTML+=`<div>${e.data}</div>`
}


/*
	1.ajax
	
		발신자(보내는사람)	: ajax
		수신자(받는사람)	: 서블릿
		
		js				java[서블릿]

		ajax
				rest	get
						post
						put
						delete

	2. (웹)소켓
		소켓 : 통신의 종착점[도착위치]
		- 전제조건 : 서버가 클라이언트 정보(수신자 정보)를 보관
		
		js				java
		[클라이언트소캣]	[서버소캣]
		websocket		
		1. 서버소캣 접속	2. 서버소캣 24시간 상시 클라이언트 소캣 명단 소지
		3. 데이터 전송		4. 데이터 수신
		
		
*/

/*
			클라이언트[사용자]						서버[서비스 제공업체]
			
		강아지 카카오톡 -> 1. 채팅방에 메세지발송 ->	제주도[카카오 본사]
												2. 메세지 수신		
												3. 수신자에게 전달
		망아지 카카오톡 <- 4. 받음
				
		송아지 카카오톡 <- 4. 받음

		박하지 카카오톡 <- 4. 받음
		
		
		
*/