package co.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 서버에 있는 정보를 connect를 통해서 가져오도록
	public void connect() {
		try {
			InitialContext ic = new InitialContext();
			// 리소스에 저장해놨던 이름을 들고옴 (service폴더에 있던 server.xml / web.xml 수정했던고)
			// 아래의 홈디렉토리에서 저장해논 리소스 가지고옴
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle"); // java:comp/env/ <=가상 디렉토리 이름
			// lookup가지고 오겠습니다. ()를 DataSource의 변수에 담아
			conn = ds.getConnection();

		} catch (Exception e) { // 모든 예외를 처리하도록 Exception으로 바꿈
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
