<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3> <center> Theater SCreen </center> </h3>
	<br/>
	<table align="center" border="1" width="500px" height="100px">
		<tbody>
			<thead>
				<tr>	
					<th> Id </th>
					<th> Theater Name </th>
					<th> Place </th>
					<th> Owner Name </th> 
				</tr>
			</thead>
		</tbody>
		<c:forEach var="theaterscreen" items="${THEATERSCREEN}">
		<tr>
			<td> ${theaterscreen.id}</td>
			<td> ${theaterscreen.theater.name} </td>
			<td> ${theaterscreen.screen} </td>
			<td> ${theaterscreen.totalTicket} </td>
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