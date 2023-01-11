

	<%@ include file="common/header.jspf" %>
	<div class="container">
		<%@ include file="common/navigation.jspf" %>	
			<h1>Welcome Back! ${username}</h1>
		<hr>
			<div>
				<h2>Your Todos</h2>
				<table class="table">
					<thead>
						<tr>
							
							<th>Description</th>
							<th>Target Date</th>
							<th>Completed?</th>
						</tr>
					</thead>
					<tbody>		
						<c:forEach items="${todos}" var="todo">
							<tr>
								
								<td>${todo.description}</td>
								<td>${todo.targetDate}</td>
								<td>${todo.isCompleted}</td>
								<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
								<td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="add-todo" class="btn btn-success">Add To Do</a>
	
			</div>
		</div>
		<%@ include file="common/footer.jspf" %>