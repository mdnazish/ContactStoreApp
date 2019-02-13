<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}">
</c:set>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="jquery" value="/resources/jquery" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Contact Store - ${title}</title>

<script>
	window.menu = '${title}';

	/* window.contextRoot = '${contextRoot}'; */
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/contact-store.css" rel="stylesheet">

<!-- Theme - Business Tycon -->
<link href="${css}/bootstrap4-business-tycoon.css" rel="stylesheet">

<!-- Font Awesome Icons -->
<link href="${css}/font-awesome-5.7.1.css" rel="stylesheet">



</head>

<body id="page-top">

	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Contect | Main Content -->
		<div class="content">
			<!-- Load only when user click on Home -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load only when user click on Register -->
			<c:if test="${userClickRegister == true }">
				<%@include file="signup.jsp"%>
			</c:if>
			
			<!-- Load only when logged in as admin -->
			<c:if test="${adminLoggedin == true }">
				<%@include file="dashboard_admin.jsp"%>
			</c:if>
			
			<!-- Load only when logged in as user -->
			<c:if test="${userLoggedin == true }">
				<%@include file="dashboard_user.jsp"%>
			</c:if>

		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${jquery}/jquery.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>

		<!-- Plugin JavaScript -->
		<script src="${jquery}/jquery.easing.min.js"></script>

		<!-- Custom JavaScript for this theme -->
		<script src="${js}/contact-store.js"></script>
	</div>

</body>

</html>
