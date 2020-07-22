<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}
</style>
</head>

<body>

	<nav class="navbar navbar-default">

		<a href="/" class="navbar-brand">Brand</a>

		<ul class="nav navbar-nav">
			<li><a href="/home.do">Home</a></li>
			<li><a href="/list-todo.do">Todos</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li class="active"><a href="#">Login</a></li>
		</ul>

	</nav>

	<div class="container">
		<H1>Login</H1>
		<form action="/login.do" method="post">
			<p>
				<font color="red">${error }</font>
			</p>
			Name: <input type="text" name="name" />Password:
			<input type="password" name="pwd" /> <input type="submit"
				value="Go!" />
		</form>
	</div>

	<footer class="footer">
		<p>&copy All copyrights reserved</p>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>