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
	$(function() {
		$("#changeMember").click(function() {
			location.href = "changeMember.ju"
		})
		$("#deleteMember").click(function() {
			location.href = "deleteMember.ju"
		})

	})
</script>

</head>
<body>
	<c:if test="${check==1}">
		<div class="container">
			<input type="button" value="회원정보수정" id="changeMember"> 
			<input type="button" value="회원탈퇴" id="deleteMember">
		</div>
	</c:if>
	<c:if test="${check!=1}">
		<script type="text/javascript">
			alert("비밀번호를 확인해주세요");
			history.go(-1);
		</script>
	</c:if>
</body>
</html>