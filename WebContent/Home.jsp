<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
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
							<form method="post" action="AddScreen.jsp">
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
	<h3> <center> Welcome Admin </center> </h3>
</body>
</html>