<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addBoard.jsp</title>
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
<%-- 	<%
	String user = (String) session.getAttribute("loginId");
	if (user == null || user.equals("")) {
		response.sendRedirect("loginForm.jsp");
	}
	%> --%>
	<c:set var="user" value="${loginId}"></c:set>
	<c:if test="${empty user}">
		<c:redirect url="loginForm.jsp"></c:redirect>
	</c:if>
	
	<form action="insertBoard.jsp" method="post">
		글 제목: <input type="text" name="title"><br>
		글 내용:<textarea name="content" cols="30" rows="3"></textarea><br> 
		작성자: <input type="text" name="writer" value="${user}" readonly><br>
			  <input type="submit" value="등록">
	</form>
</body>
</html>