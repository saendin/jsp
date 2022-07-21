package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addMember")
public class AddMemberServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=UTF-8");
		String id = req.getParameter("user_id");
		String password = req.getParameter("user_password"); 
		String role = req.getParameter("role");
		
		//DB입력 기능 구현
		EmpDAO dao = new EmpDAO();
		
		if(req.getMethod().toUpperCase().equals("GET")) {
//			dao.updateMember(id,password,role);
			if(!dao.updateMember(id, password, role)) {
				out.print("Fail!");
			} else {
				out.print("Complete!");
			}
		}
		else {
			if(!dao.insertMember(id,password,role)) {
				out.print("Fail!");
			} else {
				out.print("Complete!");
			}
		}
	}
}
