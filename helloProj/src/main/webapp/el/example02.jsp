<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tst.board.BoardVO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- //prefix : 내가 정한 이름으로 쓰게끔 해줌 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el/example02.jsp</title>
</head>
<body>
	<%
		BoardVO vo = new BoardVO();
		String name = "Hong";
	%>
	//<% %> 를 안쓰고 자바스크립트로 자바처럼 써주는 법 (tomcat의 taglib 다운받아서 WEB-INF -> lib에 파일 4개 전부 다 넣어줘야 사용 가능)
	
	<c:set var="user" value="user1"></c:set>
	<c:out value="${user}"></c:out>
	
	<c:set var="p1" value="${param.title}"></c:set> //값을 담을때는 c:set태그를
	<c:set var="p2" value="${param.content}"></c:set>
	<c:set var="p3" value="${param.writer}"></c:set>
	
	<p><c:out value="${p1}"></c:out></p>//값을 출력할때는 c:out 태그를
	<p><c:out value="${p2}"></c:out></p>
	<p><c:out value="${p3}"></c:out></p>
</body>
</body>
</html>