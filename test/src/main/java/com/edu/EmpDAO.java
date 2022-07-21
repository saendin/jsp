package com.edu;

import java.sql.SQLException;

public class EmpDAO extends DAO {
	// 입력기능 "GET"
	public boolean insertMember(String id, String password, String role) {
		boolean success = false;
		String sql = "insert into members values(?, ?, ?)";
		connect();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, role);

			int rs = pstmt.executeUpdate();
				if (rs > 0) {
					success = true;
				}
			
			System.out.println(rs + "건 입력 완료 !");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return success;
	}

	// 수정기능"POST"
	public boolean updateMember(String id, String password, String role) {
		boolean success = false;
		String sql = "update members set member_password = ?, member_role=?" + " where member_id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, role);
			pstmt.setString(3, id);

			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				success = true;
			}
			System.out.println(rs + "건 수정 완료 !");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return success;
	}
}
