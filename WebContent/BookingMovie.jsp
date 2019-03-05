<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Movie</title>
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
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#movie').change(function() {
			$.ajax({
				url : 'GetUserBookServlet',
				data : {
					theater : $('#movie').val()
				},
				success : function(responseText) {
					var value=responseText.trim().split(':');
					var value1=responseText;
					for(var item in value)
						{
							$('#theater').append("<option value="+value[item]+">"+value[item]);
							
						}
					$('#show').append("<option value="+value[item]+">"+value[item]);
				}
			});
		});
	});
</script>
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
	<br/>
	<br/>
	<form method="post" action="BookMovieServlet">
		<table align="center">
			<tr> <td> &nbsp; </td> </tr>
			<tr>
				<td>Movie Name</td>
				<td><select name="moviename" id="movie">
						<option value="-1">---Choose---</option>
						<c:forEach var="moviename" items="${MOVIE}">
							<option value="${moviename.id}">${moviename.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr> <td> &nbsp; </td> </tr>
			<tr>
				<td>Theater Name</td>
				<td><select name="theatername" id="theater">
						<option value="-1">---Choose---</option>
				</select></td>
			</tr>
			<tr> <td> &nbsp; </td> </tr>
			<tr>
				<td>show</td>
				<td><select name="show" id="show">
						<option value="-1">---Choose---</option>
				</select></td>
			</tr>
			<tr> <td> &nbsp; </td> </tr>
			<tr>
				<td>Date</td>
				<td><input type="date" name="date"></td>
			</tr>
			<tr> <td> &nbsp; </td> </tr><tr>
				<td>No.of Ticket</td>
				<td><input type="number" name="noofticket"></td>
			</tr>
			<tr> <td> &nbsp; </td> </tr>
		</table>
		<br/>
		<table align="center">
			<tr>
				<td> <button type="submit">Book</button>
			</tr>
		</table>
	</form>
</body>
</html>