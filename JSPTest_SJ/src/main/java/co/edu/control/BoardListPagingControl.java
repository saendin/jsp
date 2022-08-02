package co.edu.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Controller;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.vo.BoardVO;
import co.edu.vo.Criteria;
import co.edu.vo.Page;

public class BoardListPagingControl implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 페이징 처리 된 리스트 출력
		String pageNum = req.getParameter("pageNum");
		String postNum = req.getParameter("postNum");
		
		/*
		값을 바꾸고 싶으면
		ex)2페이지의 10건을 보겠다
		criteria.setPageNum(2);
		criteria.setPostNum(10);
		*/
		Criteria criteria = new Criteria(); //초기값:1페이지, 10건씩 보여주겠습니다
		criteria.setPageNum(Integer.parseInt(pageNum));
		criteria.setPostNum(Integer.parseInt(postNum));
		
		/*
		 * 서비스 호출(<--DAO 구현)
		*/
		 
		//pageList서비스 호출
		BoardService boardService = BoardService.getInstance();
		List<BoardVO> pageList = boardService.getListPaging(criteria);
		req.setAttribute("boardList", pageList);
		
		
		//Paging계산해서 보여주는 서비스 호출 (<--DAO 구현)
		List<BoardVO> totalList = boardService.boardList();
		int total = totalList.size();
		req.setAttribute("pageInfo", new Page(criteria, total));
		
		
		HttpUtil.forward(req, resp, "board/boardList.tiles");
	}

}
