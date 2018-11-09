<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>view.jsp</h2>
	
	<form action="/validator/validate" method="post">
		<input name="userId" type="text" value="${param.userId}" /> <form:errors path="userVo.userId"/><br>
		<input name="name" type="text" value="${param.name}"/> <form:errors path="userVo.name"></form:errors><br>
		<input type="password" name="pass" /> <form:errors path="userVo.pass"/><br>
		<input type="submit" value="전송">
	</form>
	
	
	<h2>view.jsp-jsr303</h2>
	
	<form action="/validator/validateJsr" method="post">
		<input name="userId" type="text" value="${param.userId}" /> <form:errors path="userVoJsr303.userId"/><br>
		<input name="name" type="text" value="${param.name}"/> <form:errors path="userVoJsr303.name"></form:errors><br>
		<input type="password" name="pass" /> <form:errors path="userVoJsr303.pass"/><br>
		<input type="submit" value="전송">
	</form>
	
</body>
</html>