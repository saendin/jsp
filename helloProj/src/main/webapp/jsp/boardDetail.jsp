<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetail.jsp</title>
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
	<table>
		<thead>
		<tr>
			<th colspan="2">----------------------------게시판----------------------------</th>
		</tr>
		</thead>
		<tbody>
			<%
				String brdNo = request.getParameter("id");
				BoardDAO Bdao = new BoardDAO();
				BoardVO vo = Bdao.getBoard(Integer.parseInt(brdNo));
			%>		
				<c:set var="vo" value="<%=vo%>" />
						
					<tr><th>|글 번호|</th><td>${vo.boardId}</td></tr>
					<tr><th>|제  목|</th><td>${vo.title}</td></tr>
					<tr><th>|작성 자|</th><td>${vo.writer}</td></tr>
					<tr><th>|내  용|</th><td>${vo.content}</td></tr>
					<tr><th>|작성일시|</th><td>${vo.createDate}</td></tr>
					<tr><th>|조회 수|</th><td>${vo.cnt}</td></tr>
		</tbody>
		<p />
		<a href="boardList.jsp"><input type="submit" value="목록으로"></a>
	</table>
		<a href = "deleteForm.jsp?brdNo=${vo.boardId}"><input type="submit" value="삭제"></a>
		<a href = "updateForm.jsp?brdNo=${vo.boardId}"><input type="submit" value="수정"></a>
</body>
</html>