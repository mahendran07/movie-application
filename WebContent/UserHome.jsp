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
		color:pink;
	}
	a
	{
		padding-left:30px;
	}
	.space
	{
		padding-left:100px;
	}
	button[type="submit"] {
  background: #b5cd60;
  border: 0;
  width: 110px;
  height: 40px;
  border-radius: 3px;
  color: white;
  cursor: pointer;
  transition: background 0.3s ease-in-out;
}
button[type="submit"]:hover {
  background: #16aa56;
}
</style>
<body bgcolor="grey">
	<h3> Welcome ${NAME.name} to World Best Movie Application</h3>
	<br/>
	<br/>
	<br/>
	<br/>
	<table align="center">
		<tr>
			<td>
				<form method="post" action="UserHome.jsp">
					<button type="submit">Home</button>
				</form>
			</td>
			<td>
				<div class="space">
				</div>
			</td>
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
				<form method="post" action="BookMovie">
					<button type="submit">Book Movie</button>
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
			<td>
				<div class="space">
				</div>
			</td>
			<td>
				<form method="post" action="Login.jsp">
					<button type="submit">Logout</button>
				</form>
			</td>
		</tr>
	</table>
	<br/>
	<br/>
	<br/>
</body>
</html>