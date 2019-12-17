<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(document).on('click', '#searchBtn', function(){
			var url = "boardList.ju";
			var category = $("#category").val();
			url = url + "?category=" + category;
			var keyword = $("#keyword").val();
			url = url + "&keyword=" + keyword
			alert(category + " / " + keyword);
			location.href=url;
		});
	});
	
	$(function(){
		$(document).on('click', '#board_table tr', function(){
			//var tr = $(this);
			//var td = tr.children();
			var d_board_no = $(this).find("#d_board_no").val();
			$.ajax({
				type : 'post',
				url : "/justice/dboard/boardContent.ju",
				data : {d_board_no : d_board_no},
				success : function(data){
					$("#"+d_board_no).html(data);
				}
				
			})
		})
	})
	
	$(function(){
		$(document).on('click', '#updateBtn', function(){
			var btn = $(this);
			var tr = btn.parent().parent();
			var num = tr.find("#d_board_no").val();
			alert(num);
			
		})
	})
</script>

</head>
<body>
<c:if test="${count==0 }">
	<h1>해당 게시판에 글이 존재하지 않습니다.</h1>
</c:if>
<c:if test="${count>0}">
	<center>글 개수 : ${count}</center>
	<center>
	<table id="board_table">
		<tr>
			<td>번호</td>
			<td>단어명</td>
			<td>제시어</td>
			<td>단어뜻</td>
			<td>추천수</td>
			<td>게시일</td>
		</tr>
		<c:forEach items="${boardList}" var="board_article" varStatus="status">
			<tr>
				<input type="hidden" value="${board_article.d_board_no}" id="d_board_no"/>
				<td>${number-status.index }</td>
				<td>${board_article.wname }</td>
				<td>${board_article.prompt }</td>
				<td>${board_article.meaning }</td>
				<td>${board_article.b_recommend }</td>
				<td>${board_article.board_reg }</td>
				<c:if test="${board_article.user_id == memId || admin!=null }">
				<td>
					<input type="button" value="수정" id="updateBtn"/>
					<input type="button" value="삭제" id="deleteBtn"/>
				</td>
				</c:if>
			</tr>
			<tr>
				<tbody id="${board_article.d_board_no}"></tbody>
			</tr>
		</c:forEach>
	</table>
	</center>
</c:if>
<!-- 페이징 -->
<c:if test="${count>0}">
<center>
	<c:if test="${startPage>10}">
        <a href="boardList.ju?pageNum=${startPage-10}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
        <a href="boardList.ju?pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount }">
        <a href="boardList.ju?pageNum=${startPage+10}">[다음]</a>
    </c:if>
</center>
</c:if>
<br>
<center>
<tr>
	<td><a href="boardWrite.ju">글쓰기</a></td>
	<td><a href="boardList.ju">목록</a></td>
</tr>
<div>
	<select name="category" id="category">
		<option value="wname">단어명</option>
		<option value="meaning">단어뜻</option>
		<option value="prompt">제시어</option>
		<option value="all">전체</option>
	</select>
	<input type="text" name="keyword" id="keyword" />
	<input type="button" value="검색" id="searchBtn">
</div>
</center>

</body>
</html>