<%@page import="co.edu.dao.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.edu.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url('https://fonts.googleapis.com/css?family=Song+Myung:400');

body {
	color: grey;
	font-family: 'Nanum+Gothic Coding', serif;
	font-size: small;
}

table {
	width: 100%;
}

th {
	text-align: left;
}

td {
	padding: 2% 1%;
}

input[type="submit"] {
	float: right;
	margin-right: 5%;
	text-align: center;
}
.center {
  text-align: center;
}

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border-radius: 5px;
}

.pagination a:hover:not(.active) {
  background-color: #ddd;
  border-radius: 5px;
}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>글 번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일자</th>
				<th>방문횟수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${boardList}">
				<tr>
					<td>${vo.boardId}</td>
					<td>${vo.writer}</td>
					<td><a href = "boardDetail.jsp?id=${vo.boardId}">${vo.title}</a></td>
					<td>${vo.writeDate}</td>
					<td>${vo.visitCnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class = "center">
		<div class="pagination">
			<c:if test="${pageInfo.prev}">
			<a href="boardListPaging.do?pageNum=${pageInfo.startPage-1}&postNum=${pageInfo.cri.postNum}">◀pre</a>
			</c:if>
			<c:forEach var="num" begin="${pageInfo.startPage}" end="${pageInfo.endPage}"><!-- 여기서 num:페이지 정보 -->
				<a href="boardListPaging.do?pageNum=${num}&postNum=${pageInfo.cri.postNum}">${num}</a> 
			</c:forEach>
			<c:if test="${pageInfo.next}">
			<a href="boardListPaging.do?pageNum=${pageInfo.endPage+1}&postNum=${pageInfo.cri.postNum}">next▶</a>
			</c:if>
		</div>
	</div>
</body>
</html>