<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<c:if test="${check==0 }">
	<script>
		alert("에러가 발생했습니다.");
		location.href="boardList.ju";
	</script>
</c:if>
<c:if test="${check==-1 }">
	<script>
		alert("잘못된 접근입니다.");
		location.href="boardList.ju";
	</script>
</c:if>
<c:if test="${check==1 }">
	<center>
	<form action="boardUpdatePro.ju">
		<table>
			<tr>
				<input type="hidden" name="user_id" value="${brdDTO.user_id}"/>
				<input type="hidden" name="d_board_no" value="${brdDTO.d_board_no}"/>
				<td>단어명 : </td>
				<td>${brdDTO.wname }
					<input type="hidden" name="wname" value="${brdDTO.wname }"/>
				</td>
			</tr>
			<tr>
				<td>단어뜻 : </td>
				<td><input type="text" name="meaning" value="${brdDTO.meaning }"/></td>
			</tr>
			<tr>
				<td>제시어 : </td>
				<td><input type="text" name="prompt" value="${brdDTO.prompt }"/></td>
			</tr>
			<tr>
				<td>내용 : </td>
				<td><textarea rows="5" cols="40" name="detail_content">${brdDTO.detail_content }</textarea> </td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="수정하기"/>
				<input type="button" value="돌아가기"/>
				</td>
			</tr>
		</table>
	</center>
	</form>
</c:if>


</body>
</html>