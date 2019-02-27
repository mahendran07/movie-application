<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie Page</title>
</head>
<body>
	<table>
		<tr>
			<td>
				<div align="center" style="width: 600px">
					<form method="post" action="AddMovieServlet">
						<h2>Add Movie</h2>
						<table>
							<tr>
								<td>Name :</td>
								<td><input type="text" name="moviename"></td>
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
						<h2>Update Movie name</h2>
						<table>
							<tr>
								<td>Name</td>
								<td><select name="moviename">
										<option value="-1">---Choose---</option>
										<c:forEach var="moviename" items="${MOVIE}">
											<option value="${moviename.name}">${moviename.name}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr> <td> &nbsp; </td> </tr>
							<tr>
								<td>New Name</td>
								<td> <input type="text" name="movienamenew"></td>
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

						<h2>Delete Movie</h2>
						<table>
							<tr>
								<td>Name</td>
								<td><select name="deletename">
										<option value="-1">---Choose---</option>
										<c:forEach var="deletename" items="${MOVIE}">
											<option value="${deletename.name}">${deletename.name}</option>
										</c:forEach>
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