<%@include file="../common/header.jspf"%>
<nav class="navbar navbar-dark bg-primary"
	style="background-color: #e3f2fd;">

	<a href="#" class="navbar-brand">Brand</a>
	<ul class="nav navbar-nav">
		<li><a href="/home.do">Home</a></li>
		<li><a href="/list-todo.do">Todos</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li><a href="/logout.do">Login</a></li>
	</ul>
</nav>
<div class="container">
	<H1>Login</H1>
	<form action="/register.do" method="post">
		<div class="text-danger">
			<p>${error }</p>
		</div>
		<div class="form-group">
			<label>First Name</label> <input type="text" name="firstname"
				class="form-control" />
		</div>
		<div class="form-group">
			<label>Last Name</label> <input type="text" name="lastname"
				class="form-control" />
		</div>
		<div class="form-group">
			<label>E-Mail</label> <input type="text" name="mail"
				class="form-control" />
		</div>
		<div class="form-group">
			<label>Password</label> <input type="password" name="pwd"
				class="form-control" />
		</div>
		<div class="form-group">
			<label>Confirm Password</label> <input type="password" name="pwd-1"
				class="form-control" />
		</div>
		<div class="form-group">
			<input class="btn btn-success" type="submit" value="Go!" />
		</div>

	</form>
</div>
<%@include file="../common/footer.jspf"%>