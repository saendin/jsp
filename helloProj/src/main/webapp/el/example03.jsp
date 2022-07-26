<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el/example03.jsp</title>
</head>
<body>
	<%
		String param = request.getParameter("msg");
	%>
	<c:catch var="ex">
	
	<%
		if(param.equals("add")){ //만약에 파람의 값이 add와 같을 때 param을 출력하시오
			out.print(param);
		}
	%>
	</c:catch>
	<c:out value="${ex}"></c:out>
</body>
</html>