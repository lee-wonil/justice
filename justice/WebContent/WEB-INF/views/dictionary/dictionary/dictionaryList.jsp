<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".menu>a").click(function(){
			var submenu = $(this).next("ul");
			if(submenu.is(":visible")){
				submenu.slideUp();
			}else{
				submenu.slideDown();
			}
		})
	})
</script>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .menu a{cursor:pointer;}
    .menu .hide{display:none;}
    li { list-style: none }
    ul { list-style: none }
</style>
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
			<td>▼</td>
			<td>번호</td>
			<td>단어</td>
			<td>대체어</td>
			<td>단어뜻</td>
			<td>추천수</td>
			<td></td>
		</tr>
		
		<c:forEach items="${dictionaryList}" var="dictionary">
			<tr>
				<!-- 드롭다운 구현예정 -->
				<td>
				<ul>
					<li class="menu"><a>▼</a>
					<ul class="hide">
						<li><a href="updateDictionary.ju?word_no=${dictionary.word_no}&pageNum=${pageNum}">단어 수정</a></li>
						<li><a href="deleteDictionary.ju?word_no=${dictionary.word_no}&pageNum=${pageNum}">단어 삭제</a></li>
					</ul>
					
					</li>
				</ul>
				</td>
				<td>${dictionary.word_no}</td>
				<td>${dictionary.wname}</td>
				<td>${dictionary.substitute}</td>
				<td>${dictionary.meaning}</td>
				<td>${dictionary.dic_recommend}</td>
				<!-- 매개변수 id 추가 -->
				<td><input type="button" onclick="window.location.href='recommendDictionary.ju?word_no=${dictionary.word_no}'" value="추천"/> &nbsp;
					<input type="button" onclick="window.location.href='reportDictionary.ju?word_no=${dictionary.word_no}'" value="신고"/>
				</td>
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
<table>
	<tr>
		<td><a href="insertDictionary.ju">글쓰기</a> &nbsp; <a href="showReport.ju">신고확인</a></td>
	</tr>
</table>
	
	

</body>
</html>