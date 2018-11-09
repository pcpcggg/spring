<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


hello : <spring:message code="hello"/> <br/>
visitor : <spring:message code="visitor" arguments="brown" /><br/>
<form action="/messageView" method="post">
	<select name="lang">
		<option value="ko" ${param.lang == 'ko' ? 'selected' : ''}>한국어</option>
		<option value="ja" ${param.lang == 'ja' ? 'selected' : ''}>日本語</option>
		<option value="en" ${param.lang == 'en' ? 'selected' : ''}>englist</option>
	</select>
	<input type="submit" value="전송"> 
</form>

</body>
</html>