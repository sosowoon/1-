package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SellCategoriesDAO {
	double percentageSum;
	
	public ArrayList<SellCategoriesDTO> selectTop3SellCategories() throws Exception {
		DBConnectionMgr mgr = DBConnectionMgr.getInstance();
		Connection con = mgr.getConnection();
		System.out.println("2. DB 연결 성공");
		
		String sql = "select distinct c.SellCategoryName, (sum(SellAmount)/(select sum(SellAmount) from sellamounts))*100 as SellAmountPercentage "
				+ "from sellamounts s LEFT OUTER JOIN sellcategories c on s.SellCategoryCode = c.SellCategoryCode "
				+ "group by c.SellCategoryCode order by sellamountpercentage desc limit 3;";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("3. SQL문 객체화 성공");

		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 실행 성공");
		
		SellCategoriesDTO dto = null;
		ArrayList<SellCategoriesDTO> list = new ArrayList<SellCategoriesDTO>();

		while(rs.next()) {
			dto = new SellCategoriesDTO();
			dto.setSellCategoryName(rs.getString(1));
			dto.setSellAmountPercentage(rs.getDouble(2));
			percentageSum += rs.getDouble(2);
			list.add(dto);
		}
		dto = new SellCategoriesDTO();
		dto.setSellCategoryName("rest");
		dto.setSellAmountPercentage(100-percentageSum);
		list.add(dto);
		System.out.println(100-percentageSum);
		System.out.println("--------------: size : " +  list.size());
		
		ps.close();
		mgr.freeConnection(con);
		
		return list;
	}

}