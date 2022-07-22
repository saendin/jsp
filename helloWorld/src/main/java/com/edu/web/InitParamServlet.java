package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet()
public class InitParamServlet extends HttpServlet {
	//생성(생성자를 통해서) -> ServletConfig -> init(sc)-> service(rq.rsp);
	//호출이 되는지안되는지 서버를 실행했을 때 확인해보기 위해서
	public InitParamServlet() {
		System.out.println("InitParamServlet() 호출");
	}
	
	
	String id;
	String pwd;
	@Override
	public void init(ServletConfig config) throws ServletException {
		id = config.getInitParameter("id");
		pwd = config.getInitParameter("password");
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<h3>서블릿 초기변수 설정</h3>");
		out.print("<p> ID : " + id + "</p>");
		out.print("<p> PWD : " + pwd + "</p>");
		out.close();
	}
}


