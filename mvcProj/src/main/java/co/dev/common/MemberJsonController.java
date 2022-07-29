package co.dev.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;


public class MemberJsonController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// [{"name":"hong", "age":15}, {"name":"hwang", "age":15}]
		resp.setContentType("text/json;charset=utf-8");

		MemberService service = MemberService.getInstance();
		List<MemberVO> members = service.memberList();
		String json = "[{\"name\":\"hong\", \"age\":15}, {\"name\":\"hwang\", \"age\":15}]";
		
		JsonArray jAry = new JsonArray();
		for(MemberVO vo : members) {
		JsonObject jObj = new JsonObject();
		jObj.addProperty("id", vo.getId());
		jObj.addProperty("name", vo.getName());
		jObj.addProperty("pwd", vo.getPwd());
		jObj.addProperty("mail", vo.getMail());
		
		// jAry 추가
		jAry.add(jObj);
		}
		try {
			resp.getWriter().print(jAry);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
