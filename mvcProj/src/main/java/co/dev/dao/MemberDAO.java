package co.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.dev.vo.MemberVO;

public class MemberDAO {
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

	public void insertMember(MemberVO vo) {
		connect();
		String sql = "insert into member(id,pwd,name,mail) values(?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getMail());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력 완료!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public List<MemberVO> getList() {
		connect();
		String sql = "select * from member order by 1";
		List<MemberVO> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); //값을 담을 때 rs
			while(rs.next()) { 
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setMail(rs.getString("mail"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	public MemberVO searchMember(String id) { //매개값으로는 id 받을 것
		connect();
		String sql = "select * from member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setName(rs.getString("name"));
				vo.setMail(rs.getString("mail"));
				vo.setPwd(rs.getString("pwd"));
				
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	public void updateMember(MemberVO vo) {
		connect();
		String sql = "update member set name = ?, pwd = ?, mail = ? where id =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getMail());
			pstmt.setString(4, vo.getId());
			
			int r = pstmt.executeUpdate();
			
			System.out.println(r + "건 수정 완료!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public boolean deleteMember(String id) {
		connect();
		String sql = "delete from member where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int r = pstmt.executeUpdate();
			
			System.out.println(r + "건 삭제 완료 !");
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
		
	}
}
