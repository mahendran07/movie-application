<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie in Theater</title>
</head>
<body>
<table>
		<tr>
			<td>
				<div align="center" style="width: 600px">
					<form method="post" action="AddMovieTheaterServlet">
						<h2>Add Movie in Theater</h2>
						<table>
							<tr>
								<td>Theater Name</td>
								<td><select name="theatername">
										<option value="-1">---Choose---</option>
										<c:forEach var="theatername" items="${THEATER}">
											<option value="${theatername.id}">${theatername.name}-${theatername.place}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr> <td> &nbsp; </td> </tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
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
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>Show </td>
								<td><select name="show">
										<option value="-1">---Choose---</option>
										<option value="Morning">Morning</option>
										<option value="Afternoon">Afternoon</option>
										<option value="Evening">Evening</option>
										<option value="Night">Night</option>
								</select></td>
							</tr>
							<tr> <td> &nbsp; </td> </tr>
			
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>Date </td>
								<td><input type="date" name="date"></td>
							</tr>
							<tr> <td> &nbsp; </td> </tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>Total no.of Tickets </td>
								<td><input type="number" name="total"></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<button style="width: 100px;" type="submit">Add</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</td>
			<td>
				<div align="center" style="width: 600px">
					<form method="post" action="UpdateMovieServlet">
						<h2>Update Movie in Theater</h2>
						<table>
							<tr>
								<td>Theater Name</td>
								<td><select name="theatername">
										<option value="-1">---Choose---</option>
										<c:forEach var="theatername" items="${THEATER}">
											<option value="${theatername.id}">${theatername.name}-${theatername.place}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr> <td> &nbsp; </td> </tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
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
							<tr>
								<td>Show </td>
								<td><select name="show">
										<option value="-1">---Choose---</option>
										<option value="Morning">Morning</option>
										<option value="Afternoon">Afternoon</option>
										<option value="Evening">Evening</option>
										<option value="Night">Night</option>
								</select></td>
							</tr>
							<tr> <td> &nbsp; </td> </tr>
							<tr>
								<td></td>
								<td>
									<button style="width: 100px;" type="submit">Update</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</td>
		</tr>
	</table>
	<br>
	<br>
	<table>
		<tr>
			<td>
				<div align="center" style="width: 600px">
					<form method="post" action="DeleteMovieServlet">

						<h2>Delete Movie in Theater</h2>
						<table>
							<tr>
								<td>Theater Name</td>
								<td><select name="theatername">
										<option value="-1">---Choose---</option>
										<c:forEach var="theatername" items="${THEATER}">
											<option value="${theatername.id}">${theatername.name}-${theatername.place}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr> <td> &nbsp; </td> </tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
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
							<tr>
								<td>Show </td>
								<td><select name="show">
										<option value="-1">---Choose---</option>
										<option value="Morning">Morning</option>
										<option value="Afternoon">Afternoon</option>
										<option value="Evening">Evening</option>
										<option value="Night">Night</option>
								</select></td>
							</tr>
							<tr> <td> &nbsp; </td> </tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<button style="width: 100px;" type="submit">Delete</button>
								</td>
							</tr>
						</table>

					</form>

				</div>
			</table>
			<br/>
			<br/>
				<a href="Home.jsp" style="text-decoration:none; padding-left:80px; font-size:19px">Back</a>
			<br/>
</body>
</html>