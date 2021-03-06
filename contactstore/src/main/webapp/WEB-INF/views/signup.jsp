<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container-fluid">
	<!-- This will be displayed if Login username is Wrong -->
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
	<!-- AJAX call to check login name availability -->
	<script type="text/javascript">
		$(document).ready(function(){
			$('#check_available').click(function(){
				$.ajax({
					url:'check_available',
					data: {username:$('#id_username').val()},
					success: function(data){
						$('#id_response').html(data);
					}
				});
			});
		});
		
	</script>
	<div class="row my-4">
		<div class="card-group col-md-12 ">
			<div class="card shadow col-md-7 text-white">
				<div class="card-body card-img-left">
					<!-- place background image here -->
					<img alt="" src="${images}/register.jpg"
						style="width: 100%; height: 100%;">
				</div>
			</div>
			<div class="card shadow col-md-5">
				<div class="card-body">
					<a href="${contextRoot}/login"
						class="float-right btn btn-outline-primary mt-1">Log in</a>
					<h4 class="card-title mt-2">Sign up</h4>
					<hr>
					<!-- Spring Form Element -->
					<sf:form action="${contextRoot}/register"
						modelAttribute="userCommand" method="POST">
						<div class=" form-group row">
							<label class="col-form-label col-sm-3">Name </label>
							<div class="col-sm-9">
								<sf:input type="text" path="user.name" class="form-control" />
							</div>
						</div>
						<div class=" form-group row">
							<label class="col-form-label col-sm-3">Phone </label>
							<div class="col-sm-9">
								<sf:input type="text" path="user.phone" class="form-control" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-sm-3">Email </label>
							<div class="col-sm-9">
								<sf:input type="email" path="user.email" class="form-control"
									placeholder="abc@xyz.com" />
							</div>
						</div>
						<div class=" form-group row">
							<label class="col-form-label col-sm-3">Address </label>
							<div class="col-sm-9">
								<sf:textarea path="user.address" class="form-control" />
							</div>
						</div>
						<div class=" form-group row">
							<label class="col-form-label col-sm-3">Login Name </label>
							<div class="col-sm-9">
								<sf:input id="id_username" type="text" path="user.loginName" class="form-control"
									placeholder="Enter your login username" />
									<span id="id_response" class="mt-1 text-info"></span>
									<button id="check_available" type="button" class="float-right btn btn-sm btn-outline-dark mt-1 fa fa-user-check"> 
									   Check Availablity
									</button>
							</div>
						</div>
						<div class=" form-group row">
							<label class="col-form-label col-sm-3">Password </label>
							<div class="col-sm-9">
								<sf:input type="password" path="user.password"
									class="form-control" placeholder="************" />
							</div>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-block">
								Register</button>
						</div>
						<!-- form-group// -->
						<small class="text-muted">By clicking the 'Register'
							button, you confirm that you accept our <br> Terms of use
							and Privacy Policy.
						</small>
					</sf:form>
				</div>
				<!-- card-body end .// -->
				<div class="card-footer text-center">
					Have an account? <a href="${contextRoot}/login">Log In</a>
				</div>

			</div>
			<!-- card.// -->
		</div>
		<!-- col.//-->

	</div>
	<!-- row.//-->

</div>
<!-- cord-group.// -->
