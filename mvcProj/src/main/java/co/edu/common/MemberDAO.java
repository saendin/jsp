package co.edu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//DAO 클래스 에서는 세분화해서 기능을 만들어 놓음


//jdbc연결
public class MemberDAO {
	// Oracle DB 정보
		private String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		private String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		private String connectedId = "hr";
		private String connectedPwd = "hr";

		// 공통적으로 사용되는 필드
		protected Connection conn;
		protected Statement stmt;
		protected PreparedStatement pstmt;
		protected ResultSet rs;

		// 1. DB에 접속하는 메소드
		public void connect() {
			try {
				Class.forName(jdbcDriver);
				conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
			} catch (ClassNotFoundException e) {
				System.out.println("jdbc driver의 로딩에 실패하였습니다.");
			} catch (SQLException e) {
				System.out.println("DB 접속에 실패했습니다.");
			}
		}

		// 2. DB를 해제하는 메소드
		public void disconnect() {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//-----------------------------------------------------------------------------
	//입력처리.
	public void insertMember(MemberVO vo) {
		connect();
		String sql = "insert into member(id,pwd,name,mail) values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getPwd());
			pstmt.setString(3,vo.getName());
			pstmt.setString(4,vo.getMail());
			
			int r = pstmt.executeUpdate();
			System.out.println(r+"건 입력 완료!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
//	//수정
//	public void updateMember(MemberVO vo) {
//		connect();
//		String sql ="";
//		
//		try {
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//	}
//	//삭제
//	public void deleteMember(MemberVO vo) {
//		connect();
//		String sql ="delete from member where member_id=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//		} catch (Exception e) {
//		} finally {
//			disconnect();
//		}
//	}
}
