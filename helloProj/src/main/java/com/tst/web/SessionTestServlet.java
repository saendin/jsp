package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = null;
		String param = req.getParameter("param");
		String msg = null;
		String msg2 = null;

		// 세션 생성
				//세션은 웹 브라우저를 닫으면 사라짐
				//http://localhost:8088/helloProj/sessionTest?param="세션만들기"
				// ~~~~/프로젝트 이름/ + WebServlet이름 + ? + 파라메터값 받아올 변수 이름 + = + 파라메터에 넣어줄 세션을 만들 변수 이름
		if (param.equals("세션만들기")) {// 만약 param값이 create란 이름으로 들어오면
			session = req.getSession(true); //이게 진짜 세션을 만들어주는 메소드
											// 생성된 세션값이 있으면 그 세션값 반환, 없으면 새로 생성된 세션 값 반환
			if (session.isNew()) { // 새로 만들어진(isNew())
				msg = "새로운 세션 객체 생성";
			} else { // 아니라면 이전의 값 반환
				msg = "기존 세션 객체 반환";
			}
			
		//섹션 객체 삭제
		//http://localhost:8088/helloProj/sessionTest?param="세션삭제"
		} else if (param.equals("세션삭제")){
			session = req.getSession(false); //생성된 세션 있으면 세션반환, 없으면 null 
			if(session != null) { //session 값이 있으면
				session.invalidate();//세션 삭제하겠다
				msg = "세션 객체 삭제 !";
			} else {
				msg = "삭제할 세션 객체 없음";
			}
			
		//세션 객체의 속성 추가
		} else if (param.equals("속성추가")){
			session = req.getSession(true);
			session.setAttribute("msg", "메세지 추가!");
			msg = "세션 객체에 속성 지정하겠움";
		
		//세션 객체의 속성 가져옴
		//동일한 웹 브라우저를 여러개 열어서 사용 = 동일한 사용자로 인식 => 세션 공유 O 	ex)크롬내에서 탭 여러개
		//다른 종류의 웹 브라우저로 연결하면 = 다른 사용자로 인식 => 세션 공유 X 			ex)크롬, 엣지
		} else if (param.equals("속성가져오기")) {
			session = req.getSession(false); //세션객체 없으면 null 리턴
			if(session != null) {
				String str = (String) session.getAttribute("msg");
				msg = str;
			} else {
				msg = "데이터를 추출할 세션이 없습니다!";
			}
		
		//세션 객체의 속성 제거
		} else if (param.equals("속성제거")) {
			session = req.getSession(false);//값을 지정한 상태에서만 가져와서 삭제해야하니까 false로 지정
			String str = (String) session.getAttribute("msg");
			
			if(session != null) {
				session.removeAttribute("msg"); //msg 속성을 지우겠다
				msg = "세션 객체의 속성을 삭제함!<br>";
				msg2 = "담긴 속성 값 : " + str;
			} else {
				msg = "속성을 제거할 세션 객체가 없습니다!";
			}
		}
		
		resp.getWriter().print("처리결과~ 보여~ 주세욧! "+ "<br><br>" + "<small>"+msg+"</small>" + "<small>"+msg2+"</small>");

		// 세션 값 변경

		// 세선 삭제
	}

}
