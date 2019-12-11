<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(function(){
		$(document).on('click', '.update', function(){
			var checkBtn = $(this);
			var tr = checkBtn.parent().parent();
			var td = tr.children();
			var id = td.eq(0).text();
			$.ajax({
				type:"post",
				url : "/justice/adminUpdate.ju?id="+id,
				success : function(data){
					$("#"+id).html(data);	
				}
			})
		});
	});
	
	function fuck(id,passwd,name,admin,email){
		var allData = {"id":id, "passwd":passwd, "name":name, "admin":admin, "email":email };
		$.ajax({
			cache : false,
			url : "/justice/adminUpdatePro.ju",
			type : "post",
			data : allData,
			success : function(data){
				alert("완료");
				var jsonObj = JSON.parse(data);
				window.location.href= "/justice/adminpage.ju";
			}
			
		})
	}
</script>

</head>
<body>
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
<c:if test="${check==1 }">
<center>
	<table>
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>관리자 권한</td>
			<td>email</td>
			<td></td>
		</tr>
		<c:forEach items="${memberList}" var="memData">
			<tr>
				<td>${memData.id}</td>
				<td>${memData.passwd }</td>
				<td>${memData.name }</td>
				<td>${memData.admin }</td>
				<td>${memData.email }</td>
				<td>
				<input type="button" value="수정하기" id="update" class="update"/>
				<input type="button" value="삭제" id="delete" class="delete"/>
				</td>
			</tr>
				<tbody id="${memData.id}"></tbody>
		</c:forEach>
		
	</table>
</center>
</c:if>



</body>
</html>