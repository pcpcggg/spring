<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>fileupload View</h2>
	<form action="/mvc/fileupload" method="post" enctype="multipart/form-data">
		<input type="file" name="uploadFile"><br/><br/>
		<input type="text" name="userId" value="brown"><br/><br/>
		<input type="submit" value="업로드">
	</form>
	
</body>
</html>