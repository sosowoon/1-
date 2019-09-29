package bci;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.DBConnectionMgr;

public class BciDAO {
	// getcolor
	public BciDTO selectYQG(int year, int quarter, String gu) throws Exception {
		DBConnectionMgr mrg = DBConnectionMgr.getInstance();
		Connection con = mrg.getConnection();
		String sql = "select * from Business_change_indicators where year=? and quarter=? and sigungucodename=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, year);
		ps.setInt(2, quarter);
		ps.setString(3, gu);
		ResultSet rs = ps.executeQuery();
		BciDTO dto = new BciDTO();
		if (rs.next()) {
			dto.setBciid(rs.getInt(1));
			dto.setYear(rs.getInt(2));
			dto.setQuarter(rs.getInt(3));
			dto.setSigungucode(rs.getInt(4));
			dto.setSigungucodename(rs.getString(5));
			dto.setCi(rs.getString(6));
			dto.setCiname(rs.getString(7));
			dto.setObma(rs.getInt(8));
			dto.setCbma(rs.getInt(9));
			dto.setSosma(rs.getInt(10));
			dto.setScsma(rs.getInt(11));
		}
		ps.close();
		con.close();
		return dto;
	}

	// gettable
	public ArrayList<BciDTO> selectYQ(int year, int quarter) throws Exception {
		DBConnectionMgr mrg = DBConnectionMgr.getInstance();
		ArrayList<BciDTO> list = new ArrayList<BciDTO>();
		Connection con = mrg.getConnection();
		String sql = "select * from Business_change_indicators where year=? and quarter=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, year);
		ps.setInt(2, quarter);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			BciDTO dto = new BciDTO();
			dto.setBciid(rs.getInt(1));
			dto.setYear(rs.getInt(2));
			dto.setQuarter(rs.getInt(3));
			dto.setSigungucode(rs.getInt(4));
			dto.setSigungucodename(rs.getString(5));
			dto.setCi(rs.getString(6));
			dto.setCiname(rs.getString(7));
			dto.setObma(rs.getInt(8));
			dto.setCbma(rs.getInt(9));
			dto.setSosma(rs.getInt(10));
			dto.setScsma(rs.getInt(11));
			list.add(dto);
		}
		ps.close();
		con.close();
		return list;
	}

	// getbarchart
	public ArrayList<BciDTO> selectS() throws Exception {
		DBConnectionMgr mrg = DBConnectionMgr.getInstance();
		ArrayList<BciDTO> list = new ArrayList<BciDTO>();
		Connection con = mrg.getConnection();
		String sql = "select year, quarter, SOSMA, SCSMA from Business_change_indicators group by year, quarter;";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			BciDTO dto = new BciDTO();
			dto.setYear(rs.getInt(1));
			dto.setQuarter(rs.getInt(2));
			dto.setSosma(rs.getInt(3));
			dto.setScsma(rs.getInt(4));
			list.add(dto);
		}
		ps.close();
		con.close();
		return list;
	}
	
}
