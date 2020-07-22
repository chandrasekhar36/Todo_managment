<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Todos</title>
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
			<li  class="active"><a href="#">Todos</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="/logout.do">Log out</a></li>
		</ul>

	</nav>

	<div class="container">
		<H1>Todos</H1>
		<p>Hey, ${name}, you have following to catch up</p>
		<ol>
			<c:forEach items="${todos}" var="todo">
			<li>${todo.name} &nbsp;&nbsp;&nbsp;<a href="/delete-todo.do?todo=${todo.name}">Delete</a></li>
			</c:forEach>
		</ol>
		
		<p>Want to Add new one ?</p>
		<form action="/add-todo.do" method="post">
			<input type="text" name="newtodo"/>
			<input type="submit" value="Add todo"/>
		</form>
	</div>

	<footer class="footer">
		<p>&copy All copyrights reserved</p>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>