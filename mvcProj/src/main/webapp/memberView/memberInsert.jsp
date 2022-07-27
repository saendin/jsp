<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보입력(memberInsert.jsp)</title>
</head>
<body>
	<h3>회원가입</h3>
<!-- 	아까 서블릿 매핑할때 .do로 끝나는 애들은 모두 FrontController 실행하기로 xml에 지정해놨음 -->
	<form action="../memberInsert.do" method="post">
		I D:<input type="text" name="id"><br>
		PWD:<input type="password" name="pwd"><br>
		NAME:<input type="text" name="name"><br>
		EMAIL:<input type="email" name="mail">
		<input type="submit" value="입력">
	</form>
</body>
</html>