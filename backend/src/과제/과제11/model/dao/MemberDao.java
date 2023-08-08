package 과제.과제11.model.dao;



import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao{
	
	private static MemberDao memberDao = new MemberDao();
	
	public static MemberDao getInstance() {return memberDao;}

	private MemberDao() {}
	
	
	public boolean infoCheck(String 검색할필드명 , String 검색할값) {
		
		try {
	
			String sql = "select * from member where " + 검색할필드명 +" = ?";
			System.out.println(sql);
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, 검색할값);
			rs = ps.executeQuery();
			
			if (rs.next()) {return true;
				
			}
		} //try
		
		catch (Exception e) {
			System.out.println("오류" + e);
		}
		
		return true;
	}//infocheck
	
	
	
	
	
	
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

	// 3. 아이디 찾기 sql
	
	public String findById( String name , String phone) {
		System.out.println("아이디찾기 sql 도착");
		try {
		String sql = "select * from member where mname = ? and mphone=?;";
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, phone);
		
		// insert / update / delete : ps.excteUpdate();   /   select : ps.excuteQuery();
		rs = ps.executeQuery();
		

		
		//rs.next()	: 검색된 레코드중 다음 레코드로 이동
		//rs.getString()	: 현재 위치한 레코드의 필드값 호출
		// 와이드카드로 전체를 검색했으면 필드값의 순서(1번 2번 3번) 숫자를 넣어야 됨
		// 필드를 검색했으면 id , pw , phone 라면 id 값을 받으려면 1 , pw는 2 , phone 는 3 입력
	
		if (rs.next()) {
			return rs.getString(2);
		}//if
		
		}//try
		catch (Exception e) {
			System.out.println("아이디 찾기 실패 " + e);
		}//catch
		return null;
	}// find id
	

	
	//4. 비밀번호 찾기 sql
	public String findByPw(String id , String phone) {
		
		try {
		String sql = "select * from member where mid = ? and mphone=?;";
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, phone);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			return rs.getString(3);
		}//if
				
		}//try
		catch (Exception e) {
			System.out.println("비밀번호 찾기 실패 " + e);
		}//catch
		
		return null;
		
	}// find pw
	
}
