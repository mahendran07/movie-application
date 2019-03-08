<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Style.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#theater').change(function() {
			$.ajax({
				url : 'GetUserServlet',
				data : {
					theater : $('#theater').val()
				},
				success : function(responseText) {
					var value=responseText.trim().split(',');
					for(var item in value)
						{
							$('#screens').append("<option value="+value[item]+">"+value[item]);
						}
				}
			});
		});
	});
</script>
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
					<form method="post" action="MovieApplicationServlet">
						<button type="submit" name="updatemovie" value="updatemovie"><a>Update</a></button>
					</form>
				</li>
				<li>
					<form method="post" action="MovieApplicationServlet">
						<button type="submit" name="deletemovie" value="deletemovie"><a>Delete</a></button>
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
							<form method="post" action="MovieApplicationServlet">
								<button type="submit" name="updatetheater" value="updatetheater"><a>Update</a></button>
							</form>
						</li>
						<li>
							<form method="post" action="MovieApplicationServlet">
								<button type="submit" name="deletetheater" value="deletetheater"><a>Delete</a></button>
							</form>
						</li>
					</ul></li>
					<li>
						<form method="post" action="">
							<button type="submit" style="width:180px;"><a style="width:140px;">Screen &raquo;</a></button>
						</form>
						<ul>
						 <li>
							<form method="post" action="MovieApplicationServlet">
								<button type="submit" name="addscreen" value="addscreen"><a>Add</a></button>
							</form>
						</li>
						<li>
							<form method="post" action="MovieApplicationServlet">
								<button type="submit" name="updatescreen" value="updatescreen"><a>Update</a></button>
							</form>
						</li>
						<li>
							<form method="post" action="MovieApplicationServlet">
								<button type="submit" name="deletescreen" value="deletescreen"><a>Delete</a></button>
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
							<form method="post" action="MovieApplicationServlet">
								<button type="submit" name="addmovieintheater" value="addmovieintheater"><a>Add</a></button>
							</form>
						</li>
						<li>
							<form method="post" action="MovieApplicationServlet">
								<button type="submit" name="updatemovieintheater" value="updatemovieintheater"><a>Update</a></button>
							</form>
						</li>
						<li>
							<form method="post" action="MovieApplicationServlet">
								<button type="submit" name="deletemovieintheater" value="deletemovieintheater"><a>Delete</a></button>
							</form>
						</li>
						</ul>
					</li>
			</ul></li>
		<li><a href="Login.jsp">Logout</a></li>
	</ul>
	</nav>
	<br />
	<br />
	<br />
	<br />
	<br />
	<table>
		<tr>
			<td>
				<div align="center" style="width: 600px">
					<form method="post" action="AddMovieTheaterServlet">
						<h2>Add Movie in Theater</h2>
						<table>
							<tr>
								<td>Theater Name</td>
								<td><select name="theatername" id="theater">
										<option value="-1">---Choose---</option>
										<c:forEach var="theatername" items="${THEATER}">
											<option value="${theatername.id}">${theatername.name}-${theatername.place}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
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
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>Show</td>
								<td><select name="show">
										<option value="-1">---Choose---</option>
										<option value="Morning">Morning</option>
										<option value="Afternoon">Afternoon</option>
										<option value="Evening">Evening</option>
										<option value="Night">Night</option>
								</select></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>

							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>Date</td>
								<td><input type="date" name="date"></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>Screen</td>
								<td>
									<select name="screen" id="screens">
										<option value="-1">-----Choose-----</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>Amount</td>
								<td><input type="number" name="amount"></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
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
		</tr>
	</table>
	<br />
	<br />
	<br />
</body>
</html>