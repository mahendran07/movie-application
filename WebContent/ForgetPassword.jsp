<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	text-align: center;
	padding-top: 150px;
	font-size:20px;
}

form {
	display: inline-block;
}
button[type="submit"] {
  background: pink;
  border: 0;
  width: 250px;
  height: 40px;
  border-radius: 3px;
  color: black;
  cursor: pointer;
  transition: background 0.3s ease-in-out;
}
button[type="submit"]:hover {
  background: #16aa56;
}
a
{
	color:white;
	text-decoration:none;
}
</style>
</head>
<body bgcolor="grey">
	<form method="post" action="MovieApplicationServlet">
		<table>
			<tbody>
				<tr align="center">
					<td style="color: black" colspan="2" style="padding-top:50px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Forget 
					Password
					</td>
				</tr>
				<tr>
				<td> &nbsp; </td> 
				<td> &nbsp; </td>
				<td> &nbsp; </td> 
				</tr> 
				<tr>
					<td>Name </td>
					<td><input type="text" name="username" required autocomplete="off"></td>
				</tr>
				<tr>
				<td> &nbsp; </td> 
				<td> &nbsp; </td>
				<td> &nbsp; </td> 
				</tr> 
				<tr>
					<td style="color: black">Email</td>
					<td><input type="text" name="email" required autocomplete="off"></td>

				</tr>
				<tr>
				<td> &nbsp; </td> 
				<td> &nbsp; </td>
				<td> &nbsp; </td> 
				</tr> 
				<tr>
					<td>Phone number </td>
					<td><input type="number" name="phonenumber" required autocomplete="off"></td>
				</tr>
				<tr>
				<td> &nbsp; </td> 
				<td> &nbsp; </td>
				<td> &nbsp; </td> 
				</tr> 
				<tr>
					<td><a href="Login.jsp">Back</a></td>
					<td><button type="submit" style="width: 100px"
					name="forgetpasswordservlet" value="forgetpasswordservlet">Check</button>
						</td>
				</tr>
				<tr>
				<td> &nbsp; </td> 
				<td> &nbsp; </td>
				<td> &nbsp; </td> 
				</tr>
				<tr>
					<td> ${USERS}</td>
				</tr> 
				</tbody>
				</table>
	</form>
</body>
</html>