<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:if test="${check==1}">
<body>
	<meta http-equiv='refresh' content='0;url=adminpage.ju'>
</body>
</c:if>
<c:if test="${check==0}">
	<script>
		alert("에러가 발생했습니다.");
		history.go(-1);
	</script>
</c:if>
<c:if test="${check==-1}">
	<script>
		alert("권한이 없습니다.");
		history.go(-1);
	</script>
</c:if>

</html>