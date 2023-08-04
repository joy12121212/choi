package mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc연동 {
	public static void main(String[] args) {
			// 1. 908p : 현재 프로젝트에 jdbc 파일을 build path add 하기
			// 2. 900p : db연결하기 위해 jdbc Driver 클래스 찾앙서 메모리 로딩 하기
				// 이거슨 오라클 -	 Class.forName("oracle.jdbc.OracleDriver");
		try {		// 이거슨 mysql -	 Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
				// 만약에 해당 jdbc 드라이버 클래스가 검색이 실패하면 예외발생 - > 예외처리
			// 3. DriverManager.getConnection(); 메소드가 연결 성공하면 db 와 연결된 객체 리턴 - > 만약 실패하면 예외 발생 - > 예외처리
	//		Connection conn = DriverManager.getConnection("DB주소" , "계정명" , "비밀번호");
	//			 1. DB주소 :	1. jdbc:oracle:thin:@localhost:1521/orc1
	//						2. jdbc:mysql://localhost:3306/orcl
			
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web" , "root" , "1234");
			System.out.println("연동 성공" + conn);
		}
		catch(Exception e) {
			System.out.println("연동 실패 사유 : " + e); // 객체 출력하면 왜 예외가 발생했는지 사유 출력됨
		}
		
	}//main

}//class



/*

	예외처리 : 
		- Exception 클래스
		- 예외[오류] 발생했을때 흐름 제어 [ 만약에 오류가 발생했을때 그 오류를 수정하는게 아니라 다른 코드로 흐름 제어 ]
		- try{} catch{}
			try{예외[오류]가 발생할거 같은 코드}
			- 경험으로 ..... 눈치껏.......
		- 예외 가 발생할것 같은 코드
			- 일반예외 : 컴파일 과정에서 발생하는 예외 [ 미리 컴파일 전에 빨간줄 나옴 ] - 파일처리 , db 연동 , 입/출력 등~~~~
			- 실행예외 : 실행 도중에 발생하는 예외 [ 개발자의 경험에 의존, 판단 ] - 실행중 각종 오류 [ 타입 에러 , 인덱스 부족 등등 ]
			

	db연동/조작 에 필요한 클래스/인터페이스
		0. DriverManager		: 연동 db 객체 생성 클래스
		1. Connection			: preparedStatement 필요한 객체 생성
		2. preparedStatement	: sql의 ddl , dml 문 실행할때 사용
		3. ResultSet			: db에서 가젼온 데이터를 읽을 때 사용






*/