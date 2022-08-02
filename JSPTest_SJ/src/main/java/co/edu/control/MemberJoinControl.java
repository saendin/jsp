package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.service.MemberService;
import co.edu.vo.MemberVO;

public class MemberJoinControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("memberId");
		String passwd  = req.getParameter("memberPassword");
		String name = req.getParameter("memberName");
		String address = req.getParameter("memberAddress");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(passwd);
		vo.setName(name);
		vo.setAddress(address);

		MemberService service = MemberService.getInstance();
		service.addMember(vo);
		
		
		//member라는 변수에 vo속성 부여
		req.setAttribute("member", vo);
		
		
		// 회원가입화면: 회원가입 후 첫페이지로 이동.
		HttpUtil.forward(req, resp, "home/welcome.tiles");
	}

	
}
