<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteFrom.jsp</title>
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
	<form action = "delete.jsp">
	<table>
		<thead>
		<tr>
			<th colspan="2">----------------------------게시판----------------------------</th>
		</tr>
		</thead>
		<tbody>
	<%
		String brdNo = request.getParameter("brdNo");
		BoardDAO Bdao = new BoardDAO();
		BoardVO vo = Bdao.getBoard(Integer.parseInt(brdNo));
	%>			
		<tr><th>|글 번호|</th><td><%=vo.getBoardId()%></td></tr>	<!-- <-글번호 -->
		<tr><th>|제  목|</th><td><%=vo.getTitle()%></td></tr>
		<tr><th>|작성 자|</th><td><%=vo.getWriter()%></td></tr>
		<tr><th>|내  용|</th><td><%=vo.getContent()%></td></tr>
		<tr><th>|작성일시|</th><td><%=vo.getCreateDate()%></td></tr>
		<tr><th>|조회 수|</th><td><%=vo.getCnt()%></td></tr>
		</tbody>
		<p/>
	</table>
	<table>
				<%	//로그인정보가 없거나 작성자랑 다르면 아래의 버튼을 보여주지 않을 것.
			String loginId = (String) session.getAttribute("loginId");
			if (loginId != null && loginId.equals(vo.getWriter())) {
			%>
				<tr><td><input type="hidden" name = "delete" value="<%=vo.getBoardId()%>">
				<input type="submit" value="삭제"></td></tr>
			<%
			} else {	
			%>
			<tr><td><input type="submit" value="삭제" disabled></td></tr>
			<%
			}
			%>
	

	</table>
	</form>
</body>
</html>