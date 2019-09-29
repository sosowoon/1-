package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CommercialDistrictsPerSellCategoriesDAO {
	
	public ArrayList<CommercialDistrictsPerSellCategoriesDTO> selectTop10Districts(CommercialDistrictsPerSellCategoriesDTO dto) throws Exception {
		DBConnectionMgr mgr = DBConnectionMgr.getInstance();
		Connection con = mgr.getConnection();
		System.out.println("2. DB 연결 성공");
		
		String sql = "select c.CommercialDistrictName, s.Year, s.Quarter, d.SellCategoryName, s.SellAmount, c.latitude, c.longitude "
				+ "from sellamounts s LEFT OUTER JOIN commercialdistricts c on "
				+ "s.CommercialDistrictCode = "
				+ "c.CommercialDistrictCode "
				+ "left join sellcategories d on "
				+ "s.SellCategoryCode = "
				+ "d.SellCategoryCode where Year = ? and Quarter = ? and SellCategoryName = ? order by s.SellAmount desc limit 10";
		PreparedStatement ps = con.prepareStatement(sql);
		//ResultSet rs = ps.executeQuery(sql);
		ps.setInt(1, dto.getYear());
		ps.setInt(2, dto.getQuarter());
		ps.setString(3, dto.getSellCategoryName());
		System.out.println(sql);
		
		System.out.println(dto.getYear());
		System.out.println("3. SQL문 객체화 성공");

		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 실행 성공");
		
		
//		int rowCount = 0;
//		if (rs != null) {
//			rs.last(); // moves cursor to the last row
//			rowCount = rs.getRow(); // get row id
//		}
//		
//		System.out.println(rowCount);
		
		CommercialDistrictsPerSellCategoriesDTO dto2 = null;
		ArrayList<CommercialDistrictsPerSellCategoriesDTO> list = new ArrayList<CommercialDistrictsPerSellCategoriesDTO>();
		while(rs.next()) {
			dto2 = new CommercialDistrictsPerSellCategoriesDTO();
			dto2.setCommercialDistrictName(rs.getString(1));
			dto2.setYear(rs.getInt(2));
			dto2.setQuarter(rs.getInt(3));
			dto2.setSellCategoryName(rs.getString(4));
			dto2.setSellAmount(rs.getLong(5));
			dto2.setLatitude(rs.getDouble(6));
			dto2.setLongitude(rs.getDouble(7));
			list.add(dto2);
		}
		
		System.out.println("--------------: size : " +  list.size());
		
		ps.close();
		mgr.freeConnection(con);
		
		return list;
	}

}