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
	<center>단어 리스트 : ${count}</center>
<c:if test="${count == 0 }">
	<table>
		<tr>
			<td>사전에 저장된 단어가 없습니다.</td>
		</tr>
	</table>
</c:if>
<c:if test="${count>0}">
	<table>
		<tr>
			<td>번호</td>
			<td>단어</td>
			<td>대체어</td>
			<td>단어뜻</td>
			<td>추천수</td>
		</tr>
		<c:forEach items="${dictionaryList}" var="dictionary" varStatus="index">
			<tr>
				<td>${number-index.index}</td>
				<td>${dictionary.wname}</td>
				<td>${dictionary.substitute}</td>
				<td>${dictionary.meaning}</td>
				<td>${dictionary.dic_recommend}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<c:if test="${count>0}">
	<c:if test="${startPage>10}">
        <a href="list.ju?pageNum=${startPage-10}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
        <a href="list.ju?pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount }">
        <a href="list.ju?pageNum=${startPage+10}">[다음]</a>
    </c:if>
</c:if>
	
	

</body>
</html>