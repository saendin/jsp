<%@page import="com.tst.board.BoardDAO"%>
<%@page import="com.tst.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
 	String name = request.getParameter("delete");
 
 	BoardVO boardInfo = new BoardVO();
 	
 	boardInfo.setBoardId(Integer.parseInt(name));
 	
 	BoardDAO Bdao = new BoardDAO();
 	Bdao.deleteBoard(boardInfo);
 	
 	response.sendRedirect("boardList.jsp");
 %>
</body>
</html>