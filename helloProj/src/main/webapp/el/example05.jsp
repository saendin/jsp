<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el/example05.jsp</title>
</head>
<body>
	--자바 for문--<br>
	<%
		for(int i=1; i<=10; i++) {
			out.print("i: " + i + "<br>");
		}
		String[] str = {"홍길동","김유신","김민식"};
		for(String name : str){
			System.out.print(name);
		}
		String fruits2 = "사과, 바나나, 수박, 복숭아";
	%>
	
	<br><br>--forEach문으로 자바 for문 쓰기--<br>
	
	<c:forEach var = "i" begin = "1" end = "10" step = "2"> <!-- forEach = for문 : 변수 i 선언/ 1~10까지 반복 / 2씩 증가 -->
		<c:out value="${i}"></c:out><br>
	</c:forEach>
	
	<br><br>--str 참조--<br>
	<c:set var="names" value="<%=str %>" />
	<c:forEach var="name" items="${names}">
		<li>${name}</li>
	</c:forEach>
	
	<br><br>--str 참조 fruit--<br>
	<small>items:변수명 | delims:넣어준 구분자로 배열 잘라줌(like splice) | var:변수이름</small>
	<c:set var="fruits2" value="<%=fruits2 %>" />
	<c:forTokens items="${fruits2}" delims="," var="fruit">
		<li>${fruit}</li>
	</c:forTokens>
</body>
</html>