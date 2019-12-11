<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check>0 }">
	<form id="${vo.id}" class="${vo.id}" action="#">
		<table>
			<tr>
				<td><input type="text" value="${vo.id}" name="id" id="id" readonly/></td>
				<td><input type="text" value="${vo.passwd }" name="passwd"/></td>
				<td><input type="text" value="${vo.name }" name="name"/></td>
				<td><input type="text" value="${vo.admin}" name="admin"/></td>
				<td><input type="text" value="${vo.email}" name="email"/></td>
				<td><input type="button" id="btn_${vo.id}" value="전송" onclick="fuck('${vo.id}','${vo.passwd }','${vo.name }','${vo.admin }','${vo.email}')"/></td>
			</tr>
		</table>
	</form>
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