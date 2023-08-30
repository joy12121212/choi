package model.dao;

import model.dto.HrmDto;

public class HrmDao extends Dao{
	
	
	public boolean signup(HrmDto dto) {
		
		try {
			String sql = "insert into hrm (sname , sphone , sposition , simg) values (? , ? , ? , ?);";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getSname());
			ps.setString(2, dto.getSphone());
			ps.setString(3, dto.getSposition());
			ps.setString(4, dto.getSimg());
			
			int row = ps.executeUpdate();
			
			if (row == 1) {
				return true;
			}return false;
			
		} catch (Exception e) {System.out.println("직원등록 에러 : " + e);}
		
		return false;
	}

}
