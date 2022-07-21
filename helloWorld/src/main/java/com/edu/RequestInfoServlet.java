package com.edu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reqInfo")
public class RequestInfoServlet extends HttpServlet{
	// init() -> request, response -> service()
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		//네트워크 정보
		PrintWriter out = resp.getWriter();
		out.print("<h3>네트워크정보</h3>");
		out.print("<p>Request Schema: " + req.getScheme() + "</p>"); //=>Request Schema: http
		out.print("<p>Server Name: " + req.getServerName() + "</p>"); //=>Server Name: localhost
		out.print("<p>Server Address: " + req.getLocalAddr() + "</p>"); //=>Server Address: 0:0:0:0:0:0:0:1
		out.print("<p>Server Port: " + req.getServerPort() + "</p>"); //=>Server Port: 8088
		out.print("<p>Client Address: " + req.getRemoteAddr() + "</p>");//=>Client Address: 0:0:0:0:0:0:0:1
		out.print("<p>Client Host: " + req.getRemoteHost() + "</p>");//=>Client Host: 0:0:0:0:0:0:0:1
		out.print("<p>Client Port: " + req.getRemotePort() + "</p>");//=>Client Port: 63698
		
		out.print("================================");
		String str = "<h3>URL정보</h3>";
		//URI : 어플리케이션부터 요청하는 페이지까지 보는 것
		str += "<p>Request URI: "+ req.getRequestURI() + "</p>";//=>Request URI: /helloWorld/reqInfo
		//URL : 요청한 페이지 전체를 보는 것
		str += "<p>Request URL: "+ req.getRequestURL() + "</p>";//=>Request URL: http://localhost:8088/helloWorld/reqInfo
		//서버의 path정보 보기 위한것
		str += "<p>Context Path: "+ req.getContextPath() + "</p>";//=>Context Path: /helloWorld
		//프로토콜은 컴퓨터 내부에서, 또는 컴퓨터 사이에서 데이터의 교환 방식을 정의
		str += "<p>Request Protocol: "+ req.getProtocol() + "</p>";//=>Request Protocol: HTTP/1.1
		//서버의 정보
		str += "<p>Request ServletPath: "+ req.getServletPath() + "</p>";//=>Request ServletPath: /reqInfo
		
		out.print(str);
		
		out.print("================================");	
		String str2 = "<h3>요청 헤더정보</h3>";
		Enumeration<String> en = req.getHeaderNames();
		while(en.hasMoreElements()) {//가지고 있는 요소들이 더 있냐?
			String elem = en.nextElement(); //리턴값이 참일경우 계속 반복하겟습니다.
			//헤더의 정보
			String headVal = req.getHeader(elem);
			
			str2 += "<p>" + elem +  ", "+ headVal + "</p>";
			
		}
		out.print(str2);
//		요청 헤더정보
//		host, localhost:8088
//
//		connection, keep-alive
//
//		cache-control, max-age=0
//
//		sec-ch-ua, ".Not/A)Brand";v="99", "Google Chrome";v="103", "Chromium";v="103"
//
//		sec-ch-ua-mobile, ?0
//
//		sec-ch-ua-platform, "Windows"
//
//		upgrade-insecure-requests, 1
//
//		user-agent, Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36
//
//		accept, text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
//
//		sec-fetch-site, none
//
//		sec-fetch-mode, navigate
//
//		sec-fetch-user, ?1
//
//		sec-fetch-dest, document
//
//		accept-encoding, gzip, deflate, br
//
//		accept-language, ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
		
		out.close();
	}
}
