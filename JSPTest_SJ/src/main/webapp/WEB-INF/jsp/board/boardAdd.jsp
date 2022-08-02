<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글등록화면</title>
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
<!-- ///addBoard.do -->
<%-- 	<c:set var="user" value="${loginId}"></c:set>
	<c:if test="${empty user}">
		<c:redirect url="../member/memberloginForm.jsp"></c:redirect>
	</c:if> --%>
		<form action="${pageContext.request.contextPath}/insertBoard.do" method="post"> <!-- (FrontControll의 insertBoard.do)로 보냄 -->
		글 제목 |<input type="text" name="title"><br>
		글 내용 |<textarea name="content" cols="30" rows="3"></textarea><br> 
		작성 자 |<input type="text" name="writer"><br> <%-- value="${user}" --%>
			   <input type="submit" value="등록">
	</form>
</body>
</html>