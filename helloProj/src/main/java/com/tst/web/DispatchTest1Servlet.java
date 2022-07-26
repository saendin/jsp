package com.tst.web;

import java.io.IOException;
import java.security.KeyStore.Entry.Attribute;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatch1")
public class DispatchTest1Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print("<h3>Dispatch page 1입니다");
		
		String title = req.getParameter("title");
		String authr = req.getParameter("author");
		String publi = req.getParameter("publish");
		
		req.setAttribute("param1", title);
		req.setAttribute("param2", authr);
		req.setAttribute("param3", publi);
		
		//dispatch가져오는 방법
		//getServletContext() : HttpServlet이 가지는 메소드 가져와서 거기다 getRequestDispatcher("/dispatch2")로 디스패쳐2 페이지 오청
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/dispatch2");
		//요청방식 : forwading  바로 재요청 사이트로 넘김
		rd.forward(req, resp); //'dispatch2 페이지를 요청하겠습니다~' 하고 요청을 재지정
			//요청방식 : include	둘 다 보여줌
//		rd.include(req, resp); //'dispatch2 페이지를 요청하겠습니다~' 하고 요청을 재지정
	}
}
