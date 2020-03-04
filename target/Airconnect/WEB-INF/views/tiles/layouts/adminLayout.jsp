<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link href="<c:url value='/static/css/bootstrap.min.css' />"
	rel="stylesheet" />
	<!-- Custom styles for this template -->
<link href="<c:url value='/static/css/simple-sidebar.css' />"
	rel="stylesheet"></link>
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />

<title>Simple Sidebar - Start Bootstrap Template</title>

<!-- Bootstrap core JavaScript -->
<script src="<c:url value='/static/js/jquery.min.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.bundle.min.js' />"></script>

</head>

<body>

	<div class="d-flex" id="wrapper">


		<!-- Sidebar -->
		<tiles:insertAttribute name="navbar" />

		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">

			<tiles:insertAttribute name="header" />


			<div class="container-fluid">
				<h6 class="mt-4"></h6>
				<tiles:insertAttribute name="content" />

			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>

</body>

</html>
