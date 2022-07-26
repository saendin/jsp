<%@page import="com.tst.board.BoardDAO"%>
<%@page import="com.tst.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); // 한글읽어오기 가능
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String writer = request.getParameter("writer");
	
	BoardVO vo = new BoardVO();
	vo.setTitle(title);
	vo.setContent(content);
	vo.setWriter(writer);
	
	BoardDAO dao = new BoardDAO();
	dao.insertBoard(vo); //Board(vo) 타입에 위의 값들을 인서트해서 
	
	out.print("completed !");
	response.sendRedirect("boardList.jsp");
%>