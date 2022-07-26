package com.tst.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tst.common.DAO;

public class BoardDAO extends DAO {
	// 등록
	public void insertBoard(BoardVO vo) {
		connect();
		String sql = "insert into board values((select nvl(max(board_id),0)+1 from board), ?, ?, ?, sysdate, 0)"; // sysdate는
																													// 글
																													// 쓴
																													// 시점의
																													// 데이트를
																													// 입력해야되고
																													// count는
																													// 처음이
																													// 0이니까
																													// 그대로
																													// 사용

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());

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

	// 목록
	public List<BoardVO> boardList() {
		connect();
		String sql = "select * from board order by 1";
		List<BoardVO> list = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO(rs.getInt("board_id"), rs.getString("title"), rs.getString("content"),
						rs.getString("writer"), rs.getString("create_date"), rs.getInt("cnt"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 단건조회
	public BoardVO getBoard(int boardNo) {
		connect();
		String sql = "select * from board where board_id =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();

			if (rs.next()) { // 데이터가 있으면 if 구문 실행. 아래의 vo를 리턴
				BoardVO vo = new BoardVO();
				vo.setBoardId(boardNo);
				vo.setTitle(rs.getString("title"));// rs가 가지고 있는 값 중에서 title 읽어들일 것
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreateDate(rs.getString("create_date"));
				vo.setCnt(rs.getInt("cnt"));

				setCnt(boardNo); // 조회할 때 마다 카운트 증가하도록 추가

				return vo; // 조회되면 vo(조회된 값)리턴
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null; // 조회 안되면 null리턴
	}

	public void setCnt(int boardNO) {
		connect();
		String sql = "update board set cnt=cnt+1 where board_id=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNO);
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public void updateBoard(BoardVO vo) {
		connect();
		String sql = "update board set title=?, content=? where board_id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBoardId());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(result + "건 수정 완료");
			} else {
				System.out.println(result + "건 수정 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	public void deleteBoard(BoardVO vo) {
		connect();
		String sql = "delete from board where board_id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBoardId());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(result + "건 삭제 완료");
			} else {
				System.out.println(result + "건 삭제 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	public UserVO loginCheck(String id, String pwd) {
		connect();
		String sql = "select * from users where id=? and pwd=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				UserVO vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;

	}
}
