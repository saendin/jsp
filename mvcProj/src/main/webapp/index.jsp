<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>첫 페이지입니다</h3>
	<a href="memberView/memberInsert.jsp"><input type="submit" value="회원등록"></a>
	<a href="memberView/memberSearch.jsp"><input type="submit" value="회원검색"></a>
	<a href="memberView/memberUpdate.jsp"><input type="submit" value="회원수정"></a>
	<a href="memberList.do"><input type="submit" value="회원목록"></a>
	<!-- .do로 끝나니까 FrontController로 갈거임 근데 구분하기 위해 path(내가 붙인 변수명 = uri-contextPath)값 부여하는것(memberList.do) -->
</body>
</html>