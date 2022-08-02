package co.edu.service;

import java.util.List;

import co.edu.dao.BoardDAO;
import co.edu.vo.BoardVO;
import co.edu.vo.Criteria;

public class BoardService {
	//싱글톤 생성
	private static BoardService instance = new BoardService();
	public static BoardService getInstance() {
		return instance;
	}
	private BoardService() {};
	
	BoardDAO bDao = new BoardDAO();
	
	//addBoard서비스
	public void addBoard(BoardVO vo) {
		bDao.insertBoard(vo);
	}
	
	//boardList서비스
	public List<BoardVO> boardList() {
		return bDao.boardList();
	}
	
	//paging서비스
	public List<BoardVO> getListPaging(Criteria criteria) {
		return bDao.getListPaging(criteria); //글이 10
	}
	
	//페이징
}
