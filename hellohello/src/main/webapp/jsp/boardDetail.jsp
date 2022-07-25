<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
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
	th {
		text-align:left;
	}
	td {
		padding:2% 1%;
	}
</style>
</head>
<body>
	<table>
		<thead>
		<tr>
			<th colspan="2">----------------------------게시판----------------------------</th>
		</tr>
		</thead>
		<tbody>
			<%
			//파라미터를 읽어서 BoardDAO에서 한건 조회 기능을 사용. 화면에 출력하도록 구현하세요
				String brdNo = request.getParameter("id");
				BoardDAO dao = new BoardDAO();
				BoardVO vo = dao.getBoard(Integer.parseInt(brdNo));// 스트링"3"을 -> 인트 3으로 바꿔줌
			%>				
					<tr><th>|글 번호|</th><td><%=vo.getBoardId()%></td></tr>	<!-- <-글번호 -->
					<tr><th>|제  목|</th><td><%=vo.getTitle()%></td></tr>
					<tr><th>|작성 자|</th><td><%=vo.getWriter()%></td></tr>
					<tr><th>|내  용|</th><td><%=vo.getContent()%></td></tr>
					<tr><th>|작성일시|</th><td><%=vo.getCreateDate()%></td></tr>
					<tr><th>|조회 수|</th><td><%=vo.getCnt()%></td></tr>
		</tbody>
	</table>
</body>
</html>