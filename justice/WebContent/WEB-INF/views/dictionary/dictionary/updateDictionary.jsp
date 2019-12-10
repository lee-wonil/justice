<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gg</title>
</head>
<body>
<form action="updateDictionaryPro.ju" method="post">
	<table>
	<tr><td>번호 : <input type="text" name="word_no" value="${dicDTO.word_no}" readonly /></td></tr>
	<tr><td>단어 명 : <input type="text" name="wname" value="${dicDTO.wname}"/> <br/></td></tr>
	<tr><td>단어 뜻 : <input type="text" name="meaning" value="${dicDTO.meaning }"/><br/></td></tr>
	<tr><td>대체 어: <input type="text" name="substitute" value="${dicDTO.substitute }"/></td></tr>
	<tr><td><input type="submit" value="수정"/></td></tr>
	</table>
</form>
	 

</body>
</html>