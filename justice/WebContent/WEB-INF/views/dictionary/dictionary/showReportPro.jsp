<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>신고자</td>
			<td>단어명</td>
			<td>신고사유</td>
		</tr>
	<c:forEach items="${reportContent}" var="rc">
		<tr>
			<td>${rc.user_id}</td>
			<td>${rc.wname}</td>
			<td>${rc.report_reason}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>