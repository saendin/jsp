package com.tst.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context2")
public class ServletContextTest2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		ServletContext sc = this.getServletContext(); // HttpServlet이라고 하는 녀석의 문서부터 확인
		// 서블릿버전 출력해보기
		out.print("<p>서블릿 버전: " + sc.getMajorVersion() + "</p>"); // ->서블릿 버전: 4
		out.print("<p>앱 경로: " + sc.getContextPath() + "</p>"); //->앱 경로: /helloProj
		out.print("<p>앱 이름: " + sc.getServletContextName() + "</p>"); //->앱 이름: helloProj
		out.print("<p>페이지 경로: " + sc.getRealPath("form.html") + "</p>");//->페이지 경로: D:\dev\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\helloProj\form.html
		
		sc.log("로그기록 중입니다");
		out.close();
	}
}
