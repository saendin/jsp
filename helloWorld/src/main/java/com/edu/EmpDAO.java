package com.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO {

	public List<Employee> getEmpInfo(String name) {
		String sql = "select*from employees where first_name=?";
		connect(); //conn객체
		List<Employee> list = new ArrayList<>();
		try {
			//sql문 연결
			pstmt = conn.prepareStatement(sql);
			//쿼리결과를 가져와서 담아주는
			pstmt.setString(1, name);
			
			//담아준것을 실행하는
			rs = pstmt.executeQuery();
			//next()요소를 하나하나씩 끄집어냄
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
//				emp.setSalary(rs.getInt("salary"));
				
				list.add(emp);
//				System.out.println("-------------------");
//				System.out.println("id: " + rs.getInt("employee_id"));
//				System.out.println("fN: " + rs.getString("first_name"));
//				System.out.println("-------------------");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
//	--사원 정보 리스트 출력(EmpListservlet.do)
//	--사원번호/이름/이메일/입사일자/급여/직무(job_id)
	public List<Employee> getEmployInfo2() {
		String sql = "select employee_id, first_name, CONCAT(email,'@yedam.com'), hire_date, CONCAT('$',salary), job_id from employees";
		connect();
		List<Employee> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setEmail(rs.getString("CONCAT(email,'@yedam.com')"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setSalary(rs.getString("CONCAT('$',salary)"));
				emp.setJobId(rs.getString("job_id"));
				
				list.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//입력기능
	//user_name, user_pass, role
	public boolean insertMember(String name, String pass, String role) {
		boolean success = false; 
		String sql = "insert into members values(?,?,?)";
		 connect();
		 
		 try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,pass);
			pstmt.setString(3,role);
			//실제 처리된 타입 반환 // insert, update, delete
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				success = true;
			}
			System.out.println(rs + "건 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		 return success;
	}
	
	//수정기능
	public boolean updateMember(String name, String pass, String role) {
		boolean success = false;
		String sql = "update members set member_password = ?,member_role = ?"
				  + " where member_id = ?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,pass);
			pstmt.setString(2,role);
			pstmt.setString(3,name);
			
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				success = true;
			}
			System.out.println(rs + "건 수정됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return success;
	}
}
