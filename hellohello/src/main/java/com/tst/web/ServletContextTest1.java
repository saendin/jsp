package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//		  <context-param>
//아래의 이름을 등록해놓고 벨류값을 불러오게끔
//		  	<param-name>contextConfigLocation</param-name>
//		  	<param-value>/WEB-INF/persistent.xml</param-value> 
//		  </context-param> //-->이 값을 공유하겠습니다.
@WebServlet("/context1")
public class ServletContextTest1 extends HttpServlet {
	ServletContext sc; //라는 객체에 접근
	@Override
	public void init(ServletConfig config) throws ServletException {
		//ServletConfig가 가지고 있는 getServletContext()로 접근해서
		sc = config.getServletContext(); //ServletConfig 객체
		System.out.println(sc);

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//"contextConfigLocation"을 공유해서 쓴다.
		String contextConfigLocation = sc.getInitParameter("contextConfigLocation");
		resp.getWriter().println("Location: " + contextConfigLocation); //->Location: /WEB-INF/persistent.xml 출력
		//->org.apache.catalina.core.ApplicationContextFacade@3dd5947f 인스턴스가 만들어져있는 객체의 실질적 주소값
	
		String contextConfig = sc.getInitParameter("contextConfig");
		resp.getWriter().println("Config : " + contextConfig);//->Config : /WEB-INF/context.xml
		
		String encording = sc.getInitParameter("encording");
		resp.getWriter().print("Encording : " + encording);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String encoding = sc.getInitParameter("encoding");
		req.setCharacterEncoding(encoding);
		resp.setCharacterEncoding(encoding);
		resp.setContentType("text/plain;charset=utf-8");
		
		String name = req.getParameter("name");
		resp.getWriter().print("이름 : " + name);
		
	}
}
