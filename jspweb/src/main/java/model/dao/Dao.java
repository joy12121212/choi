package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	// 필드
	public Connection conn;			 // db 연동 객체
	public PreparedStatement ps;	 // 연동된 db 조작 객체
	public ResultSet rs;			 // sql 조작 결과를 가져오는 객체
	
	
	// 생성자
	public Dao() { // 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb" , "root" , "1234");
			System.out.println("db 연동 됐어요");
			
		} 
		catch (Exception e) {System.out.println("연동 실패 오류 : " + e);}
		
	}//dao
	

}//class
