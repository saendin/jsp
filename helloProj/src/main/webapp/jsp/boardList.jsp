<%@page import="com.tst.board.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tst.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@300;400&display=swap');
		  body {
		  color: grey;
		  font-family : 'Noto Serif KR', serif;
		  font-size : small
		  }
		table {
			width:100%;
		}
		th {
			text-align:left;
		}
		td {
			padding:2% 1%;
		}
		input[type="submit"] {
		float:right;
		margin-right: 5%;
		text-align:center;
		}
	</style>
</head>
<body>
	<%
		String id = (String) session.getAttribute("loginId");
		if(id!= null) {
			out.print("<h3>" + id + "님으로 로그인 되었습니다 !" + "</h3><br>");
			out.print("<a href = 'logout.jsp'><input type='submit' value='로그아웃'></a><br>");
		} else {
			out.print("<h3> 로그인해주세요! </h3>");
		}
	%>

	<table>
		<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>방문횟수</th>
			</tr>
		</thead>
		<tbody>
			<%
				BoardDAO dao = new BoardDAO();
				List<BoardVO> list = dao.boardList();

				for (BoardVO board : list) {
			%>
				<tr>
					<td><a href = "boardDetail.jsp?id=<%=board.getBoardId()%>"><%=board.getBoardId()%></a></td>	<!-- <-글번호 -->
					<td><%=board.getTitle()%></td>
					<td><%=board.getWriter()%></td>
					<td><%=board.getCreateDate()%></td>
					<td><%=board.getCnt()%></td>
				</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<table><a href = "addBoard.jsp"><input type="submit" value="글쓰기"></a>
	</table>
</body>
</html>