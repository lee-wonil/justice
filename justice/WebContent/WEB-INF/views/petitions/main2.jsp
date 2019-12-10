<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	<td>인덱스</td>
	<td>주제</td>
	<td>제목</td>
	<td>청원 만료일</td>
	<td>참여인원</td>
</tr>
<c:forEach var="i" items="${list}">
<tr>
	<td><a href="https://www1.president.go.kr/petitions/${i.p_no}">${i.p_no}</a></td>
	<td>${i.p_subject}</td>
	<td>${i.p_title}</td>
	<td><fmt:formatDate value="${i.p_date}" pattern="yyyy-MM-dd"/></td>
	<td>${i.p_person}</td>
	<td>${i.p_check}</td>
	
</tr>
</c:forEach>
</table>
</body>
</html>