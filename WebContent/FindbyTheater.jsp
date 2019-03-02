<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find By Theater</title>
<style type="text/css">
h3
{
	text-align:center;
}
</style>
</head>
<body>
	<form method="post" action="ChooseMovieServlet">
		<br/>
		<br/>
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
				<td> <button type="submit">Choose</button>
			</tr>
		</table>
	
		<br/>
		<br/>
		<br/>
		<br/>
		<table align="center" border="1" width="500px" height="200px">
			<tr>
				<th> Theater Name and Place </th>
				<th> Show </th>
				<th> Show Date </th>
				<th> Total Ticket </th>
				<th> Amount </th>
			</tr>
			<c:forEach var="theater" items="${THEATERLIST}">
				<tr>
					<td>${theater.theater.name}-${theater.theater.place}</td>
					<td>${theater.show}</td>
					<td>${theater.date}</td>
					<td>${theater.total}</td>
					<td>${theater.theater.amount}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<br/>
	<br/>
	<div style="width: 600px; color: white; padding-left:60px;">
		<a href="UserHome.jsp" style="text-decoration:none; font-size:19px;">Back</a>
	</div>
</body>
</html>