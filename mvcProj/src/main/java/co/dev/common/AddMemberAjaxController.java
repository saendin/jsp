package co.dev.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class AddMemberAjaxController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/json;charset=utf-8");
		
		MemberService service = MemberService.getInstance();
		
//		spa에 있는 name의 파라메터 받아옴
		String id = req.getParameter("id");
		String pw = req.getParameter("pwd");
		String nm = req.getParameter("name");
		String ml = req.getParameter("mail");

		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPwd(pw);
		vo.setName(nm);
		vo.setMail(ml);
		//서비스에 담긴 기능 수행
		service.addMember(vo); // 이 서비스에다 addMember(회원가입)을 맡기겠다.
		
		//포워딩 필요없고
		//json 반환 : vo타입을 gson타입으로 만들어서 
		Gson gson = new GsonBuilder().create(); 
		try {
			resp.getWriter().print(gson.toJson(vo));//Json에게 넘기겠습니다
		} catch (IOException e) {
			e.printStackTrace();
		} 
	
	}

}
