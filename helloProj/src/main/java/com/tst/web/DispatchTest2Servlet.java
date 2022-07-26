package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatch2")
public class DispatchTest2Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");

		String title = (String) req.getAttribute("param1"); //param1이라는 값을 읽어들여서
		String auth = (String) req.getAttribute("param2");
		String publi = (String) req.getAttribute("param3");
		
		resp.getWriter().print("<h3>Dispatch page <span style='color:red;'>2입니다</span><br><br>");
		resp.getWriter().print("<small><span style='color:blue;'>책제목: </span>" + title + "</small><br>");
		resp.getWriter().print("<small><span style='color:blue;'>저 자: </span>" + auth + "</small><br>");
		resp.getWriter().print("<small><span style='color:blue;'>출판사: </span>" + publi + "</small><br>");
	}
}
