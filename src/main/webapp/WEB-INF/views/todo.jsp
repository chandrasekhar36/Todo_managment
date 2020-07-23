<%@include file="../common/header.jspf"%>
<%@include file="../common/navigation.jspf"%>
<div class="container">
	<H1>Todos</H1>
	<b><p>Hey ${name}, you have following to catch up</p></b>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Category</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.category}</td>
					<td>${todo.name}</td>
					<td><a class="btn btn-danger"
						href="/delete-todo.do?id=${todo.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<ol>

	</ol>

	<p>
		<a href="/add-todo.do">Add todo Here</a>
	</p>
</div>
<%@include file="../common/footer.jspf"%>
