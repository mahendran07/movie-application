<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page for Movie</title>
<style>
body {
	text-align: center;
	padding-top: 50px;
	
}

form {
	display: inline-block;
}
div,a
{
	text-decoration: none;
	font-size:19px;
}
</style>
</head>
<body>
	<br/>
	<br/>
	<br/>
	<form method="post" action="AddMovie.jsp">
		<button type="submit">Add Movie</button>
	</form>
	<br/>
	<br/>
	<br/>
	<form method="post" action="UpdateMovie">
		<button type="submit">Update Movie</button>
	</form>
	<br/>
	<br/>
	<br/>
	<form method="post" action="DeleteMovie">
		<button type="submit">Delete Movie</button>
	</form>
	<br/>
	<br/>
	<br/>
	<a href="Home.jsp" style="text-decoration:none; padding-left:80px; font-size:19px">Back</a>
</body>
</html>