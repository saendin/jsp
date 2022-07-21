package com.edu;

import java.sql.SQLException;

public class DeptDAO extends DAO{

	public void getDeptInfo(int deptId) {
		String sql = "select*from departments where department_id = ?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptId);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("-------------------");
				System.out.println("deptId: " + rs.getInt("department_id"));
				System.out.println("deptName: " + rs.getString("department_name"));
				System.out.println("-------------------");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
