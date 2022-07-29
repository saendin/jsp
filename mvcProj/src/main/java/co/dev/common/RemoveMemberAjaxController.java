package co.dev.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;


public class RemoveMemberAjaxController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/json;charset=utf-8");
		String id = req.getParameter("id");
		System.out.println(id);
		
		MemberService service = MemberService.getInstance();
		boolean isDeleted = service.deleteMember(id); //값이 성공이면
		
		//{\"retCode\":\"Success\"} OR {\"retCode\":\"Fail\"}
		try {
			if(isDeleted)
				resp.getWriter().print("{\"retCode\":\"Success\"}"); //성공이란 값을 넘기겠다
			else
				resp.getWriter().print("{\"retCode\":\"Fail\"}"); //실패란 값을 넘기겠다
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
