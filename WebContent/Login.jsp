<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style type="text/css">
body {
	text-align: center;
	padding-top: 190px;
}

form {
	display: inline-block;
}
</style>

</head>
<body>
	<form method="post" action="LoginServlet">
		<table>
			<tbody>
				<tr align="center">
					<td style="color: black" colspan="2" style="padding-top:50px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login
					</td>
				</tr>
				<tr> <td> &nbsp; </td> </tr>
				<tr>
					<td style="color: black">Email</td>
					<td><input type="text" name="email" required autocomplete="off"></td>

				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td style="color: black">Password </td>
					<td><input type="password" name="password" required autocomplete="off"></td>
				</tr>
				<tr> <td> &nbsp; </td> </tr>
				<tr>
					<td><a href="ForgetPassword.jsp">Forget Password?</a></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="Register.html">New User</a>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				</tbody>
				</table>
				<table align="center">
				<tr>
					<td><button type="submit" style="width: 100px">Login</button>
						</td>
				</tr>
				<tr>
				<td> &nbsp; </td> 
				<td> &nbsp; </td>
				<td> &nbsp; </td> 
				</tr>
				<tr>
					<td> ${MESSAGE}</td>
				</tr> 
			</tbody>
		</table>
	</form>
</body>
</html>