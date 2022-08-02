package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;

public class BoardListControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardService service = BoardService.getInstance();
		service.boardList();
		
		req.setAttribute("boardList", service.boardList()); //boardList.jsp에서 사용할 변수명 boardList에 속성값으로 글목록을 담아줘야하니까 글 목록인(service.boardList())을 담아줌 
		HttpUtil.forward(req, resp, "board/boardList.tiles");
	}

}
