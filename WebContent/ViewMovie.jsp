<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Movie</title>
</head>
<body>
	<h3> <center> List of Movies </center> </h3>
	<br/>
	<table align="center" border="1" width="300px" height="100px">
		<tbody>
			<thead>
				<tr>	
					<th> Movie Id </th>
					<th> Movie Name </th>
				</tr>
			</thead>
		</tbody>
		<c:forEach var="movie" items="${MOVIE}">
		<tr>
			<td> ${movie.id} </td>
			<td> ${movie.name} </td>
		</tr>
		</c:forEach>
	</table>
	<br/>
	<br/>
	<br/>
	<form method="post" action="HomeServletmovie">
		<button type="submit" name="back">Back</button>
	</form>
</body>
</html>