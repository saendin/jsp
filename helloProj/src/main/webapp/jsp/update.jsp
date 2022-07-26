<%@page import="com.tst.board.BoardDAO"%>
<%@page import="com.tst.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		String id = request.getParameter("boardId");
		String title = request.getParameter("boardTitle");
		String content = request.getParameter("content");
		
		BoardVO boardInfo = new BoardVO();
		boardInfo.setBoardId(Integer.parseInt(id));
		boardInfo.setTitle(title);
		boardInfo.setContent(content);
		
		BoardDAO Bdao = new BoardDAO();
		Bdao.updateBoard(boardInfo);
		
		response.sendRedirect("boardList.jsp");
		
	%>