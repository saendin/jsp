<%@page import="com.tst.board.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el/example01.jsp</title>
</head>
<body>
 <%
 	request.setAttribute("user_id", "Hong"); // 값 담음
 	UserVO vo = new UserVO();
 	vo.setId("user1");
 	vo.setPwd("1111");
 	vo.setName("사용자1");
 	request.setAttribute("user", vo); //Attribute이름은 user. 값은 vo -> vo를 따라가보면 id, pwd, name 모두 담고 있음
 	
 	//request.getParameter("id"); ${param.id} --> param은 실행시 주소창의 http://localhost:8088/helloProj/el/example01.jsp?id=user1&pwd=1234 jsp? 다음에 쳐주면 됨.
 	//request.getparameter("pwd"); ${parma.pwd}
 
 %>
				<!-- el표현식 : 어떤 값을 받아와서 표현하겠다  -->
	<!-- //문자 -->
	Literal: ${"Literal"}
	<!-- //연산자 -->
	<br> Operator: ${5>3}
	<!-- //객체 -->
	<br> Object: ${header.host}
	<!-- //삼항연산자 -->
	<br> IfCondition: ${5>3 ? "true" : "false"}
	
	<br> Context: ${pageContext.servletContext.contextPath}
	
	<!-- 아래의 표현식으로 간단하게 위의 setAttribute값 담음 --> 
	<br> UserId : ${user_id}
	
	<br> UserVO : ${user.id}, ${user.pwd}, ${user.name}
	
	<br> UserVO : ${user}
	 
	<br> ${empty user ? "값이 없습니다." : user}
	
	<br> ID: ${param.id}, PWD: ${param["pwd"]}
	<!--  --> 
</body>
</html>