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
<title>Insert title here</title>
<style>
	table {
		width:100%;
	}
	td {
		text-align:center;
		padding:2% 2%;
	}
</style>
</head>
<body>
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
</body>
</html>