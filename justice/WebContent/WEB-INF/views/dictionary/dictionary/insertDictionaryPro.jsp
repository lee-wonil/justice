<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${check==0 || empty check}">
	<script>
		alert("단어를 등록할 수 없습니다.");
		history.go(-1);
	</script>
</c:if>
<c:if test="${check>=0}">
	<meta http-equiv='refresh' content='0;url=list.ju'>
</c:if>
</body>
</html>