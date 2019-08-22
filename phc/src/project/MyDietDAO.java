package project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MyDietDAO {

	public void insert(MyDietDTO dto) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/phc";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into mydiet (id,date,amount,did,time) values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setDate(2, dto.getDate());
		ps.setInt(3, dto.getAmount());
		ps.setInt(4, dto.getDid());
		ps.setInt(5, dto.getTime());

		ps.executeUpdate();
		ps.close();
		con.close();
	}

	public void delete(MyDietDTO dto) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/phc";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "delete from mydiet where mydid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, dto.getMydid());

		ps.executeUpdate();
		ps.close();
		con.close();
	}

	public ArrayList<MyDietDTO> select(int time, Date date, String sid) throws Exception {
		ArrayList<MyDietDTO> list = new ArrayList<MyDietDTO>();
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/phc";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from mydiet where time = ? and date = ? and id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, time);
		ps.setDate(2, date);
		ps.setString(3, sid);

		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			MyDietDTO dto = new MyDietDTO();
			dto.setDid(rs.getInt(1));
			dto.setId(rs.getString(2));
			dto.setDate(rs.getDate(3));
			dto.setAmount(rs.getInt(4));
			dto.setDid(rs.getInt(5));
			dto.setTime(rs.getInt(6));
			list.add(dto);
		}
		ps.close();
		con.close();
		return list;
	}

}
