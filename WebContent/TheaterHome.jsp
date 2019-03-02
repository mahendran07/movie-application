<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Theater Home Page</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

.navbar {
	overflow: hidden;
	background-color: #333;
	padding-left: -70px;
}

.navbar a {
	float: left;
	font-size: 16px;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}


.dropdown {
	float: left;
	overflow: hidden;
	padding-left: 250px;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: red;
}

.dropdown-content button {
	float: none;
	color: black;
	padding: 10px 12px;
	text-decoration: none;
	display: block;
	text-align: center;
	width: 160px;
}

.dropdown:hover .dropdown-content {
	display: block;
}
</style>
</head>
<body>
	<div class="navbar">
		<div class="navbar1">
			<div class="dropdown">
				<button class="dropbtn">Add Details</button>
				<div class="dropdown-content">
					<form method="post" action="AddTheater.jsp">
						<button type="submit">Theater</button>
					</form>
					<form method="post" action="AddScreenServlet">
						<button type="submit">Screen</button>
					</form>
				</div>
			</div>
		</div>
			<div class="dropdown">
				<button class="dropbtn">Update Details</button>
				<div class="dropdown-content">
					<form method="post" action="UpdateTheater">
						<button type="submit">Theater</button>
					</form>
					<form method="post" action="">
						<button type="submit">Screen</button>
					</form>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">Delete Details</button>
				<div class="dropdown-content">
					<form method="post" action="DeleteTheater">
						<button type="submit">Theater</button>
					</form>
					<form method="post" action="">
						<button type="submit">Screen</button>
					</form>
				</div>
			</div>
		</div>
	<br />
	<br />
	<br />
	<a href="Home.jsp"
		style="text-decoration: none; padding-left: 80px; font-size: 19px">Back</a>
</body>
</html>