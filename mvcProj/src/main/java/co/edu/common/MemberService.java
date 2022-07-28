package co.edu.common;

import java.util.List;

//업무 처리 로직
//기능은 DAO에서 세분화해서 만들고 처리를 Service에서 필요한대로 엮어서 쓸 수 있음
//ex)MemberDAO가 가지고 있는
//입력기능 필요시 ->
//입력&삭제기능 필요시 ->
//입력&수정기능 필요시 ->
//위와 같은 경우는 중복이 됨. 이것을 Service에서 유도리 있게 묶어서 처리 가능한듯?
public class MemberService {
	//싱글톤
	
	private static MemberService instance = new MemberService();
	private MemberService() {}
	
	public static MemberService getInstance() {
		return instance;
	}


	MemberDAO dao = new MemberDAO();
	public void memberAdd(MemberVO vo) {
		dao.insertMember(vo);
//		dao.deleteMember(vo); ->아직 DAO에서 구현 x
	}
}
