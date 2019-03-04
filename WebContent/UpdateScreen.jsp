<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Style.css">
</head>
<body bgcolor="#c4dbe7">
	<nav id="nav">
		<ul id="navigation">
			<li><a href="Home.jsp">Home</a>
			<li><a href="#">Movie &raquo;</a>
			<ul>
				<li>
					<form method="post" action="AddMovie.jsp">
						<button type="submit"><a>Add</a></button>
					</form>
				</li>
				<li>
					<form method="post" action="UpdateMovie">
						<button type="submit"><a>Update</a></button>
					</form>
				</li>
				<li>
					<form method="post" action="DeleteMovie">
						<button type="submit"><a>Delete</a></button>
					</form>
				</li>
			</ul></li>
		<li><a href="#">Theater &raquo;</a>
			<ul>
				<li>
					<form method="post" action="">
						<button type="submit" style="width:180px;"><a style="width:170px;">Theater &raquo;</a></button>
					</form>
					<ul>
						<li>
							<form method="post" action="AddTheater.jsp">
								<button type="submit"><a>Add</a></button>
							</form>
						</li>
						<li>
							<form method="post" action="UpdateTheater">
								<button type="submit"><a>Update</a></button>
							</form>
						</li>
						<li>
							<form method="post" action="DeleteTheater">
								<button type="submit"><a>Delete</a></button>
							</form>
						</li>
					</ul></li>
					<li>
						<form method="post" action="">
							<button type="submit" style="width:180px;"><a style="width:140px;">Screen &raquo;</a></button>
						</form>
						<ul>
						 <li>
							<form method="post" action="ScreenServlet">
								<button type="submit"><a>Add</a></button>
							</form>
						</li>
						<li>
							<form method="post" action="UpdateScreen">
								<button type="submit"><a>Update</a></button>
							</form>
						</li>
						<li>
							<form method="post" action="DeleteScreen">
								<button type="submit"><a>Delete</a></button>
							</form>
						</li>
						</ul>
					</li>
					<li>
						<form method="post" action="">
							<button type="submit" style="width:180px;"><a style="width:140px;">Movie in Theater &raquo;</a></button>
						</form>
						<ul>
						 <li>
							<form method="post" action="AddMovieinTheater">
								<button type="submit"><a>Add</a></button>
							</form>
						</li>
						<li>
							<form method="post" action="UpdateMovieinTheater">
								<button type="submit"><a>Update</a></button>
							</form>
						</li>
						<li>
							<form method="post" action="DeleteMovieinTheater">
								<button type="submit"><a>Delete</a></button>
							</form>
						</li>
						</ul>
					</li>
			</ul></li>
		<li><a href="Login.jsp">Logout</a></li>
	</ul>
	</nav>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<table>
		<tr>
			<td>
				<div align="center" style="width: 600px">
					<form method="post" action="UpdateTheaterScreen">
						<h2>Update Screen</h2>
						<table>
							<tr>
								<td>Name </td>
								<td><select name="theatername">
										<option value="-1">---Choose---</option>
										<c:forEach var="theatername" items="${THEATER}">
											<option value="${theatername.id}">${theatername.name}-${theatername.place}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>Screen </td>
								<td><select name="screen">
										<option value="-1">---Choose---</option>
										<c:forEach var="screen" items="${SCREEN}">
											<option value="${screen.screen}">${screen.screen}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>Total Seats </td>
								<td><input type="number" name="total" min="1" required></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
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
	<br/>
	<br/>
	<br/>
</body>
</html>