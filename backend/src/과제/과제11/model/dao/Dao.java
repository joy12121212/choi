package 과제.과제11.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Dao { // 각종 dao 클래스를 대표하는 부모클래스
	
	// 1. 필드
	// [import java.sql  로 가져와야된다]
	public Connection conn;			 // db 연동 객체
	public PreparedStatement ps;	 // 연동된 db 조작 객체
	public ResultSet rs;			 // sql 조작 결과를 가져오는 객체

	// 2. 생성자 : 객체 생성시 초기화 담당
		// 기본생성자에 db 연동 코드 작성 //dao 객체 생성시 바로db 연동
	
	public Dao() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web" , "root" , "1234");
		System.out.println("db연동 성공");

	
		}
		catch (Exception e) {
			System.out.println("db연동 실패 "+ e);
		}
	}
	
	

}
