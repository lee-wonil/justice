<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<body>
	<center><b>최신 뉴스</b></center>
	 <c:if test= "${news_count <= 0}">
	 	<b>해당 분야 기사를 찾지 못했습니다</b>
	 </c:if>
	 <c:if test= "${news_count > 0}">
	 	<table>
		<tr>
			<td>title</td> <!-- news_url -->
			<td>news_date</td> <!-- news_date -->
			<td>언론사</td> <!--news_press  -->
			<td>기자</td>	<!-- news_reporter -->
		</tr>	
		<c:forEach var="newslist" items="">
				<td>
					 <a href="dto.news_url">${dto.news_title}</a>
				</td>
				<td>
					 ${dto.news_date}
				</td>			
				<td>
					 ${dto.news_press}
					 ${dto.news_press}
				</td>
		</c:forEach>
		</table>
	</c:if>	
	
</body>