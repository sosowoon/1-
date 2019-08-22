package project;

import java.sql.*;

public class ExerciseDAO {
	public ExerciseDTO select(int seid) throws Exception {
		ExerciseDTO dto = new ExerciseDTO();
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/phc";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "select * from exercise where eid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, seid);
		ResultSet rs = ps.executeQuery();

		if(rs.next()) {
			dto.setEid(rs.getInt(1));
			dto.setEname(rs.getString(2));
			dto.setKind(rs.getString(3).charAt(0));
			dto.setContents(rs.getString(4));
			dto.setImg(rs.getString(5));
			dto.seteCal(rs.getInt(6));
		}
		ps.close();
		con.close();
		return dto;
	}
}
