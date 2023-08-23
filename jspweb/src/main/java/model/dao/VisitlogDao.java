package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.dto.VisitlogDto;

public class VisitlogDao extends Dao {
	
	private static VisitlogDao visitlogDao = new VisitlogDao();
	public static VisitlogDao getInstance() {return visitlogDao;}
	private VisitlogDao() {}
	
	// 1. 저장 [ 인수 : 저장할 내용이 담긴 dto , 리턴 : 성공 or 실패 ]
		public boolean vwrite(VisitlogDto visitlogDto) {
			
			try {
				String sql = "insert into visitlog(writer , pw , content ) values (?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, visitlogDto.getWriter());
				ps.setString(2, visitlogDto.getPw());
				ps.setString(3, visitlogDto.getContent());
				ps.executeUpdate();
				return true;
				
			} catch (Exception e) {System.out.println("vwrite오류 : " + e);}
			
			return false;}
	
	// 2. 호출 [ 인수 : x , 리턴 : 여러<arraylist>의 방문록 dto ]
		public ArrayList<VisitlogDto> vread() {
			ArrayList<VisitlogDto> list = new ArrayList<>();
			try {
				String sql = "select * from visitlog order by date desc;";
				ps= conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {//rs.next() : selcet 검색 결과중 다음 레코드로 이동 = 존재하면 true , 아니면 false // 마지막 레코드까지 쭉 돈다
					// * 레코드 1개(행)
					VisitlogDto visitlogDto = new VisitlogDto(
							rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getString(4) , rs.getString(5) );
					list.add(visitlogDto);
				}
			
				
			} catch (Exception e) {
				System.out.println("오루"+e);
			}return list;
			
			}
	
	// 3. 수정 [ 인수 : 수정할 방문록 정보(번호int ,내용String, 비번 String) , 리턴 : 성공 or 실패 ]
		public boolean vupdate(int vno , String vcontent , String vpwd) {
			
			try {
				String sql = "update visitlog set content = ? where vno = ? and pw = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, vcontent);
				ps.setInt(2, vno);
				ps.setString(3, vpwd);
				int row = ps.executeUpdate();
				
				if (row == 1) {return true;}return false;
			} 
			
			catch (Exception e) {
				System.out.println("에러에러 : " +e);
			}
			
			
			
			
			return false;}
	
	// 4. 삭제 [ 인수 : 삭제할 방문록 정보(번호int,) , 리턴 : 성공 or 실패
		public boolean vdelete(int vno, String vpwd) {
			
			
			try {
				String sql = "delete from visitlog where vno = ? and pw = ?;";
				
				ps = conn.prepareStatement(sql); // 연결
				ps.setInt(1, vno); // 대입
				ps.setString(2, vpwd); // 대입
				int row = ps.executeUpdate(); // 실행
				
				if (row == 1) {return true;} // 가져와서 조건 따지기
				//왜 row == 1 이냐 ? 방명록 번호와 비밀번호가 일치하는 row를 삭제하면 1을 반환받으니까 // 1이 아니면 삭제 못한거 or 삭제 여러개 = 오류 
				return false;
				
			} catch (Exception e) {
				System.out.println("에러에러 : " +e);
			}
			return false;
		}//vdelete
		
	
	
	
	
	
}//class
