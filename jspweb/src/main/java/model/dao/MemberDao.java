package model.dao;

import model.dto.MemberDto;

public class MemberDao extends Dao{
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance () {return memberDao;}
	private MemberDao() {}
	
	

	
	
	// 1. 회원가입
	
	public boolean signup(MemberDto dto) {
		try {
			String sql = "insert into member(mid , mpwd , memail , mimg) values (? , ? , ? ,?);";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMimg());
			
			int row = ps.executeUpdate();
			
			if (row == 1) {
				return true;
			}return false;
			
		} catch (Exception e) {
			System.out.println("오류발생 singup" + e);
		}
			return false;
	}
	
	// 2. 로그인
	
	// 3. 아이디 찾기
	
	// 4. 비밀번호 찾기
	
	// 5. 내정보 호출
	
	// 6. 아이디 / 이메일 중복 검사
	
	public boolean findIdOrEmail (String type, String data) {
		
		try {
			String sql = "select * from member where "+ type +" = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, data);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return true; // true 면 중복이라는 소리임
			}return false;
		} catch (Exception e) {
			System.out.println("findid 오류 " + e);
		}
	return false;	
	}
	
	// 7. 회원정보 수정
	
	// 8. 회원 탈퇴
	
	
	
	
	
	
	
	
	
}
