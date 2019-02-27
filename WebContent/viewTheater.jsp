<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Theater</title>
</head>
<body>
	<h3> <center> List of Theaters </center> </h3>
	<br/>
	<table align="center" border="1" width="300px" height="100px">
		<tbody>
			<thead>
				<tr>	
					<th> Theater Id </th>
					<th> Theater Name </th>
					<th> Place </th>
					<th> Amount </th> 
				</tr>
			</thead>
		</tbody>
		<c:forEach var="theater" items="${THEATER}">
		<tr>
			<td> ${theater.id} </td>
			<td> ${theater.name} </td>
			<td> ${theater.place} </td>
			<td> ${theater.amount} </td>
		</tr>
		</c:forEach>
	</table>
	<br/>
	<br/>
	<br/>
	<form method="post" action="HomeServlettheater">
		<button type="submit" name="back">Back</button>
	</form>
</body>
</html>