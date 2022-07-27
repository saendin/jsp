<%@page import="co.edu.common.MemberVO"%>
<%@page import="co.edu.common.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//controler역할을 하는 jsp page
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id"); //memberInput에 있는 name값 파라메터로 가져옴
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String mail = request.getParameter("mail");
	
	//서비스라는 객체가 가지고 있는 멤버에드의 매개값으로 vo 값을 넣어줄 것
	//위에 리퀘스트 파라미터의 멤버인풋의 name값을 가져와서 그것을 변수에 새로 담은 값이 set의 괄호 안의 값
	MemberVO vo = new MemberVO();
	vo.setId(id);
	vo.setPwd(pwd);
	vo.setName(name);
	vo.setMail(mail);
	
	MemberService service = MemberService.getInstance();
	service.memberAdd(vo);
	
	request.setAttribute("member", vo);
	
	//처리결과 : memberOutput.jsp
	RequestDispatcher rd= request.getRequestDispatcher("memberOutput.jsp");
	rd.forward(request, response); //request값과 response값을 담아서 forwarding하겠다
%>