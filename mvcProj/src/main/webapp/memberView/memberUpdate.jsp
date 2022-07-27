<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정검색(memberUpdate.jsp)</title>
</head>
<body>
	<h3>수정 회원검색</h3>
	${error} <!-- 검색 정보 없으면 에러메세지 발송 -->
	<form action="${pageContext.request.contextPath}/memberSearch.do" method="post">
		<br><br>
		아이디: <input type="text" name="id">
		<!-- 서치페이지(search)와 업데이트페이지(update)에서 넘어오는게 다르므로 구분되도록 히든파라메터 지정 -->
		<input type="hidden" name="job" value="update"> <!-- job이라는 파라메터를 받아와서 값이 update면 수정되도록 -->
		<input type="submit" value="조회">
	</form>
	
	<br><br>-----------------------------------<br>
	
	<c:set var="vo" value="${member}" /> <!-- req.setAttribute("member", service.getMember(id)); 의 멤버값을 vo에 담음-->
	<c:choose>
		<c:when test="${!empty vo}">
			<form action="" method="post"> <!-- 있는 유저이면 불러올 페이지 설정-->
				아이디: <input type="text" name="id" value="${vo.id}" readonly><br> <!-- id는 키 벨류 속성으로 리드온리처리 -->
				이름: <input type="text" name="name" value="${vo.name}"><br>
				이메일: <input type="text" name="mail" value="${vo.mail}"><br>
				비밀번호: <input type="password" name="pwd" value="${vo.pwd}"><br>
				<input type="submit" value="수정">
			</form>
		</c:when>
		<c:otherwise> <!-- 없는 유저일때 -->
			<p>${result}</p>
		</c:otherwise>
	</c:choose>
	
</body>
</html>