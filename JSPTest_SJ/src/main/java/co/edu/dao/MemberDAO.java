package co.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.edu.vo.MemberVO;



public class MemberDAO extends DAO {

	public void insertMember(MemberVO vo) {
		connect();
		String sql = "insert into test_member(id,passwd,name,address) values(?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());

			int result = pstmt.executeUpdate();
			System.out.println(result + "건 입력 완료!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
