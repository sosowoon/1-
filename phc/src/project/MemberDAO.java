package project;

import java.util.ArrayList;

import project.MemberDTO;

import java.sql.*;

public class MemberDAO {

	public void insert(MemberDTO dto) throws Exception {

		// 1.connector 설정
		Class.forName("com.mysql.jdbc.Driver");

		// 2.DB연결

		String url = "jdbc:mysql://localhost:3306/phc?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. DB연결 성공 okayy... ");

		System.out.println("3. SQL 문 객체화 okay");

		String sql = "insert into member (id,pwd,name,height,age,gender,weight,gcal,gdate) values(?,?,?,?,?,?,?,?,?)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1,dto.getId());
		ps.setString(2,dto.getPassword());
		ps.setString(3,dto.getName());
		ps.setInt(4,dto.getHeight());
		ps.setInt(5,dto.getAge());
		ps.setString(6,String.valueOf(dto.getGender()));  // String 아닌 타입을 String 가지고 오고 싶으면 
		//String.valueOf 
	
		ps.setInt(7,dto.getWeight());
		ps.setInt(8,dto.getGcal());
		ps.setInt(9,dto.getGdate());
	


		System.out.println("3, sql문 결정 성공..");

		// 4. SQL문 전공 요청
		ps.executeUpdate();
		System.out.println("4. SQL문 전송 요청 성공");

		System.out.println("4. sql 실행");


		ps.close();
		con.close();

	}

	public ArrayList<MemberDTO> selectAll() throws Exception {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		// 1.드라이버 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1.드라이버 설정  ok...");

		// 2.DB연결
		// url. user. password

		String url = "jdbc:mysql://localhost:3306/phc?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. DB연결 성공 okayy... ");
		// 3.SQL문 결정

		String sql = "select * from member";
		System.out.println("3. SQL 문 객체화 okay");

		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			String id = rs.getString(1);
			String name = rs.getString(2);
			String pwd = rs.getString(3);
			int height = rs.getInt(4);
			int age = rs.getInt(5);
//			Character gender = rs.getChar(6);
			int weight = rs.getInt(7);
			int gcal = rs.getInt(8);
			int gdate = rs.getInt(9);

			// '?' 쓰지 않는다. (?,?,?,?) 이렇게 쓴다.
			System.out.println("4. SQL  실행요청  okay");
		}

		ps.close();
		con.close();

		return list;
	} // selectall end

	public boolean select(String id, String pwd) throws Exception {

		// 1.드라이버 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1.드라이버 설정  ok...");

		// 2.DB연결
		// url. user. password

		String url = "jdbc:mysql://localhost:3306/phc?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. DB연결 성공 okayy... ");
		// 3.SQL문 결정

		String sql = "select * from member where id  = ? and pwd = ?"; // two question in same time
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, id);
		ps.setString(2, pwd);

		// '?' 쓰지 않는다. (?,?,?,?) 이렇게 쓴다.

		System.out.println("3. SQL 문 객체화 okay");

		// 4.SQL문 실행 요청

		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 실행 요청 okay");
		MemberDTO dto = new MemberDTO();

		if (rs.next()) {
			return true;

		}
		return false;// 묶어서 보냄
	}

}// class end
