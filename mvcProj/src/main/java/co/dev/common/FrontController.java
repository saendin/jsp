package co.dev.common;

//컨트롤러 페이지
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;
//
public class FrontController extends HttpServlet {
	String enc;
	Map<String, Controller> mappings; //1.mappings라는 객체에다가 요청 url과 Controller를 담겠다
	
	@Override
	public void init(ServletConfig config) throws ServletException {
//		config.getInitParameter(getServletName())을 밑의 변수에 담아줌
		enc = config.getInitParameter("charset"); // enc = encoding
		
		mappings = new HashMap<>();//2.push로 담아주기
		
		mappings.put("/memberInsert.do", new MemberInsertController());//Controller가 구현하는 객체를 실행할것 //MemberInsertController()<=구현객체
		mappings.put("/memberList.do", new MemberListController());//path값 = 키값
		mappings.put("/memberSearch.do", new MemberSearchController());
		mappings.put("/memberUpdate.do", new MemberUpdateController());
		mappings.put("/memberDelete.do", new MemberDeleteController());
		mappings.put("/memberJson.do", new MemberJsonController());
		mappings.put("/addMemberAjax.do", new AddMemberAjaxController()); //멤버 추가하는 ajax입력하기 위한 호출)
		mappings.put("/removeMemberAjax.do", new RemoveMemberAjaxController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(enc);

		String uri = req.getRequestURI(); // context
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length()); // uri - contextPath길이만큼 뺀 값을 substring함
		
		// 확인용
//		System.out.println(uri); // /mvcProj/*.do
//		System.out.println(contextPath); // /mvcProj
//		System.out.println(path); // 요청하는 페이지 정보 가져와보기 /*.do => path에 memberInsert 넣으면 /memberInsert.do가 됨
		
		//3.해당되는 controller타입을 매칭시켜줌 = path
		Controller cntr = mappings.get(path);
		cntr.execute(req,  resp);
		
		MemberService service = MemberService.getInstance();
		// 입력요청이 들어오면 -> 뷰페이지로 이동

		//Map방법이면 아래처럼 안해도 가능함.
//		if (path.equals("/memberInsert.do")) {
//		} else if (path.equals("/memberList.do")) {
//		}
	}
}
