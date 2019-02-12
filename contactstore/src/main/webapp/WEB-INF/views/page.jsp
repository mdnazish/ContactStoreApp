<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}">
</c:set>
<sf:url var="css" value="/resources/css" />
<sf:url var="js" value="/resources/js" />
<sf:url var="images" value="/resources/images" />
<sf:url var="jquery" value="/resources/jquery" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Contact Store - ${title}</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/contact-store.css" rel="stylesheet">

</head>

<body id="page-top">

	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>
		<div class="content">
			<!-- Page Contect | Main Content -->
			
			<!-- Load only when user click on Home -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load only when user click on Login -->
			<c:if test="${userClickLogin == true }">
				<%@include file="login.jsp"%>
			</c:if>
			
			<!-- Load only when user click on Register -->
			<c:if test="${userClickRegister == true }">
				<%@include file="signup.jsp"%>
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
