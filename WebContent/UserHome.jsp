<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
	h3
	{
		padding-left:100px;
	}
	a
	{
		padding-left:30px;
	}
	.space
	{
		padding-left:120px;
	}
</style>
<body>
	<br/>
	<br/>
	<h3> Welcome ${NAME.name} to World Best Movie Application</h3>
	<br/>
	<br/>
	<br/>
	<table align="center">
		<tr>
			<td>
				<form method="post" action="FindbyTheaterServlet">
					<button type="submit">Find By Theater</button>
				</form>
			</td>
			<td>
				<div class="space">
				</div>
			</td>
			<td>
				<form method="post" action="FindbyMovieServlet">
					<button type="submit">Find By Movie</button>
				</form>
			</td>
			<td>
				<div class="space">
				</div>
			</td>
			<td>
				<form method="post" action="UserServlet">
					<button type="submit">Change Password</button>
				</form>
			</td>
		</tr>
	</table>
	<br/>
	<br/>
	<br/>
	<div align="left" style="width: 600px; color: white;">
		<a href="Login.jsp" style="text-decoration:none; font-size:19px;">Logout</a>
	</div>
</body>
</html>