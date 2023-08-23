package model2.dao;

import java.util.ArrayList;

import javax.servlet.jsp.tagext.TryCatchFinally;

import model2.dto.AccountBookDto;

public class AccountBookDao extends Dao{
	
	private static AccountBookDao accountBookDao = new AccountBookDao();
	public static AccountBookDao getInstance() {return accountBookDao;}
	private AccountBookDao() {}
	
	// 등록
	public boolean acbWrite(String content , int money , String date) {
			System.out.println("acbWrite 실행 되나");
		try {			
			String sql = "insert into accountbook(content , money , date) values (? , ? , ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, money);
			ps.setString(3, date);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("acbWirte 오류 " + e);
		} return false;
		
		
	}//acbWrite
	
	
	// 출력
	public ArrayList<AccountBookDto> acbRead() {
		ArrayList<AccountBookDto> list = new ArrayList<>();
		
		try {
			
			String sql = "select * from accountbook order by date desc;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				AccountBookDto accountBookDto = new AccountBookDto(
						rs.getInt(1) , rs.getString(2) , rs.getInt(3), rs.getString(4));
				list.add(accountBookDto);
			}
			
		} catch (Exception e) {

		}return list;
		
		
	} // acbRead
	
	
	// 수정
	public boolean acbUpdate(int ano , String content) {
		
		try {
			String sql = "update accountbook set content = ? where ano = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, ano);
			int row = ps.executeUpdate();
			if (row ==1) {
				return true;
			}return false;

		} catch (Exception e) {
			System.out.println("acbUpdate 오류 발생 " + e);
		}
		
		return false;
		
	} // acbUpdate
		

	
	// 삭제
	
	public boolean acbDelete(int ano) {
		
		try {
			String sql = "delete from accountbook where ano = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ano);
			int row = ps.executeUpdate();
			
			if (row == 1) {
				return true;
			}return false;
			
		} catch (Exception e) {
			System.out.println("acbDelete 오류 발생 " + e);
		}
		
		return false;
		
		
		
	} // acbDelete
	
	
}//class
