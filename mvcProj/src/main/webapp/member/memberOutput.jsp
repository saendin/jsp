<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberOutput.jsp</title>
</head>
<body>
	<c:set var="vo" value="${member}"></c:set>
	<p><c:out value="${vo.name}"></c:out>님 가입을 축하합니다!</p>
</body>
</html>