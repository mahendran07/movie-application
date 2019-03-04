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
	background: #2f313d;
  	color: #46485c;
  	font-family: sans-serif;
}
a
{
	color: white;
  	text-decoration: none;
}
.login {
  width: 290px;
  position: absolute;
  top: 50%;
  left: 50%;
  margin: -184px 0px 0px -155px;
  background: rgba(0,0,0,0.2);
  padding: 20px 35px;
  border-radius: 5px;
  box-shadow: 0px 1px 0px rgba(0,0,0,0.3),inset 0px 1px 0px rgba(255,255,255,0.07)
}

input[type="text"], input[type="password"] {
  width: 250px;
  padding: 25px 0px;
  background: transparent;
  border: 0;
  border-bottom: 1px solid rgba(255,255,255,0.04);
  outline: none;
  font-size:15px;
  color: white;
}
button[type="submit"] {
  background: #b5cd60;
  border: 0;
  width: 250px;
  height: 40px;
  border-radius: 3px;
  color: white;
  cursor: pointer;
  transition: background 0.3s ease-in-out;
}
button[type="submit"]:hover {
  background: #16aa56;
}
h2 {
  color: white;
  font-size: 17px;
  font-weight: 600;
  text-align: center;
  margin-bottom: 10px;
}
</style>

</head>
<body>
	<div class="login">
	<form method="post" action="LoginServlet">
		<h2>Sign in</h2>		
		<table>
			<tbody>
				<tr> <td> &nbsp; </td> </tr>
				<tr>
					<td><input type="text" name="email" placeholder="Email" required autocomplete="off"></td>

				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><input type="password" name="password" placeholder="Password" required autocomplete="off"></td>
				</tr>
				<tr> <td> &nbsp; </td> </tr>
				<tr> <td> &nbsp; </td> </tr>
				<tr>
					<td>
						<a href="Register.html">New User</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="ForgetPassword.jsp">Forget Password?</a></td>
					
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				</tbody>
				</table>
				<table align="center">
				<tr>
					<td><button type="submit">Login</button>
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
	</div>
</body>
</html>