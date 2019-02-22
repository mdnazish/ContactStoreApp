
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container-fluid">
	<!-- This will be displayed if Login Credentials are Wrong -->
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

	<!--  This will be displayed when admin/user click(performed) logout -->
	<!-- Case 2: using 'action' parameter which is associated with "redirect:login?action=logout" in PageController logout(-) method-->
	<c:if test="${param.action eq 'logout'}">
		<div class="row my-4">
			<div class="col-md-12">
				<div class="alert alert-success text-center">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Logout
						Successfully! Thanks For Using Contact Store Applicatiion.</strong>
				</div>
			</div>
		</div>
	</c:if>
	<!--  This will be displayed when user register via Sign Up Page -->
	<c:if test="${param.action eq 'register'}">
		<div class="row my-4">
			<div class="col-md-12">
				<div class="alert alert-success alert-dismissible text-center">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>User
						Registered Successfully! Please Login Here.</strong>
				</div>
			</div>
		</div>
	</c:if>

	<div class="row my-4">
		<div class="card-group col-md-12">
			<div class="card shadow col-md-8 ">
				<div class="card-body bg-dark card-img-left">
				<!-- background image here -->
				</div>
			</div>
			<div class="card shadow col-md-4">
				<div class="card-body" >
					<a href="${contextRoot}/signup"
						class="float-right btn btn-outline-primary">Sign up</a>
					<h4 class="card-title mb-4 mt-2">Sign in</h4>
					<p>
						<a href="" class="btn btn-block btn-outline-primary"> <i
							class="fab fa-facebook-f"></i>   Login via facebook
						</a>
					</p>
					<hr>
					<p>Please Enter Username and Password.</p>
					<!-- Spring Form Element -->
					<sf:form action="${contextRoot}/login"
						modelAttribute="loginCommand" method="POST">
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-user"></i>
									</span>
								</div>
								<sf:input name="loginName" path="loginName" class="form-control"
									placeholder="Enter Login Name" />
							</div>
							<!-- input-group.// -->
						</div>
						<!-- form-group// -->
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-lock"></i>
									</span>
								</div>
								<sf:input name="password" path="password" class="form-control"
									placeholder="******" type="password" />
							</div>
							<!-- input-group.// -->
						</div>
						<!-- form-group// -->
						<div class="form-group">
							<div class="checkbox">
								<label> <input type="checkbox"> Save password
								</label>
							</div>
							<!-- checkbox .// -->
						</div>
						<!-- form-group// -->
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<button type="submit" class="btn btn-primary btn-block">Login</button>
								</div>
								<!-- form-group// -->
							</div>
							<div class="col-md-6 text-right">
								<a class="small" href="#">Forgot password?</a>
							</div>
						</div>
						<!-- row -->
					</sf:form>
				</div>
			</div>
			<!-- card -->
		</div>
		<!-- cord-group -->

	</div>
	<!-- row -->

</div>
<!--container end-->
