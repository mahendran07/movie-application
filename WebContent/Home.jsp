<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
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
	<div align="left" style="width: 600px; color: white;">
		<a href="login.html">Logout</a>
	</div>
	<br/>
	<h3> Choose Menu </h3>
	<br/>
	<br/>
	<form method="post" action="HomeServletmovie">
		<button type="submit" name="Movie">Movie</button>
	</form>
	<br/>
	<br/>
	<br/>
	<form method="post" action="HomeServlettheater">
		<button type="submit" name="Theater">Theater</button>
	</form>
	<br/>
	<br/>
	<br/>
	<form method="post" action="HomeServletmovietheater">
		<button type="submit" name="MovieinTheater">Movie in Theater</button>
	</form>
</body>
</html>