package co.dev.service;
import java.util.List;

//뷰 페이지
import co.dev.dao.MemberDAO;
import co.dev.vo.MemberVO;

//업무 처리하는 비즈니스 클래스
public class MemberService {
	private static MemberService instance = new MemberService(); //MemberService에서 instance를 하나 할당해서
	MemberDAO dao = new MemberDAO();
	
	private MemberService() {}//외부에서 접근 못하도록 private로 생성자 만들어줌
	public static MemberService getInstance() { //요 메소드만 실행(인스턴스(객체) 생성 메소드) == 싱글톤 방식 
		return instance;
	}
	
	//회원가입 기능
	public void addMember(MemberVO vo) { //DAO클래스가 가지고 있는 insert멤버 호출
		dao.insertMember(vo);
	}
	
	//회원목록 가져오기 기능
	public List<MemberVO> memberList() {
		return dao.getList();
	}
	
	//회원정보 조회
	public MemberVO getMember(String id) {
		return dao.searchMember(id);
	}
	
	
	public void modifyMember(MemberVO vo) {
		dao.updateMember(vo);
	}
	
	public void deleteMember(MemberVO vo) {
		dao.deleteMember(vo);
	}
	
	//하나에 여러개 기능 추가할 때 이런 식으로
//	public void addUpdateMember(MemberVO vo) {
//		dao.insertMember(vo);
//		dao.updateMember(vo);
}
