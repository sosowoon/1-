package project;

import java.sql.*;
import java.util.ArrayList;

public class DietDAO {
	public void insert(DietDTO dto) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/phc";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into diet values(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, dto.getDid());
		ps.setString(2, dto.getDname());
		ps.setInt(3, dto.getDcal());
		ps.setInt(4, dto.getCarb());
		ps.setInt(5, dto.getProt());
		ps.setInt(6, dto.getFat());

		ps.executeUpdate();
		ps.close();
		con.close();
	}

	public ArrayList<DietDTO> selectAll() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/phc";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "select * from diet";
		PreparedStatement ps = con.prepareStatement(sql);
		ArrayList<DietDTO> list = new ArrayList<DietDTO>();
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			DietDTO dto = new DietDTO();
			dto.setDid(rs.getInt(1));
			dto.setDname(rs.getString(2));
			dto.setDcal(rs.getInt(3));
			dto.setCarb(rs.getInt(4));
			dto.setProt(rs.getInt(5));
			dto.setFat(rs.getInt(6));
			list.add(dto);
		}
		ps.close();
		con.close();
		return list;
	}
	public DietDTO select(int sdid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/phc";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "select * from diet where did = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, sdid);
		ResultSet rs = ps.executeQuery();

		DietDTO dto = new DietDTO();
		if(rs.next()) {
			dto.setDid(rs.getInt(1));
			dto.setDname(rs.getString(2));
			dto.setDcal(rs.getInt(3));
			dto.setCarb(rs.getInt(4));
			dto.setProt(rs.getInt(5));
			dto.setFat(rs.getInt(6));
		}
		ps.close();
		con.close();
		return dto;
	}
}
