package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addMember")
public class AddMemberServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자: user_name=user2&user_pass=1234&role=1 // (home tab으로 만들고임)
//		user_name이라고 매핑되어있는 곳의 값을 읽어올 것임
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=UTF-8");
		String name = req.getParameter("user_name");
		String pass = req.getParameter("user_pass");
		String role = req.getParameter("role");

		// DB 입력 기능 구현
		EmpDAO dao = new EmpDAO();
//		dao.insertMember(name, pass, role);

		

		// get방식으로 요청 들어오면: 수정되도록
		if (req.getMethod().toUpperCase().equals("GET")) {
			if(!dao.updateMember(name, pass, role)) {
				out.print("Fail!");
			} else {
				out.print("Complete!");
			}
		}
		//post방식으로 들어오면: 입력되도록.
		else {
			if(!dao.insertMember(name, pass, role)) {
				out.print("Fail!");
			} else {
				out.print("Complete!");
			}
		}
		}
}
