package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.ShareObject;

@WebServlet("/context3")
public class ServletContextTest3 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//애플리케이션당 하나씩 만들어지는 객체
		ServletContext sc = this.getServletContext(); //ServletContext 호출
		
		//꼭 Shareobject타입이 아니더라도 String타입이어도 되고 어떤 타입이라도 상관 없다.
		ShareObject obj1 = new ShareObject();
		obj1.setCount(100);
		obj1.setStr("객체 공유 테스트1");
		
		ShareObject obj2 = new ShareObject();
		obj2.setCount(200);
		obj2.setStr("객체 공유 테스트2");
		
		//obj1(ShareObject)의 인스턴스를 sc(ServletContext)에 지정하곘습니다.
		
		sc.setAttribute("data1", obj1); //data1에 obj1의 주소값을 매핑하겠다.
		sc.setAttribute("data2", obj2); //data2에 obj2의 주소값을 매핑하겠다.
		
		
		resp.getWriter().print("ServletContext에다 object를 add했습니다.");
	}
}
