package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.vo.BoardVO;
import co.edu.vo.Criteria;

public class BoardDAO extends DAO {
	// 게시글 등록
	public void insertBoard(BoardVO vo) {
		connect(); // sysdate은 글쓴 시점의 것을 사용/ count는 0부터 시작
		String sql = "insert into test_board values(board_seq.nextval,?,?,?,sysdate,0)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());// title
			pstmt.setString(2, vo.getWriter());// content
			pstmt.setString(3, vo.getContent());// writer

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(result + "건 등록 완료");
			} else
				System.out.println(result + "건 등록 실패");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 게시글 목록
	public List<BoardVO> boardList() {
		connect();
		String sql = "select * from test_board";
		List<BoardVO> list = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO(rs.getInt("seq"),
						rs.getString("title"),
						rs.getString("writer"),
						rs.getString("content"),
						rs.getString("write_date"),
						rs.getInt("visit_cnt"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//글 조회
		public BoardVO getBoard(int boardId) {
			connect();
			String sql = "select * from test_board where seq =?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardId);
				rs = pstmt.executeQuery();

				if (rs.next()) { // 데이터가 있으면 if 구문 실행. 아래의 vo를 리턴
					BoardVO vo = new BoardVO();
					vo.setBoardId(boardId);
					vo.setTitle(rs.getString("title"));// rs가 가지고 있는 값 중에서 title 읽어들일 것
					vo.setContent(rs.getString("writer"));
					vo.setWriter(rs.getString("content"));
					vo.setWriteDate(rs.getString("write_date"));
					vo.setVisitCnt(rs.getInt("visit_cnt"));

					setCount(boardId); //조회->카운트메소드 실행

					return vo;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return null;
		}

		private void setCount(int boardId) {
			connect();
			String sql = "update test_board set visit_cnt=visit_cnt+1 where seq=?";

			try {
				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, boardId);
				pstmt.executeQuery();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
		
		//페이징 (postNum:한 페이지당 보여주고 싶은 글 갯수, pageNum:페이지 넘버)
		public List<BoardVO> getListPaging(Criteria criteria) { 
			connect();
			List<BoardVO> listPage = new ArrayList<>();
			String sql =  "select seq, title, writer, content, write_date, visit_cnt "
						+ "from (select rownum rn, seq, title, writer, content, write_date, visit_cnt "
					+ "          from (select seq, title, writer, content, write_date, visit_cnt "
				+ "                    from test_board "
				+ "                    order by seq desc) "
						+ "      where rownum <= ?) " //페이지안의 글 1페이지: 0~10개, 2페이지: 10~20개
						+ "where rn> ?";//페이지
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, criteria.getPostNum() * criteria.getPageNum());
				pstmt.setInt(2, criteria.getPostNum() * (criteria.getPageNum() -1));
				rs = pstmt.executeQuery();
				while(rs.next()) {
					BoardVO board = new BoardVO();
					board.setBoardId(rs.getInt("seq"));
					board.setTitle(rs.getString("title"));
					board.setContent(rs.getString("content"));
					board.setWriter(rs.getString("writer"));
					board.setWriteDate(rs.getString("write_date"));
					board.setVisitCnt(rs.getInt("visit_cnt"));
					
					listPage.add(board);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			
			return listPage;
			
			
		}
}
