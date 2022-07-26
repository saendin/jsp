<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<c:set var="vo" value="<%=vo%>" />
		
		<tr><th>|글 번호|</th><td>${vo.boardId}</td></tr>
		<tr><th>|제  목|</th><td>${vo.title}</td></tr>
		<tr><th>|작성 자|</th><td>${vo.writer}</td></tr>
		<tr><th>|내  용|</th><td>${vo.content}</td></tr>
		<tr><th>|작성일시|</th><td>${vo.createDate}</td></tr>
		<tr><th>|조회 수|</th><td>${vo.cnt}</td></tr>
		</tbody>
		<p/>
	</table>
	<table>

			<c:choose>
      		<c:when test="${!empty loginId && loginId eq vo.writer}">
			<tr><td><input type="hidden" name = "delete" value="${vo.boardId}">
					<input type="submit" value="삭제"></td><td><a href="boardList.jsp"><input type="submit" value="취소"></a></td></tr>
			</c:when>
			<c:otherwise>
			<tr><td><input type="submit" value="삭제" disabled></td><td><a href="boardList.jsp"><input type="submit" value="취소"></a></td></tr>
			</c:otherwise>
			</c:choose>
	

	</table>
	</form>
</body>
</html>