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
	
	// 3. 수정 [ 인수 : 수정할 방문록 정보(번호int ,내용String) , 리턴 : 성공 or 실패 ]
		public boolean vupdate() {return false;}
	
	// 4. 삭제 [ 인수 : 삭제할 방문록 정보(번호int, 내용String) , 리턴 : 성공 or 실패
		public boolean vdelete() {return false;}
		
	
	
	
	
	
}//class
