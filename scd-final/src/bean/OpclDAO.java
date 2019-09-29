package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OpclDAO {
	public ArrayList<OpclDTO> selectTop5Opcl(OpclDTO dto) throws Exception {
		DBConnectionMgr mgr = DBConnectionMgr.getInstance();
		Connection con = mgr.getConnection();
		
		String sql = "select c.commercialDistrictCode, c.commercialDistrictName, o.Year, o.Quarter, d.sellCategoryName, o.op, o.cl, c.latitude, c.longitude\r\n" + 
				"	from opcl o \r\n" + 
				"		LEFT OUTER JOIN commercialdistricts c on o.commercialDistrictCode = c.commercialDistrictCode \r\n" + 
				"		left join sellcategories d on o.sellCategoryCode = d.sellCategoryCode\r\n" + 
				"	where o.year = ? and o.quarter = ? and d.sellCategoryName = ?\r\n" + 
				"	order by o.op desc limit 5"; 
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, dto.getYear());
		ps.setInt(2, dto.getQuarter());
		ps.setString(3, dto.getSellCategoryName());
		ResultSet rs = ps.executeQuery();
		
		
		OpclDTO dto2 = null;
		ArrayList<OpclDTO> list = new ArrayList<OpclDTO>();
		while(rs.next()) {
			dto2 = new OpclDTO();
			dto2.setCommercialDistrictCode(rs.getString(1));
			dto2.setCommercialDistrictName(rs.getString(2));
			dto2.setYear(rs.getInt(3));
			dto2.setQuarter(rs.getInt(4));
			dto2.setSellCategoryName(rs.getString(5));
			dto2.setOp(rs.getInt(6));
			dto2.setCl(rs.getInt(7));
			dto2.setLatitude(rs.getDouble(8));
			dto2.setLongitude(rs.getDouble(9));
			list.add(dto2);
		}
		ps.close();
		mgr.freeConnection(con);
		
		return list;
	}
	public ArrayList<OpclDTO> selectTop5Opcl2(OpclDTO dto) throws Exception {
		DBConnectionMgr mgr = DBConnectionMgr.getInstance();
		Connection con = mgr.getConnection();
		
		String sql = "select c.commercialDistrictCode, c.commercialDistrictName, o.Year, o.Quarter, d.sellCategoryName, o.op, o.cl, c.latitude, c.longitude\r\n" + 
				"	from opcl o \r\n" + 
				"		LEFT OUTER JOIN commercialdistricts c on o.commercialDistrictCode = c.commercialDistrictCode \r\n" + 
				"		left join sellcategories d on o.sellCategoryCode = d.sellCategoryCode\r\n" + 
				"	where o.year = ? and o.quarter = ? and d.sellCategoryName = ?\r\n" + 
				"	order by o.cl desc limit 5"; 
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, dto.getYear());
		ps.setInt(2, dto.getQuarter());
		ps.setString(3, dto.getSellCategoryName());
		ResultSet rs = ps.executeQuery();
		
		
		OpclDTO dto2 = null;
		ArrayList<OpclDTO> list = new ArrayList<OpclDTO>();
		while(rs.next()) {
			dto2 = new OpclDTO();
			dto2.setCommercialDistrictCode(rs.getString(1));
			dto2.setCommercialDistrictName(rs.getString(2));
			dto2.setYear(rs.getInt(3));
			dto2.setQuarter(rs.getInt(4));
			dto2.setSellCategoryName(rs.getString(5));
			dto2.setOp(rs.getInt(6));
			dto2.setCl(rs.getInt(7));
			dto2.setLatitude(rs.getDouble(8));
			dto2.setLongitude(rs.getDouble(9));
			list.add(dto2);
		}
		ps.close();
		mgr.freeConnection(con);
		
		return list;
	}
}
