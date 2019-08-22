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

		// 1.connector 설정
		Class.forName("com.mysql.jdbc.Driver");

		// 2.DB연결

		String url = "jdbc:mysql://localhost:3306/phc?characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. DB연결 성공 okayy... ");

		System.out.println("3. SQL 문 객체화 okay");

		String sql = "select e, contents ,eCal from member where eid  = ? ";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1,dto.getId());
//		ps.setString(2,dto.getPassword());
		
	


		System.out.println("3, sql문 결정 성공..");

		// 4. SQL문 전공 요청
		ps.executeUpdate();
		System.out.println("4. SQL문 전송 요청 성공");

		System.out.println("4. sql 실행");


		ps.close();
		con.close();

	}

	

	public boolean select(String id, String pwd) throws Exception {

		// 1.드라이버 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1.드라이버 설정  ok...");

		// 2.DB연결
		// url. user. password

		String url = "jdbc:mysql://localhost:3306/phc?characterEncoding=utf8";
		String user = "root";
		String password = "root";

		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. DB연결 성공 okayy... ");
		// 3.SQL문 결정

		String sql = "select * from MyExer where id  = ? and pwd = ?"; // two question in same time
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

}

