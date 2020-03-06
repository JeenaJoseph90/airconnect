<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="static/test/jquery.min.js"></script>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0 text-dark">Users</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Users</li>
						<li class="breadcrumb-item active">Users</li>
					</ol>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->

	<!-- Main content -->
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="card w-100">
					<!-- Default panel contents -->
					<div class="card-header">List of Users</div>
					<div class="card-body">
						<c:if test="${param.success != null}">
							<div class="alert alert-success alert-dismissible fade show"
								role="alert">
								<h5>${param.success}</h5>
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
						</c:if>
						<div class="table-responsive-lg">
							<table id="users"
								class="table table-hover table-striped table-bordered">
								<thead>
									<tr>
										<th>Firstname</th>
										<th>Lastname</th>
										<th>Email</th>
										<th>SSO ID</th>
										<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
											<th width="100"></th>
										</sec:authorize>
										<sec:authorize access="hasRole('ADMIN')">
											<th width="100"></th>
										</sec:authorize>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${users}" var="user">
										<tr>
											<td>${user.firstName}</td>
											<td>${user.lastName}</td>
											<td>${user.email}</td>
											<td>${user.ssoId}</td>
											<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
												<td><a
													href="<c:url value='/edit-user-${user.ssoId}' />"
													class="btn btn-success custom-width">edit</a></td>
											</sec:authorize>
											<sec:authorize access="hasRole('ADMIN')">
												<td><a
													href="<c:url value='/delete-user-${user.ssoId}' />"
													class="btn btn-danger custom-width">delete</a></td>
											</sec:authorize>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content -->
</div>
<script type="text/javascript">
	$(function() {
		$('#users').DataTable({
			"paging" : true,
			"lengthChange" : true,
			"searching" : true,
			"ordering" : true,
			"info" : true,
			"autoWidth" : false,
			"dom" : 'Bfrtip',
			"buttons" : [ 'copyHtml5', 'excelHtml5', 'csvHtml5', 'pdfHtml5' ]
		});
	});
</script>