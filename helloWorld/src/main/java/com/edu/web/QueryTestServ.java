package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/queryTest")
public class QueryTestServ extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get방식에서 받아올 값들을 파라메터로 받아줌
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id"); //parameter : id 값을 반환 ->getParameter는 id라는 값을 읽어오겠습니다
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobby = req.getParameterValues("hobby"); //hobby는 checkBox라서 여러개의 값을 받아올 수 있으므로 배열타입으로 선언하고 getParameterValues로 값들을 받아줌 
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String introduction = req.getParameter("introduction");
	
		out.print("<h1> 입력받은 값 </h1>");
		out.print("<p><span style='color:blue; font-style:bold;'>"+"ID: "+"</span>" + id + "</p>");
		out.print("<p><span style='color:blue; font-style:bold;'>"+"PWD: "+"</span>" + pwd + "</p>");
		out.print("<p><span style='color:blue; font-style:bold;'>"+"NAME: "+"</span>" + name + "<ul>");
		out.print("<p><span style='color:blue; font-style:bold;'>"+"HOBBY: "+"</span><ul>");
//		for(int i=0; i<hobby.length; i++) {
//			out.print("<li>" + hobby[i] + "</li>");
//		} out.print("</ul>");
		for(String hobbyList : hobby) {
			out.print("<li>" + hobbyList + "</li>");
		} out.print("</ul>");
		out.print("<p><span style='color:blue; font-style:bold;'>"+"GEN: "+"</span>" + gender + "</p>");
		out.print("<p><span style='color:blue; font-style:bold;'>"+"RELIGION: "+"</span>" + religion + "</p>");
		out.print("<p><span style='color:blue; font-style:bold;'>"+"INTRODUCTION: "+"</span>" + introduction + "</p>");
		out.print("<span style='color:blue; font-style:bold;'>"+"질의 문자열: "+"</span>" + req.getQueryString());
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get방식에서 받아올 값들을 파라메터로 받아줌
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
//		String id = req.getParameter("id"); //parameter : id 값을 반환 ->getParameter는 id라는 값을 읽어오겠습니다
//		String pwd = req.getParameter("pwd");
//		String name = req.getParameter("name");
//		String[] hobby = req.getParameterValues("hobby"); //hobby는 checkBox라서 여러개의 값을 받아올 수 있으므로 배열타입으로 선언하고 getParameterValues로 값들을 받아줌 
//		String gender = req.getParameter("gender");
//		String religion = req.getParameter("religion");
//		String introduction = req.getParameter("introduction");
//	
//		out.print("<h1> 입력받은 값 </h1>");
//		out.print("<p><span style='color:blue; font-style:bold;'>"+"ID: "+"</span>" + id + "</p>");
//		out.print("<p><span style='color:blue; font-style:bold;'>"+"PWD: "+"</span>" + pwd + "</p>");
//		out.print("<p><span style='color:blue; font-style:bold;'>"+"NAME: "+"</span>" + name + "</p>");
//		out.print("<p><span style='color:blue; font-style:bold;'>"+"HOBBY: "+"</span><ul>");
////		for(int i=0; i<hobby.length; i++) {
////			out.print("<li>" + hobby[i] + "</li>");
////		} out.print("</ul>");
//		for(String hobbyList : hobby) {
//			out.print("<li>" + hobbyList + "</li>");
//		} out.print("</ul>");
//		out.print("<p><span style='color:blue; font-style:bold;'>"+"GEN: "+"</span>" + gender + "</p>");
//		out.print("<p><span style='color:blue; font-style:bold;'>"+"RELIGION: "+"</span>" + religion + "</p>");
//		out.print("<p><span style='color:blue; font-style:bold;'>"+"INTRODUCTION: "+"</span>" + introduction + "</p>");
		
		
		ServletInputStream sis = req.getInputStream(); //post : 
		int len = req.getContentLength(); // 데이터의 크기만큼 한번에 읽어들이도록 하곘습니다.
		byte[] buf = new byte[len]; //크기는 한번에 배열안에 담아서 출력되도록
		sis.readLine(buf, 0, len); //버퍼의 처음(0)부터 끝(len)까지 읽어들이겠습니다
		String queryString = new String(buf);//buf에 있는 배열타입을 스트링에 한번 더 담아줌
		System.out.println(queryString);
		out.print("<p id='queryString'> <span style='color:blue; font-style:bold;'>"+"질의 문자열: </span>" + queryString + "</p>");
		sis.close();
		out.close();
	}
}
