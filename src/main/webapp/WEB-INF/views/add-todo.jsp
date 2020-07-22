<%@include file="../common/header.jspf"%>
<%@include file="../common/navigation.jspf"%>


<div class="container">
	<H1>Add Todos</H1>
	<form action="/add-todo.do" method="post">
		<fieldset class="form-group">
			<label>Description</label> <input type="text" name="newtodo"
				class="form-control" />
		</fieldset>
		<fieldset class="form-group">
			<label>category</label> <input type="text" name="category"
				class="form-control" />
		</fieldset>

		<input type="submit" value="Add todo" class="btn btn-primary" />
	</form>
</div>
<%@include file="../common/footer.jspf"%>