package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empListservlet.do")
//--사원 정보 리스트 출력(EmpListservlet.do)
//--사원번호/이름/이메일/입사일자/급여/직무(job_id)
public class EmpListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmployInfo2();
		out.print("<table border = '1'>");
		out.print("<thead>"
				+"<tr>"
				+"<th>사원번호</th>"
				+"<th>사원이름</th>"
				+"<th>이메일</th>"
				+"<th>고용날짜</th>"
				+"<th>연봉</th>"
				+"<th>부서번호</th>"
				+"</tr>"
				+"</thead>");
		for(Employee emp: list) {
			out.print("<tr>"
					+ "<td>"+emp.getEmployeeId()+"</td>"
					+ "<td>" + emp.getFirstName() + "</td>"
					+ "<td><small>" + emp.getEmail() + "</small></td>"
					+ "<td><small>" + emp.getHireDate() + "</small></td>"
					+ "<td><small><span style='color:blue; font-weight:bold;'>" + emp.getSalary() + "</span></small></td>"
					+ "<td>" + emp.getJobId() + "</td>"
					+ "</tr>"
					);
		}
		out.print("</tbody>");
		out.print("</table>");
	}
}
