package project;

import project.MemberDTO;
import java.sql.*;

public class MemberDAO {

	public void insert(MemberDTO dto) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/phc?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);


		String sql = "insert into member (id,pwd,name,height,age,gender,weight,gcal,gdate) values(?,?,?,?,?,?,?,?,?)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPassword());
		ps.setString(3, dto.getName());
		ps.setInt(4, dto.getHeight());
		ps.setInt(5, dto.getAge());
		ps.setString(6, String.valueOf(dto.getGender()));

		ps.setInt(7, dto.getWeight());
		ps.setInt(8, dto.getGcal());
		ps.setInt(9, dto.getGdate());


		ps.executeUpdate();


		ps.close();
		con.close();

	}

//	public ArrayList<MemberDTO> selectAll() throws Exception {
//		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
//		Class.forName("com.mysql.jdbc.Driver");
//
//		String url = "jdbc:mysql://localhost:3306/phc?characterEncoding=utf8";
//		String user = "root";
//		String password = "1234";
//
//		Connection con = DriverManager.getConnection(url, user, password);
//
//		String sql = "select * from member";
//
//		PreparedStatement ps = con.prepareStatement(sql);
//
//		ResultSet rs = ps.executeQuery();
//
//		while (rs.next()) {
//
//			String id = rs.getString(1);
//			String name = rs.getString(2);
//			String pwd = rs.getString(3);
//			int height = rs.getInt(4);
//			int age = rs.getInt(5);
//			Character gender = rs.getChar(6);
//			int weight = rs.getInt(7);
//			int gcal = rs.getInt(8);
//			int gdate = rs.getInt(9);
//
//		}
//
//		ps.close();
//		con.close();
//
//		return list;
//	}

	public boolean select(String id, String pwd) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/phc?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "select * from member where id  = ? and pwd = ?"; // two question in same time
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, id);
		ps.setString(2, pwd);


		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return true;
		}
		ps.close();
		con.close();
		return false;// 묶어서 보냄
		
	}
	public boolean selectId(String id) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/phc?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "select * from member where id  = ?"; // two question in same time
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		ps.close();
		con.close();
		if (rs.next()) {
			return true;
		}else {
			return false;
		}
	}

	public MemberDTO selectKcal(String id) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/phc?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);

		String sql = "select * from member where id  = ?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		MemberDTO dto = new MemberDTO();
		if (rs.next()) {
			dto.setId(rs.getString(1));
			dto.setPassword(rs.getString(2));
			dto.setName(rs.getString(3));
			dto.setHeight(rs.getInt(4));
			dto.setWeight(rs.getInt(5));
			dto.setAge(rs.getInt(6));
			dto.setGender(rs.getString(7).charAt(0));
			dto.setGcal(rs.getInt(8));
			dto.setGdate(rs.getInt(9));
			dto.setMain(rs.getInt(10));
			dto.setLkcal(rs.getInt(11));
		}
		ps.close();
		con.close();
		return dto;
	}
}
