package controller.chatting;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.OnClose;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/*
	1. 서버 소켓 만들기
		1. 클래스 선언
		2. 클래스 위에 @ServerEndpoint("/ChattingSocket" 서버소캣의url정의)
			클라이언트 소켓들이 접속하는 위치
		3. 서버소켓의 필수 메소드
			@OnOpen			: 클라이언트 소켓이 서버 소켓에 접속했을때
			@OnClose		: 클라이언트 소켓이 서버 소켓과 연결이 끊겼을때
			@OnMessage		: 클라이언트 소켓이 메세지를 보냈을때
			@OnError		: 클라이언트 소켓이 서버 소켓 연결에 에러 발생 했을때

*/

@ServerEndpoint("/ChattingSocket")

public class ChattingSocket {

	static ArrayList<Session> 접속명단 = new ArrayList<>();
	
	// 1.
	@OnOpen // z클라이언트가 서버소켓에 접속했을때 매핑/연결
	public void onOpen(Session session) {
		System.out.println("클라 소켓 접속" + session);
		System.out.println(session.getId());
		System.out.println(session.getRequestURI());
		
	접속명단.add(session);
	
	System.out.println("현재접속명단 : " + 접속명단);
	
	}
	
	// 2.클라이언트가 서버소켓과 연결이 닫혔을때 
	@OnClose
	public void onClose(Session session) {접속명단.remove(session);}
	
	// 3.
	@OnMessage // 클라이언트가 서버소켓에 메세지를 보냈을때 연결/매핑
	public void onMessage(Session session , String msg) {
		System.out.println("msg뭐야"+msg);
		//현재 접속된 명단들에게 메세지 전달
		for(int i = 0; i<접속명단.size();i++) {Session s= 접속명단.get(i);}
		for(Session s :  접속명단) {}  //for(Session s : ) Session 타입이라서
		접속명단.forEach(s->{
		try {
			s.getBasicRemote().sendText(msg);
			// s : 접속명단에 있는 클라이언트소켓 중 하나
			// getBasicRemote() : 메세지 전송 메소드
			//.sendText() : 메시지를 String 타입으로 전송
		} catch (IOException e) {System.out.println("메세지 전송 에러코드 : " + e);}
		});
	}//onMessage	

	
	
	
}//class
