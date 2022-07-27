package co.dev.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		MemberService service = MemberService.getInstance();

		String id = req.getParameter("id");
		String pw = req.getParameter("pwd");
		String nm = req.getParameter("name");
		String ml = req.getParameter("mail");

		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPwd(pw);
		vo.setName(nm);
		vo.setMail(ml);

		service.addMember(vo); // 이 서비스에다 addMember(회원가입)을 맡기겠다.

		// 요청처리 결과 뷰페이지 전송
		req.setAttribute("member", vo); // member라는 변수에 vo값을 담아서 밑의 뷰페이지로 전송하겠다.

		// 밑에것 대신 이거 씀
		Utils.forward(req, resp, "memberResult/memberInsertOutput.jsp");

//		RequestDispatcher rd = req.getRequestDispatcher("memberResult/memberInsertOutput.jsp");// <=페이지로 위의 멤버에 담아준 어트리뷰트 속성 vo를 전송
//		try {
//			rd.forward(req, resp);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	}
}
