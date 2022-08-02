package co.edu.service;

import co.edu.dao.MemberDAO;
import co.edu.vo.MemberVO;

public class MemberService {
	//싱글톤 생성
	private static MemberService instance = new MemberService();
	public static MemberService getInstance() {
		return instance;
	}
	private MemberService() {};
	
	MemberDAO dao = new MemberDAO();
	
	//addMember서비스
	public void addMember(MemberVO vo) {
		dao.insertMember(vo);
	}
	
}
