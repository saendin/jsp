<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInput.jsp</title>
</head>
<body>
<!-- 뷰 역할의 입력화면 -->
	<h3>회원가입</h3>
	<form action="memberProc.jsp" method="post">
		I D:<input type="text" name="id"><br>
		PWD:<input type="password" name="pwd"><br>
		NAME:<input type="text" name="name"><br>
		EMAIL:<input type="email" name="mail">
		<input type="submit" value="입력">
	</form>
</body>
</html>