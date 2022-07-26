<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el/example06.jsp</title>
</head>
<body>
	<c:import url="footer.jsp" var="foot"></c:import>
	
	<h3>안녕하세용</h3>
	<small>include해서<br>example06안에 footer영역 포함시켜 봤습니다~</small>
	<small>방법은 아래의 세가지가 있습니다~</small>
	<br>
	<br>
	<small>1. 스크립트릿: </small><%@ include file="footer.jsp"%>
	<small>2. XML: </small><jsp:include page="footer.jsp"></jsp:include>
	<small>3. JSTL: </small>${foot}
	<br>
	<small>c:import url="footer.jsp" var="foot" => foot라는 변수에 담긴 url을 가져오겠습니다 </small>
</body>
</html>