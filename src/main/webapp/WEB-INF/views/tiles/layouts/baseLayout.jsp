<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>Airconnect</title>

<!-- Font Awesome Icons -->
<link rel="stylesheet" href="static/test/all.min.css">
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="static/test/dataTables.bootstrap4.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.dataTables.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="static/test/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">

</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

		<!-- Navbar -->
		<tiles:insertAttribute name="header" />
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<tiles:insertAttribute name="navbar" />


		<!-- Content Wrapper. Contains page content -->
		<tiles:insertAttribute name="content" />
		<!-- /.content-wrapper -->

		<!-- Control Sidebar -->
		<tiles:insertAttribute name="sidebar" />
		<!-- /.control-sidebar -->

		<!-- Main Footer -->
		<tiles:insertAttribute name="footer" />

	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED SCRIPTS -->

	<!-- jQuery -->
	
	<!-- Bootstrap 4 -->
	<script src="static/test/bootstrap.bundle.min.js"></script>
		<script src="static/test/jquery.dataTables.js"></script>
	<script src="static/test/dataTables.bootstrap4.js"></script>
		<script
		src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
	<script
		src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.html5.min.js"></script>
	<!-- AdminLTE App -->
	<script src="static/test/adminlte.min.js"></script>



</body>
</html>
