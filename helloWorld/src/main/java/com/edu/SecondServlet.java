package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/second.do") //WebServlet()안의 주소 열어주겠다고 좀 더 간단히 선언하는것
public class SecondServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("서버 실행시 첫번째 호출에서만 사용됨");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("이고는 이닛다음에 적어줘야될고~~");
		resp.setContentType("text/html;charset=UTF-8"); //응답정보에 지금 출력하는 웹 페이지의 타입을 지정해주는 소스
//		resp.getWriter(); //출력스트림이라 밑처럼 정의
		PrintWriter out = resp.getWriter();
		out.print("<h1>안녕하세요 서블릿입니다~!~!!!!!</h1>");
	}
	
	
}
