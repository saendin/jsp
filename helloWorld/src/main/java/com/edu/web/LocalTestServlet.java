package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/local")
public class LocalTestServlet extends HttpServlet {
	String str;
	//대충 서블릿의 특징 알아보기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		str = req.getParameter("msg");	//msg라는 파라미터를 만들어서 str에 담아줌
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h2>처리결과(전역변수)</h2>");
		
		int num = 0;
		while(num++ < 10) {
			out.print(str + " : " + num + "<br>");
			out.flush();
			try {
				Thread.sleep(1000); //잠시 멈추는 기능
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		out.print("<h2>DONE : " + str + "</h2>");
	}
}
