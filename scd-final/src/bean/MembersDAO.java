package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MembersDAO {
	public boolean login(String m_id, String pw) {
		String sql = "SELECT * FROM members WHERE m_id = ? and pw = ?";
		DBConnectionMgr mgr = DBConnectionMgr.getInstance();
		boolean result = false;
		try {
			Connection con = mgr.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, m_id);
			ps.setString(2, pw);
			// 물음표해당하는 내용을 유저아이디로, 매개변수로 이용.. 1)존재하는지 2)비밀번호무엇인지
			// rs:result set 에 결과보관
			ResultSet rs = ps.executeQuery();
			// 결과가 존재한다면 실행

			if (rs.next()) {
				result = true; // 라긴 성공
			} else {
			} // if
		} catch (Exception e) {
			e.printStackTrace();
		} // catch

		return result;
	}// method

	public void insert(MembersDTO dto) {
		String sql = "insert into members values (?,?,?,?,?,?)";
		DBConnectionMgr mgr = DBConnectionMgr.getInstance();

		try {
			Connection con = mgr.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getM_id());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getFname());
			ps.setString(4, dto.getLname());
			ps.setInt(5, dto.getAge());
			ps.setString(6, dto.getGender());
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} // catch

	}
	public void dele(MembersDTO dto) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");  //???
		DBConnectionMgr mgr = DBConnectionMgr.getInstance();
		try {
			String sql = "delete from members where m_id=?";
			Connection con = mgr.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getM_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
