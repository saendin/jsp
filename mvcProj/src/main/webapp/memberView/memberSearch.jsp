<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원검색기능(memberSearch.jsp)</title>
</head>
<body>
	<h3>회원검색</h3>
	${error} <!-- 검색 정보 없으면 에러메세지 발송 -->
	<%-- <%=request.getContextPath()%> == ${pageContext.request.contextPath}(=프로젝트 절대경로)에서 멤버서치.do를 검색하겠다. --%>
	<!-- 어느페이지에서 요청하든지 상관없이 /memberSearch.do를 실행함 -->
	<form action="${pageContext.request.contextPath}/memberSearch.do" method="post">
		<br><br>
		아이디: <input type="text" name="id"><br>
		<!-- 서치페이지(search)와 업데이트페이지(update)에서 넘어오는게 다르므로 구분되도록 히든파라메터 지정 -->
		<input type="hidden" name="job" value="search">
		<input type="submit" value="조회">
	</form>
</body>
</html>