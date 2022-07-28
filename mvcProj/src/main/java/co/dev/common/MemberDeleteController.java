package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;




public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pwd");
		String nm = req.getParameter("name");
		String em = req.getParameter("mail");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPwd(pw);
		vo.setName(nm);
		vo.setMail(em);
		
		MemberService service = MemberService.getInstance();
		service.deleteMember(vo);
		
		req.setAttribute("member", vo);
		Utils.forward(req,  resp, "memberResult/memberDeleteOutput.jsp");
		
	}

}
