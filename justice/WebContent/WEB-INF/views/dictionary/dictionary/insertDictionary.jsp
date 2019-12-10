<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<!-- 유효성검사 javascript 구현필요 -->
<body>
<form action="insertDictionaryPro.ju">
	<table border="1">
		<tr><td>단어명 : <input type="text" name="wname"></td></tr>
		<tr><td>대체어 : <input type="text" name="substitute"></td></tr>
		<tr><td>단어뜻 : <input type="text" name="meaning"></td></tr>
		<tr><td>유저ID : <input type="text" name="user_id"></td></tr>
		<tr><input type="submit" value="단어 등록" /> </tr>
	</table>
</form>

</body>
</html>