<%@ include file="common/header.jspf" %>
		<div class="container">
			<%@ include file="common/navigation.jspf" %>	
			<h1>Enter Todo Details</h1>
			<form:form method="post" modelAttribute="todo">
			<fieldset class="mb-3">
				<form:label path="description">Description</form:label>
				<form:input type="text" required="required" path='description'/>
				<form:errors path='description'/>
			</fieldset>
			
			<fieldset class="mb-3">
				<form:label path="targetDate">Target Date</form:label>
				<form:input id="targetDate" type="text" name="targetDate" required="required" path='targetDate' placeholder="yyyy-mm-dd"/>
				<form:errors path='targetDate'/>
			</fieldset>
				<form:input type="hidden" path="id"/>
				<form:input type="hidden" path="isCompleted"/>
				<input type="submit" class="btn btn-success"/>
			
			</form:form>
			
		</div>
		
	<script type="text/javascript">
		$('#targetDate').datepicker({
		    format: 'yyyy-mm-dd'
		});
	</script>		
<%@ include file="common/footer.jspf" %>
