<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="reportDictionaryPro.ju" method="post">
	<table>
		<input type="hidden" name="wname" value="${dicDTO.wname}"/>
		<input type="hidden" name="word_no" value="${dicDTO.word_no}"/>
		<tr><td>신고할 단어 : ${dicDTO.wname} (번호 : ${dicDTO.word_no}) </td></tr>
		<tr><td>신고자 : <input type="text" name="user_id" /></td></tr>
		<tr><td>신고 사유 </td></tr>
		<tr><td><textarea name="report_reason" rows="10" cols="20"></textarea> </td></tr>
		<tr><td><input type="submit" value="신고"> </td></tr>
	</table>

</form>
