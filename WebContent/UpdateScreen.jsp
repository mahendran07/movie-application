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
			$('#screen').empty();
			$.ajax({
				url : 'GetUserServlet',
				data : {
					theater : $('#theater').val()
				},
				success : function(responseText) {
					var value=responseText.trim().split(',');
					for(var item in value)
						{
							$('#screen').append("<option value="+value[item]+">"+value[item]);	
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
					<form method="post" action="MovieApplicationServlet">
						<h2>Update Screen</h2>
						<table>
							<tr>
								<td>Name </td>
								<td><select name="theatername" id="theater">
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
								<td><select name="screen" id="screen">
										<option value="-1">---Choose---</option>
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
									<button style="width: 100px;" type="submit"
									name="updatescreenservlet" value="updatescreenservlet">Update</button>
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