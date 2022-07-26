<%@page import="com.tst.common.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empResult.jsp</title>
</head>
<body>
	<table border="1">
		<thead>
		<tr>
		<th>사원번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>고용일</th></tr>
		</thead>
		<tbody>
			<%
					//자바스크립트 안에서 자바소스 쓰는법
				request.getParameter(""); //request(내장객체)
				List<Employee> list = (List<Employee>)request.getAttribute("data");
				for (Employee emp : list) {
					//값에 담신 변수를 들고올 때는 '<%=' 로 써줌
			%>
			<tr>
			<td><%=emp.getEmployeeId() %></td>
			<td><%=emp.getFirstName()%></td>
			<td><%=emp.getEmail()%></td>
			<td><%=emp.getHireDate()%></td>
			</tr>
			<%
					//out.print("<br>" + "사원번호: " + emp.getEmployeeId() + "<br>이메일: " + emp.getEmail() + "<br>고용일: " + emp.getHireDate());
				}
			%>
		</tbody>
	</table>
</body>
</html>