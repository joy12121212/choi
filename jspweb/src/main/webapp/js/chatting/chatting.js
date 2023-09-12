console.log('chatting js 실행')


// * ajax(기본값 비동기통신) 가 응답의 결과를 가지고 오기전에 아래코드 실행. [ loginState 변경되기전에 실행되므로 문제발생 ]
// - 해결방안 ajax 동기화 통신 하자.. 
// 1. 비 로그인시 입장 불가능.. 
if( loginState == false ){ alert('회원전용 페이지입니다.'); location.href="/jspweb/member/login.jsp"; }
console.log('채팅js에서 loginState ' + loginState + loginMid)


// 2. JS 클라이언트[유저] 소켓 만들기 
console.log( '채팅방에 입장한 아이디 : ' + loginMid );
let clientSocket = new WebSocket(`ws://192.168.17.134:80/jspweb/serversokcet/${loginMid}`);
	// - 클라이언트소켓이 생성되었을때 자동으로 서버소켓에 접속 ----> 서버소켓의 @OnOpen 으로 이동
	// - 서버소켓URL에 매개변수 전달하기 [- 주로 식별자 전달 ] 서버소켓URL/데이터1/데이터2/데이터3
	// --- 메소드 4가지 메소드 자동으로 실행 
		// 1. (자동실행) 클라이언트소켓이 정상적으로 서버소켓 접속했을때
	clientSocket.onopen = e => { console.log('서버와 접속이 성공'); 	} ;
		// 2. (자동실행) 클라이언트소켓이 서버소켓과 연결에서 오류가 발생했을때.
	clientSocket.onerror = e => { console.log('서버와 오류발생:'+e ); };
		// 3. (자동실행) 클라이언트소켓이 서버소켓과 연결이 끊겼을때.
	clientSocket.onclose = e => { console.log('서버와 연결 끊김:'+e ); };
		// 4. (자동실행) 클라이언트소켓이 메시지를 받았을때.
	clientSocket.onmessage = e => onMsg( e ); 
		// send 보내기는 없음.
		
		
// 3. 서버에게 메시지 전송 
function onSend(){
	// 3-1 textarea 입력값 호출 
	let msg = document.querySelector('.msg').value;
	if( msg == ''){ alert('내용을 입력해주세요.'); return; }	
	// 3-2 메시지 전송 .. . 
	clientSocket.send( msg ); 
	// 클라이언트소켓과 연결된 서버소켓에게 메시지 전송 ----> 서버소켓의 @OnMessage 으로 이동 
	
	document.querySelector('.msg').value=``;
	
}
// 4. 메시지를 받았을때 후추 행동(메소드) 선언 
function onMsg( e ){
	console.log( e ); // e : 메시지 받았을때 발생한 이벤트 정보가 들어있는 객체
	console.log( e.data ); // .data 속성에 전달받은 메시지 내용 
	
	let msg = JSON.parse( e.data );
		// JSON.parse( ) 		: 문자열타입의 JSON형식을 JSON타입으로 변환 
		// JSON.stringify( ) 	: JSON타입 을 문자열 타입 (JSON형식 유지)으로 변환 
		console.log(msg.msg)	//java , js consle 내 출력시 줄바꿈\n -> html <br/>
		
		// 특정 문자열 찾아서 치환
		let content= msg.msg.replace('\n' , '<br>') //replace(변경할 문자열|정규표현식 , 새로운문자 )
		console.log(content)
		// 특정 문자열 모두 치환			java = replaceAll(); , js : 정규표현식
		content = msg.msg.replace('/\n/gi' , '<br>');
		console.log(content)
		
	// 1. 어디에 출력할껀지 
	let chatcont = document.querySelector('.chatcont')
	// 2. 무엇을 
	let html = ``;
		// 2-2 만약에 내가 보냈으면. [ 보낸사람아이디와 로그인된사람의 아이디와 같으면 ]
		if( msg.frommid == loginMid ){
				html = `<div class="rcont"> 
							<div class="subcont">
								<div class="date"> ${msg.date} </div>
								<div class="content"> ${ content } </div>
							</div>
						</div>`;
		}else{ // 2-2 내가 보낸 내용이 아니면
			html = `
					<div class="lcont"> 
						<img class="pimg" src="/jspweb/member/img/${ msg.frommimg }" />
						<div class="tocont">
							<div class="name">${ msg.frommid }</div>
							<div class="subcont">
								<div class="content"> ${ content } </div>
								<div class="date"> ${msg.date} </div>
							</div>
						</div>
					</div>`
		}
	// 3. 누적 대입 [ 기존 채팅목록 에 이어서 추가 += ]
	chatcont.innerHTML += html;
	
	//-------------------------스크롤 최하단으로 내리기(스크롤 이벤트) --------------------//
	
	// 1. 현재 스크롤의 상단 위치 좌표.
//	let topHeight = chatcont.scrollTop; // dom객체.scrollTop : 해당 div의 스크롤 상단위치
//	console.log(topHeight)
	// 2. 스크롤의 전체 높이
	
	
	chatcont.scrollTop = chatcont.scrollHeight;
	
}


function onEnterKey(){
	// 1. 만약에 컨트롤 + 엔터면 줄바꿈
	if(window.event.keyCode == 13 && window.event.ctrlKey){
		document.querySelector('.msg').value=`\n`; return;
		}
	// 2. 엔터 입력하면 메세지 전송
	if(window.event.keyCode == 13){onSend();return;}	
	
	
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