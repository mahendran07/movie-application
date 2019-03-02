<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

.navbar {
	overflow: hidden;
	background-color: #333;
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


.subnav {
	float: left;
	overflow: hidden;
}

.subnav .subnavbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.navbar a:hover, .subnav:hover .subnavbtn {
	background-color: red;
}

.subnav-content {
	display: none;
	position: absolute;
	left: 0;
	background-color: red;
	width: 100%;
	z-index: 1;
}

.subnav-content button {
	float: left;
	color: white;
	text-decoration: none;
}

.subnav-content a:hover {
	background-color: #eee;
	color: black;
}

.subnav:hover .subnav-content {
	display: block;
}
</style>
</head>
<body>
	<div class="navbar">
		<div class="dropdown">
			<button class="dropbtn">Movie</button>
			<div class="dropdown-content">
				<form method="post" action="AddMovie.jsp">
					<button type="submit">Add Movie</button>
				</form>
				<form method="post" action="UpdateMovie">
					<button type="submit">Update Movie</button>
				</form>
				<form method="post" action="DeleteMovie">
					<button type="submit">Delete Movie</button>
				</form>
			</div>
		</div>
		<div class="subnav">
			<button class="subnavbtn">Theater</button>
			<div class="subnav-content">
				<form method="post" action="AddTheater.jsp">
					<button type="submit">Add</button> 
				</form>
				<form method="post" action="UpdateTheaterServlet">
				<button type="submit">Update</button> 
				</form>
				<form method="post" action="DeleteTheaterServlet">
				<button type="submit">Delete</button>
				</form>
			</div>
			<div class="dropdown-content">
				<form method="post" action="AddTheater.jsp">
					<button>Theater</button>
				</form>
				<form method="post" action="AddTheater.jsp">
					<button type="submit">Screen</button>
				</form>
				<form method="post" action="AddTheater.jsp">
					<button type="submit">MovieinTheater</button>
				</form>
			</div>
		</div>
		<a href="Login.jsp">Logout</a>
	</div>
	<br />
</body>
</html>