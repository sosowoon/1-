package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CommercialDistrictsDAO {
	
	public ArrayList<CommercialDistrictsDTO> selectAllDistricts() throws Exception {
		DBConnectionMgr mgr = DBConnectionMgr.getInstance();
		Connection con = mgr.getConnection();
		System.out.println("2. DB 연결 성공");
		
		/*
		 * String sql =
		 * "select distinct c.CommercialDistrictName from sellamounts s LEFT OUTER JOIN commercialdistricts c on "
		 * +
		 * "s.CommercialDistrictCode = c.CommercialDistrictCode order by c.CommercialDistrictName"
		 * ;
		 */
		String sql = "select CommercialDistrictName from commercialdistricts;";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println(sql);
		
		System.out.println("3. SQL문 객체화 성공");

		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 실행 성공");
				
		/*
		 * int rowCount = 0; if (rs != null) { rs.last(); // moves cursor to the last
		 * row rowCount = rs.getRow(); // get row id }
		 */

		/* String[] commercialDistrictNames = new String[rowCount]; */
		ArrayList<CommercialDistrictsDTO> commercialDistrictNames = new ArrayList<CommercialDistrictsDTO>();
		CommercialDistrictsDTO dto;
		/*
		 * rs.first(); int i = 0; commercialDistrictNames[i] = rs.getString(1);
		 */
		//i++;

		while (rs.next()) {
//			CalendarPlannerDTO dto = new CalendarPlannerDTO();
//			dto.setEffectiveDate(resultSet.getDate(1));
//			planDatesList.add(dto);
			dto = new CommercialDistrictsDTO();
			dto.setCommercialDistrictName(rs.getString(1));
			commercialDistrictNames.add(dto);
		}
		
		
		ps.close();
		mgr.freeConnection(con);
		
		System.out.println("finish");
		return commercialDistrictNames;
	}

}