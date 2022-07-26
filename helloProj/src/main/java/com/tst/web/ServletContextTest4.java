package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.ShareObject;

@WebServlet("/context4")
public class ServletContextTest4 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		ServletContext sc = this.getServletContext();
		
		
		ShareObject obj1 = (ShareObject) sc.getAttribute("data1");
		resp.getWriter().println("count : " + obj1.getCount() + ", str : " + obj1.getStr()+ "<br>");
	
		//값이 없으면 null 반환
		ShareObject obj2 = (ShareObject) sc.getAttribute("data2");
		resp.getWriter().print("count : " + obj2.getCount() + ", str : " + obj2.getStr());
	}
	
}
