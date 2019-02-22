<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<!-- This will be displayed if wrong data passed to DB -->
	<!-- Case 1: using 'error' attribute which is added in Model object of Spring f/w-->
	<c:if test="${not empty error}">
		<div class="row my-4">
			<div class="col-md-12">
				<div class="alert alert-danger text-center">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>
						${error} </strong>
				</div>
			</div>
		</div>
	</c:if>
	<div class="row my-4">
		<div class="card-group col-md-12 ">
			<div class="card shadow col-md-6" style="border-color: grey">
				<div class="card-body">
					<h4 class="card-title">Add New Contact</h4>
					<hr>
					<!-- Spring Form Element -->
					<sf:form action="${contextRoot}/user/save"
						modelAttribute="contactCommand">
						<div class=" form-group row">
							<label class="col-form-label col-sm-3">Name </label>
							<div class="col-sm-9">
								<sf:input type="text" path="name" class="form-control" />
							</div>
						</div>
						<div class=" form-group row">
							<label class="col-form-label col-sm-3">Phone </label>
							<div class="col-sm-9">
								<sf:input type="text" path="phone" class="form-control" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-sm-3">Email </label>
							<div class="col-sm-9">
								<sf:input type="email" path="email" class="form-control"
									placeholder="abc@xyz.com" />
							</div>
						</div>
						<div class=" form-group row">
							<label class="col-form-label col-sm-3">Address </label>
							<div class="col-sm-9">
								<sf:textarea path="address" class="form-control" />
							</div>
						</div>
						<div class=" form-group row">
							<label class="col-form-label col-sm-3">Remark </label>
							<div class="col-sm-9">
								<sf:input type="text" path="remark" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-block">
								Save</button>
						</div>
						<!-- form-group// -->
					</sf:form>
				</div>
			</div>
			<!-- card.// -->
		</div>
		<!-- col.//-->

	</div>
	<!-- row.//-->

</div>
<!-- cord-group.// -->
