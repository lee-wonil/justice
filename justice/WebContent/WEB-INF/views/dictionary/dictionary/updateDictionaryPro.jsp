<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${check==0}">
	<script>
		alert("수정에 실패했습니다. 다시시도해주세요.");
		history.go(-1);
	</script>
</c:if>
<c:if test="${check>0}">
	<meta http-equiv='refresh' content='0;url=list.ju'>
</c:if>