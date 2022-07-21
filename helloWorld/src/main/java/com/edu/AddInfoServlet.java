package com.edu;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddInfoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<h1>추가적인 정보</h1>");
		//요청 메소드에 대한 방식
		out.print("<p>Request Method: " + req.getMethod() + "</p>");
		out.print("<p>Path Info: " + req.getPathInfo() + "</p>");
		out.print("<p>Path Translated: " + req.getPathTranslated() + "</p>");
		out.print("<p>Query String: " + req.getQueryString() + "</p>");
		out.print("<p>Content Length: " + req.getContentLength() + "</p>");
		out.print("<p>Content Type: " + req.getContentType() + "</p>");
		out.close();
	}
}
