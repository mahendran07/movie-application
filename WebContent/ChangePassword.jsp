<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<style type="text/css">
body {
	text-align: center;
	padding-top: 150px;
}

form {
	display: inline-block;
}
</style>
</head>
<body>
	<form method="post" action="ChangePasswordServlet">
		<table>
			<tbody>
				<tr align="center">
					<td style="color: black" colspan="2" style="padding-top:50px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Change 
					Password
					</td>
				</tr>
				<tr>
				<td> &nbsp; </td> 
				<td> &nbsp; </td>
				<td> &nbsp; </td> 
				</tr> 
				<tr>
					<td>Old Password </td>
					<td><input type="password" name="oldpassword" required autocomplete="off"></td>
				</tr>
				<tr>
				<td> &nbsp; </td> 
				<td> &nbsp; </td>
				<td> &nbsp; </td> 
				</tr> 
				<tr>
					<td>New Password</td>
					<td><input type="password" name="newpassword" required autocomplete="off"></td>

				</tr>
				<tr>
				<td> &nbsp; </td> 
				<td> &nbsp; </td>
				<td> &nbsp; </td> 
				</tr> 
				<tr>
					<td>Confirm Password </td>
					<td><input type="password" name="confirmnewpassword" required autocomplete="off"></td>
				</tr>
				<tr>
				<td> &nbsp; </td> 
				<td> &nbsp; </td>
				<td> &nbsp; </td> 
				</tr> 
				<tr>
					<td><a href="UserHome.jsp">Back</a></td>
					<td><button type="submit" style="width: 100px">Update</button>
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