<%@page import="com.tst.board.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tst.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/boardList.jsp</title>
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
<%-- 		<%
         String id = (String) session.getAttribute("loginId");
         if(id!= null) {
            out.print("<h3>" + id + "님으로 로그인 되었습니다 !" + "</h3><br>");
            out.print("<a href = 'logout.jsp'><input type='submit' value='로그아웃'></a><br>");
         } else {
            out.print("<h3> 로그인해주세요! </h3>");
         }
     	 %> --%>

	<table>
		<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>방문횟수</th>
			</tr>
		</thead>
		<tbody>
		<%--          <%   //로그인정보가 없거나 작성자랑 다르면 아래의 버튼을 보여주지 않을 것.
         String loginId = (String) session.getAttribute("loginId");
         if (loginId != null && loginId.equals(vo.getWriter())) {
         %>
            <tr><td><input type="hidden" name = "delete" value="<%=vo.getBoardId()%>">
            <input type="submit" value="삭제"></td><td><a href="boardList.jsp"><input type="submit" value="취소"></a></td></tr>
         <%
         } else {   
         %>
         <tr><td><input type="submit" value="삭제" disabled></td><td><a href="boardList.jsp"><input type="submit" value="취소"></a></td></tr>
         <%
         }
         %> --%>
		
			<%	//나중에 이부분은 컨트롤러로 빼줄거라 일단 표현식으로 바꾸지 않고 놔둠.
				BoardDAO dao = new BoardDAO();
				List<BoardVO> list = dao.boardList();
				//반복문만 바꿀거
				//for (BoardVO vo : list) {
			%>
			<c:set var="boards" value="<%=list%>" />
			<c:forEach var="vo" items="${boards}">
				<tr>
					<td><a href = "boardDetail.jsp?id=${vo.boardId}">${vo.boardId}</a></td>
					<td>${vo.title}</td>
					<td>${vo.writer}</td>
					<td>${vo.createDate}</td>
					<td>${vo.cnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	   <c:choose>
      <c:when test="${!empty loginId}">
         <a href="logout.jsp"><input type="button" value="로그아웃"></a>
      </c:when>
      <c:otherwise>
         <a href="login.jsp"><input type="button" value="로그인"></a>
      </c:otherwise>
   </c:choose>
	<table><a href = "addBoard.jsp"><input type="submit" value="글쓰기"></a>
	</table>
</body>
</html>