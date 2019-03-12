<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find By Theater</title>
<style type="text/css">
body {
	text-align: center;
	font-size:20px;
}

h3
{
	text-align:center;
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
	<form method="post" action="MovieApplicationServlet">
		<h3> Choose Movie Name </h3>
		<table align="center">
			<tr> <td> &nbsp; </td> </tr>
			<tr>
				<td>Movie Name</td>
				<td><select name="moviename">
						<option value="-1">---Choose---</option>
						<c:forEach var="moviename" items="${MOVIE}">
							<option value="${moviename.id}">${moviename.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr> <td> &nbsp; </td> </tr>
		</table>
		<br/>
		<table align="center">
			<tr>
				<td> <button type="submit"
				name="findbytheaterservlet" value="findbytheaterservlet">Choose</button>
			</tr>
		</table>
	
		<br/>
		<br/>
		<br/>
		<table align="center" border="1" width="750px" height="100px">
			<tr>
				<th> Theater Name and Place </th>
				<th> Show and Screen </th>
				<th> Show Date </th>
				<th> Total Ticket </th>
				<th> Amount </th>
			</tr>
			<c:forEach var="theater" items="${THEATERLIST}">
				<tr>
					<td>${theater.theater.name}-${theater.theater.place}</td>
					<td>${theater.show}-${theater.theaterscreen.screen}</td>
					<td>${theater.date}</td>
					<td>${theater.theaterscreen.totalTicket}</td>
					<td>${theater.amount}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<br/>
	<br/>
</body>
</html>