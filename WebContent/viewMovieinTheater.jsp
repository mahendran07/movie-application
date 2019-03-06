<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Movies in Theater</title>
<style>
table#t01 tr:nth-child(even) {
  background-color: #eee;
}
table#t01 tr:nth-child(odd) {
 background-color: #fff;
}
</style>
</head>
<body bgcolor="#16aa56">
	<h3> <center> Movies in Theater </center> </h3>
	<br/>
	<table align="center" width="800px" height="200px" id="t01">
			<thead>
				<tr>	
					<th> Theater Name & Place </th>
					<th> Movie Name </th>
					<th> Show </th>
					<th> Date </th>
					<th> Screen </th>
					<th> Amount(one) </th>
					<th> Tickets </th>
				</tr>
			</thead>
		<tbody>
			<c:forEach var="movie" items="${MOVIEINTHEATER}">
				<tr>
					<td> ${movie.theater.name}-${movie.theater.place}</td>
					<td> ${movie.movie.name}</td>
					<td> ${movie.show}</td>
					<td> ${movie.date}</td>
					<td> ${movie.theaterscreen.screen} </td>
					<td> ${movie.amount} </td>
					<td> ${movie.theaterscreen.totalTicket}</td>
				</tr>
		</c:forEach>
	</table>
	<br/>
	<br/>
	<br/>
	<form method="post" action="Home.jsp">
		<button type="submit" name="back">Back</button>
	</form>
</body>
</html>