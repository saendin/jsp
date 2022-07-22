package com.edu.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAO {
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

	// 생성자
	// 본래는 connect할때마다 dbConfig를 불러왔다면 이번엔 한번만 실행시키면 되므로 생성자 DAO를 따로 만들어 dbConfig를 실행하게끔 구현
	public DAO() {
//		dbConfig();
	}

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

	// 2. DB 정보를 가져오는 메소드(propertise로 관리하다보니 이 메소드가 꼭 필요) 원래는 1,2만 쓰는게 국룰)
	private void dbConfig() {
		String resource = "config/db.properties";
		Properties properties = new Properties();

		try {
			String filePath // filePath가 진짜 물리적 파일 위치를 가져옴. 그리고 FileInputStream으로 접근
					= ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			properties.load(new FileInputStream(filePath)); // properties가 읽어들이면 기본틀을 가진 값을 알아서 읽어냄.
															// 경로가 정확하지 않다면 ClassLoader.getSystemClassLoader()를 통해서 경로
															// 찾고 아니라면 new FileInputStream(filePath) <-이렇게 직접 넣어줘도 됨.
		} catch (IOException e) {
			e.printStackTrace(); // 오류가 있다면 어떤 오류인지 표시해주는 것
		}
		// 이 메소드로 오라클 정보 가져올 수 있음.
		jdbcDriver = properties.getProperty("driver");
		oracleUrl = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("pwd");
	}

	// 2. DB를 해제하는 메소드
	public void disconnect() {
		try {
			// 각각의 필드들이 null인지 먼저 확인할 것 -stmt나 pstmt는 둘 중 하나만 사용되기 때문에 혹시 잘못써서 둘 다 쓰여버리면 널값 발생하게 됨 -> SQL오류 뜰 수 있음.
			// rs도 SELECT 구문 아니면 사용되지 않기 때문에 혹시나 null값이 발생할 것을 방지해야함.
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

}
