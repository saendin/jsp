package com.tst.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logProc")
public class LogInOutServlet extends HttpServlet {
	// 로그인작업
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		// html에서 만들었던 id 값을 파라메터로 받아올고임
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");

		if (id.isEmpty() || pwd.isEmpty()) { // 아이디 값이나 비번값이 비어있으면
			out.print("ID와 비밀번호를 입력해주세요 !");// 출력값 표시
			return;
		}
		// 세션 객체 불러오기
		HttpSession session = req.getSession();
		if (session.isNew() || session.getAttribute("id") == null) { // 세션이 새로 만들어졌거나 있을경우 Or id 속성을 읽어왔는데 null인 경우
			session.setAttribute("id", id); // 세션에다가 넘겨받은 id라는 속성(값)을 지정하겠다
			out.print("로그인이 완료되었습니다 ^ㅇ^"); // 출력값 표시
		} else { // 세션이 없을 때
			out.print("이미 로그인한 상태입니다 !");
		}

	}

	

	// 로그아웃 작업
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");

		if (id.isEmpty() || pwd.isEmpty()) { // 아이디 값이나 비번값이 비어있으면
			out.print("ID와 비밀번호를 입력해주세요 !");// 출력값 표시
			return;
		}
		// 세션 객체 불러오기
		HttpSession session = req.getSession();
		if (session.isNew() || session.getAttribute("id") == null) { // 세션이 새로 만들어졌거나 있을경우 Or id 속성을 읽어왔는데 null인 경우
			session.setAttribute("id", id); // 세션에다가 넘겨받은 id라는 속성(값)을 지정하겠다
			out.print("로그인이 완료되었습니다 ^ㅇ^"); // 출력값 표시
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/dispatch1");
			rd.forward(req, resp);
		} else { // 세션이 없을 때
			out.print("이미 로그인한 상태입니다 !");
		}
		
		HttpSession session2 = req.getSession(false); //세션 새로 만들게 아니라서 false넣어줌 (있으면 그 세션 넣어주고 아니면  null)
		if(session2!=null && session2.getAttribute("id") != null) {
			session2.invalidate(); //세션 무효화
			out.print("로그아웃이 완료되었습니다");
		} else {
			out.print("로그인 상태가 아닙니다!");
		}
		
	}
}
