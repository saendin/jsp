package com.tst.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.EmpDAO;
import com.tst.common.Employee;

@WebServlet("/empSearch")
public class EmpSearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fName = req.getParameter("first_name");
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpInfo(fName);
		req.setAttribute("data", list); //data란 이름으로 list의 객체값들을 넘겨볼고
		
		//empResult로 넘김
		RequestDispatcher rd = req.getRequestDispatcher("empResult.jsp");
		rd.forward(req,  resp);
		
		
	}
}
