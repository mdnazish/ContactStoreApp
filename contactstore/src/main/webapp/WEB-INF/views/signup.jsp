<div class="container-fluid">
	<div class="row my-4">

		<div class="card-group col-md-12 ">
			<div class="card shadow col-md-8 text-white">
				<div class=" card-body bg-dark card-img-left">
					<!-- Background image for card set in CSS! -->
				</div>
			</div>
			<div class="card shadow col-md-4">
				<div class="card-body">
					<a href="${contextRoot}/login" class="float-right btn btn-outline-primary mt-1">Log
						in</a>
					<h4 class="card-title mt-2">Sign up</h4>
					<form>
						<div class="form-row">
							<div class="col form-group">
								<label>First name </label> <input type="text"
									class="form-control" placeholder="">
							</div>
							<!-- form-group end.// -->
							<div class="col form-group">
								<label>Last name</label> <input type="text" class="form-control"
									placeholder=" ">
							</div>
							<!-- form-group end.// -->
						</div>
						<!-- form-row end.// -->
						<div class="form-group">
							<label>Email</label> <input type="email" class="form-control"
								placeholder="">
						</div>
						<!-- form-group end.// -->
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Address</label> <input type="text" class="form-control">
							</div>
							<!-- form-group end.// -->
							<div class="form-group col-md-6">
								<label>Country</label> <select id="inputState"
									class="form-control">
									<option>Choose...</option>
									<option>Uzbekistan</option>
									<option>Russia</option>
									<option selected="">India</option>
									<option>United State</option>
									<option>Afganistan</option>
								</select>
							</div>
							<!-- form-group end.// -->
						</div>
						<!-- form-row.// -->
						<div class="form-group">
							<label>Create password</label> <input class="form-control"
								type="password">
						</div>
						<!-- form-group end.// -->
						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-block">
								Register</button>
						</div>
						<!-- form-group// -->
						<small class="text-muted">By clicking the 'Register'
							button, you confirm that you accept our <br> Terms of use
							and Privacy Policy.
						</small>
					</form>
				</div>
				<!-- card-body end .// -->
				<div class="border-top card-footer text-center">Have an account? <a href="${contextRoot}/login">Log In</a></div>
				
			</div>
			<!-- card.// -->
		</div>
		<!-- col.//-->

	</div>
	<!-- row.//-->

</div>
<!-- cord-group.// -->
