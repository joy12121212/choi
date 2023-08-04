package 과제.과제11.model.dao;

import java.util.Iterator;

import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao{
	
	private static MemberDao memberDao = new MemberDao();
	
	public static MemberDao getInstance() {return memberDao;}

	private MemberDao() {}
	
	
	
	
	//1. 회원가입 sql
	public boolean signupSQL(MemberDto dto) {
		System.out.println("다오 도착");
		System.out.println(dto);
		

		try {

			//1. 회원가입에 필요한 sql을 문자열에 작성해서 저장
			//테이블에 레코드 삽입 : insert into 테이블명 (필드명 ,필드명, 필드명) values( 매개변수 , 매개변수 , 매개변수 );
	
			String sql = "insert into member(mid , mpw , mname , mphone) values(? , ? , ? , ? )";
		
			// 2. 위에서 작성한 sql을 db 연동객체에 대입
			// 3. 대입된 sql 조작하기 위해 반환된 			
			ps = conn.prepareStatement(sql);
			// 4. sql에서 작성한 매개변수에 값 대입			[ .setString ( ? 번호 , 값
			ps.setString(1, dto.getMid()); // (1번 물음표에 ,  getmid) setString 저장한다
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMname());
			ps.setString(4, dto.getMphone());
		
			// 5 . sql 실행
			ps.executeUpdate(); // sql에서 컨트롤 + 엔터 하는것처럼 실행 코드
			System.out.println("오 성공함ㅋ");
			
			
			return true;
			}//try
			catch (Exception e) {
				System.out.println("실패 함" + e);
			}//catch
			return false;
			
		}//signSQL
	
	
	
		//2. 로그인 sql
	public boolean loginSQL(String id , String pw) {
		System.out.println("로그인 다오 도착");
		System.out.println(id + pw);

		try {
			// 1단계 : sql 작성한다 [sql 에서 먼저 테스트 하고 복사해서 가져와]
			String sql = "select * from member where mid = ? and mpw = ?";
			// 2단계 : sql 조작할 수 있는 객체 만들기
			ps = conn.prepareStatement(sql);
			// 3단계 : sql 조작 sql ? 매개변수 값 대입
			ps.setString(1, id);
			ps.setString(2, pw);
			// 4단계 실행 : insert / update / delete : ps.excteUpdate();   /   select : ps.excuteQuery();
			rs = ps.executeQuery();
			
			// 5단계 : sql 실행 결과 조작
			
			// 로그인은 한번만 실행하면 되기에 if 문 사용
			// 전체 회원 정보 호출시에는 while 문 사용
				
			if (rs.next()) {
				return true; // 찾는 값이 있으면 true , 없으면 false  반환 해주는 next()함수
			}
		}// try
		catch (Exception e) {System.out.println("실패" +e);
		}// catch
		return false;
	}// loginsql

	
}
