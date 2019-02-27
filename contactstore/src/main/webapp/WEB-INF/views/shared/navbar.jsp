<!-- Case: 1 -->
<!-- User is not yet Logged in : Guest Menu -->
<c:if test="${sessionScope.userId == null}">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<div class="container-fluid">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">Contact
				Store</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse " id="navbarResponsive">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item home"><a
						class="nav-link js-scroll-trigger" href="${contextRoot}/home">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item aboutUs"><a
						class="nav-link js-scroll-trigger" href="#about">About Us</a></li>
					<li class="nav-item contactUs"><a
						class="nav-link js-scroll-trigger" href="#contact">Contact Us</a>
					</li>
				</ul>
				<ul class="navbar-nav navbar-right">
					<li class="nav-item login"><a class="nav-link"
						href="${contextRoot}/login">Login</a></li>
					<li class="nav-item register"><a class="nav-link"
						href="${contextRoot}/signup">Register</a></li>
				</ul>

			</div>
		</div>
	</nav>
</c:if>

<!-- Case: 2 -->
<!-- Admin is Logged in : Admin Menu -->
<c:if test="${sessionScope.userId != null && sessionScope.role == 1}">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<div class="container-fluid">
			<a class="navbar-brand js-scroll-trigger" href="${contextRoot}/home">Contact
				Store</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse " id="navbarResponsive">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item userList"><a
						class="nav-link" href="${contextRoot}/admin/user/list">User List</a></li>
				</ul>
				<ul class="navbar-nav navbar-right">
					<li class="nav-item dropdown no-arrow"><a
						class="nav-link dropdown-toggle" href="#" id="userDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <i class="fas fa-user-circle fa-fw">
						</i> Admin
					</a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="userDropdown">
							<a class="dropdown-item" href="#">Profile</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="${contextRoot}/logout"
								data-toggle="modal" data-target="#logoutModal">Logout</a>
						</div></li>
				</ul>
			</div>
		</div>
	</nav>
</c:if>

<!-- Case: 3 -->
<!-- General User is Logged in : User Menu -->
<c:if test="${sessionScope.userId != null && sessionScope.role == 2}">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<div class="container-fluid">
			<a class="navbar-brand js-scroll-trigger" href="${contextRoot}/home">Contact
				Store</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse " id="navbarResponsive">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item addContact"><a
						class="nav-link" href="${contextRoot}/user/add/contact">Add
							Contact</a></li>
					<li class="nav-item contactList"><a
						class="nav-link" href="${contextRoot}/user/contact/list">Contact
							List</a></li>
				</ul>
				<ul class="navbar-nav navbar-right">
					<li class="nav-item dropdown no-arrow"><a
						class="nav-link dropdown-toggle" href="#" id="userDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <i class="fas fa-user-circle fa-fw">
						</i> User
					</a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="userDropdown">
							<a class="dropdown-item" href="#">Profile</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="${contextRoot}/logout"
								data-toggle="modal" data-target="#logoutModal">Logout</a>
						</div></li>
				</ul>
			</div>
		</div>
	</nav>
</c:if>

<!-- Logout Modal Dailog Box-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">�</span>
				</button>
			</div>
			<div class="modal-body">Select "Logout" below if you are ready
				to end your current session.</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
				<a class="btn btn-primary" href="${contextRoot}/logout">Logout</a>
			</div>
		</div>
	</div>
</div>