<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome To Destroy Employee Career</h1>
	<form action="delete" method="post">
		Id:<input type="number" name="delete" value="<%=request.getParameter("id")%>"><br>
		<br> <input type="submit">
	</form>
</body>
</html>