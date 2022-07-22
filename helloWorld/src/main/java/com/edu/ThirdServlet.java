package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.EmpDAO;
import com.edu.common.Employee;

@WebServlet("/thirdddd.do")
public class ThirdServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
//		out.println("JDBC로 조회,,");
		
		//요청정보 : 질의문자열 (키=값) ex) thirdddd.do?key=Steven;
		//key라는 파라메터를 값으로 가져오겠습니다.
		String value = req.getParameter("key");
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpInfo(value);
		out.print("<table border='1'>");
		out.print("<thead>"
				+ "<tr>"
				+ "<th>사원번호</th>"
				+ "<th>성</th>"
				+ "<th>이름</th>"
				+ "<th>이메일</th>"
				+ "<th>급여</th>"
				+ "</tr>"
				+ "</thead>");
		for(Employee emp : list) {
			out.print("<tr>"
					+ "<td>"+emp.getEmployeeId()+"</td>"
					+ "<td>" + emp.getLastName() + "</td>"
					+ "<td>" + emp.getFirstName() + "</td>"
					+ "<td><small>" + emp.getEmail() + "</small></td>"
					+ "<td>" + emp.getSalary() + "</td></tr>");
		}
		out.print("</tbody>");
		out.print("</table>");
//		dao.getEmpInfo("Steven");
//		DeptDAO deptDao = new DeptDAO();
//		deptDao.getDeptInfo(50);
	}
}
