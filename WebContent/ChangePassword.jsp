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
	font-size:20px;
}

form {
	display: inline-block;
}
	h3
	{
		padding-left:100px;
		color:pink;
	}
	a
	{
		padding-left:30	px;
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
</head>
<body bgcolor="grey">
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
				<form method="post" action="MovieApplicationServlet">
					<button type="submit" name="findbytheater" value="findbytheater">Find By Theater</button>
				</form>
			</td>
			<td>
				<div class="space">
				</div>
			</td>
			<td>
				<form method="post" action="MovieApplicationServlet">
					<button type="submit" name="findbymovie" value="findbymovie">Find By Movie</button>
				</form>
			</td>
			<td>
				<div class="space">
				</div>
			</td>
			<td>
				<form method="post" action="MovieApplicationServlet">
					<button type="submit" name="bookmovie" value="bookmovie">Book Movie</button>
				</form>
			</td>
			<td>
				<div class="space">
				</div>
			</td>
			<td>
				<form method="post" action="MovieApplicationServlet">
					<button type="submit" name="changepassword" value="changepassword">Change Password</button>
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
	<br/>
	<br/>
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
				</table>
				<table align="center"> 
				<tr>
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