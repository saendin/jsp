<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm.jsp</title>
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
		String brdNo = request.getParameter("brdNo");
		BoardDAO Bdao = new BoardDAO();
		BoardVO vo = Bdao.getBoard(Integer.parseInt(brdNo));
	%>
	<c:set var="vo" value="<%=vo%>" />
	<form action="update.jsp">
		<table>
			<tr><th>글번호</th><td><input type="text" name = "boardId" value="${vo.boardId}" readonly></td></tr>
			<tr><th>글제목</th><td><input type="text" name = "boardTitle" value="${vo.title}"></td></tr>
			<tr><th>내용</th><td><input type="text" name = "content" value="${vo.content}"></td></tr>
			<%	//로그인정보가 없거나 작성자랑 다르면 아래의 버튼을 보여주지 않을 것.
			String loginId = (String) session.getAttribute("loginId");
/* 			if (loginId != null && loginId.equals(vo.getWriter())) { */
			%>
<%-- 			<c:set var="loginId" value="${session.getAttribute.loginId}">; --%>
			<c:choose>
				<c:when test="${!empty loginId && loginId eq vo.writer}">
					<tr><th></th><td><input type="text" name = "writer" value="${vo.writer}"></td></tr>
					<tr><td><input type="submit" value="수정"></td></tr>
				</c:when>
				<c:otherwise>
					<tr><td><input type="submit" value="수정" disabled></td></tr>
				</c:otherwise>
			</c:choose>
		</table>
	</form>
</body>
</html>