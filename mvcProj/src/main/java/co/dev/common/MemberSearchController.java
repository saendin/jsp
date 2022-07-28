package co.dev.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 단건 조회기능
		String id = req.getParameter("id");
		String job = req.getParameter("job"); // view에서 지정한 name 파라메터값(search/update) 가져옴

		if (id.isEmpty()) { // 아이디가 있으면 조회하고 없으면 조회 못하도록
			req.setAttribute("error", "<span style='color:red;'>id를 입력하세요 !</span>");//req.setAttribute(키(매개변수):벨류(송출값))
			if (job.equals("search")) {
				Utils.forward(req, resp, "memberView/memberSearch.jsp");
			} else if (job.equals("update")) {
				Utils.forward(req, resp, "memberView/memberUpdate.jsp");
			} else if (job.equals("delete")) {
				Utils.forward(req, resp, "memberView/memberDelete.jsp");
			}
			return;
		}

		MemberService service = MemberService.getInstance();
		MemberVO vo = service.getMember(id); 
		
		if(vo==null) { //vo값 있으면 속성값 넣어주고 아니면 못넣도록
			req.setAttribute("result", "검색된 정보가 없습니다.");
		} 
		req.setAttribute("member", vo);
		
		if (job.equals("search")) {
			Utils.forward(req, resp, "memberResult/memberSearchOutput.jsp");
		} else if (job.equals("update")) {
			Utils.forward(req, resp, "memberView/memberUpdate.jsp");
		} else if (job.equals("delete")) {
			Utils.forward(req, resp, "memberView/memberDelete.jsp");
		}
	}
//		try {
//			req.getRequestDispatcher("memberResult/memberSearchOutput.jsp").forward(req,  resp);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

}
