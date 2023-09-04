package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao {

		private static BoardDao boardDao = new BoardDao();
		public static BoardDao getInstance() {return boardDao;}
		private BoardDao () {}
		
		
	// 1 글쓰기
	public boolean bwrite(BoardDto dto) {
			
			String sql = "insert into board (btitle , bcontent , bfile , mno , bcno) values ( ? , ? , ? , ? ,?);";
		try {	
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getMno());
			ps.setInt(5, dto.getBcno());
		
			int row = ps.executeUpdate();
			
			if (row==1) {
				return true;
			}
			
		}catch (Exception e) {
		System.out.println("글쓰기 다오 bwrite 오류야!! : " +  e);
		}return false;
			
	}
		
		
		// 2 모든글 출력
	public ArrayList<BoardDto> blistAll(){
		
		ArrayList<BoardDto> list = new ArrayList<>();
		
			try {
				String sql = "select b.* , m.mid , m.mimg , bc.bcname from board b natural join bcategory bc natural join member m order by b.bdate desc;";
				
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					BoardDto dto = new BoardDto(
						rs.getInt("bno"),rs.getString("btitle"),rs.getString("bcontent"),
						rs.getString("bfile"),rs.getString("bdate"),
						rs.getInt("bview"),rs.getInt("mno"),rs.getInt("bcno"),
						rs.getString("mid"),rs.getString("bcname"),rs.getString("mimg")
					);
					list.add(dto);
				}
			} catch (Exception e) {System.out.println("보드다오 blistAll 에러 : " + e);}
		return list;
		
		
		
		
		
		
		
		
	}
		// 3 개별 글 출력
	public BoardDto getBoard(int bno) {
	
		try {
			String sql = "select b.* , m.mid , m.mimg ,bc.bcname\r\n"
					+ "from board b \r\n"
					+ "natural join member m\r\n"
					+ "natural join bcategory bc\r\n"
					+ "where b.bno = ?;";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs=ps.executeQuery();
			
			if (rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt("bno"),rs.getString("btitle"),rs.getString("bcontent"),
						rs.getString("bfile"),rs.getString("bdate"),
						rs.getInt("bview"),rs.getInt("mno"),rs.getInt("bcno"),
						rs.getString("mid"),rs.getString("bcname"),rs.getString("mimg")
					);
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println("보드다오 개별글 출력 에러 : " + e);
		}
		
		
		return null;
	}
	
	
	
		// 4 게시물 수정
		
		// 5 게시물 삭제
		
		// 6 조회수 증가
		
		
		
}//dao
