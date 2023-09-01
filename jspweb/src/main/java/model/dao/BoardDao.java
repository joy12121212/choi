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
				String sql = "";
				
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					BoardDto dto = new BoardDto(
					rs.getInt(1), rs.getString(2),rs.getString(3),
					rs.getString(4),rs.getInt(5),rs.getInt(6)
					);
					
					
				}
				
			} catch (Exception e) {System.out.println("보드다오 blistAll 에러 : " + e);}
		
		
		return list;
		
		
	}
		// 3 개별 글 출력
		
		// 4 게시물 수정
		
		// 5 게시물 삭제
		
		// 6 조회수 증가
		
		
		
}//dao
