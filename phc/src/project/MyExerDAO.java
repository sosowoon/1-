package project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MyExerDAO {
	public ArrayList<MyExerDTO> selectAll(Date date, String sid) throws Exception {
		ArrayList<MyExerDTO> list = new ArrayList<MyExerDTO>();
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/phc";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from myexer where date = ? and id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDate(1, date);
		ps.setString(2, sid);

		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			MyExerDTO dto = new MyExerDTO();
			dto.setMyeid(rs.getInt(1));
			dto.setId(rs.getString(2));
			dto.setDate(rs.getDate(3));
			dto.setAmount(rs.getInt(4));
			dto.setEid(rs.getInt(5));
			dto.setResult(rs.getBoolean(6));
			list.add(dto);
		}
		ps.close();
		con.close();
		
		return list;
	}
	public void update(int smyeid, boolean sresult) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/phc";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "update myexer set result = ? where myeid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setBoolean(1, sresult);
		ps.setInt(2, smyeid);
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	public void insert(MyExerDTO dto) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/phc";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into MyExer(id,date,amount,eid) values(?,?,?,?,?)";
	
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setDate(2, dto.getDate());
		ps.setInt(3, dto.getAmount());
		ps.setInt(4, dto.getEid());
		ps.setBoolean(5, false);
		
		
		ps.executeUpdate();
		ps.close();
		con.close();
	}

	

	public ArrayList<MyExerDTO> select(Date date, String id, boolean result) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/phc?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "select * from MyExer where id  = ? and result = ? and date = ?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, id);
		ps.setBoolean(2, result);
		ps.setDate(3, date);

		ResultSet rs = ps.executeQuery();
		ArrayList<MyExerDTO> list = new ArrayList<MyExerDTO>();

		while (rs.next()) {
			MyExerDTO dto = new MyExerDTO();
			dto.setMyeid(rs.getInt(1));
			dto.setId(rs.getString(2));
			dto.setDate(rs.getDate(3));
			dto.setAmount(rs.getInt(4));
			dto.setEid(rs.getInt(5));
			dto.setResult(rs.getBoolean(6));
			list.add(dto);
		}
		ps.close();
		con.close();
		return list;
	}

}

