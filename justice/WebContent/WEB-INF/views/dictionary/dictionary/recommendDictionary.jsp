<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<c:if test="${check==0}">
	<script>
		alert("에러가 발생했습니다. 다시시도해주세요");
		history.go(-1);
	</script>
</c:if>
<c:if test="${check==-1}">
	<script>
		alert("이미 추천한 단어입니다.");
		history.go(-1);
	</script>
</c:if>
<c:if test="${check>=1}">
	<meta http-equiv='refresh' content='0;url=list.ju'>
</c:if>