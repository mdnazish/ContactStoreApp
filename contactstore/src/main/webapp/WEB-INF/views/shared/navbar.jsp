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
						class="nav-link js-scroll-trigger" href="#userList">User List</a></li>
				</ul>
				<ul class="navbar-nav navbar-right">
					<li class="nav-item contactUs"><a
						class="nav-link js-scroll-trigger" href="#profile">Profile</a></li>
					<li class="nav-item login"><a class="nav-link"
						href="${contextRoot}/logout">Logout</a></li>
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
						class="nav-link js-scroll-trigger" href="#addContact">Add
							Contact</a></li>
					<li class="nav-item contactUs"><a
						class="nav-link js-scroll-trigger" href="#contactList">Contact
							List</a></li>
				</ul>
				<ul class="navbar-nav navbar-right">
					<li class="nav-item login"><a class="nav-link"
						href="$#profile">Profile</a></li>
					<li class="nav-item login"><a class="nav-link"
						href="${contextRoot}/logout">Logout</a></li>
				</ul>

			</div>
		</div>
	</nav>
</c:if>