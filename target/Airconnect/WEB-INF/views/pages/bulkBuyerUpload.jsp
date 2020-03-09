<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="static/test/jquery.min.js"></script>
<style>
.required:after {
	content: " *";
	color: red;
}
</style>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">

					<h1 class="m-0 text-dark">Bulk Buyer Upload</h1>

				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Material Buyers</li>
						<li class="breadcrumb-item active">Bulk Buyer Upload</li>
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
			<div class="card card-default">
				<div class="card-header">
					<h3 class="card-title">Bulk Upload</h3>
				</div>
				<!-- /.card-header -->
				<div class="card-body">

					<h1>Spring 4 MVC - File Upload Example</h1>

					<form method="post"
						action='upload?${_csrf.parameterName}=${_csrf.token}'
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="file1">File Input 1</label> <input type="file"
								name="file" id="file1">
						</div>
						<div class="form-group">
							<label for="file2">File Input 2</label> <input type="file"
								name="file" id="file2">
						</div>
						<button type="submit" class="btn btn-success">Submit</button>
					</form>

				</div>
				<!-- /.card-body -->
			</div>

			<c:if test="${bulkBuyers != null}">


				<div class="card card-default">
					<div class="card-header">
						<h3 class="card-title">Bulk Upload</h3>
					</div>
					<!-- /.card-header -->
					<div class="card-body">

						<div class="table-responsive-md">
							<table id="buyers"
								class="table table-hover table-striped table-bordered">
								<thead>
									<tr>
										<th>Airline</th>
										<th>Name</th>
										<th>Designation</th>
										<th>Phone</th>
										<th>Mobile</th>
										<th>Email</th>
										<th>Fax</th>
										<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
											<th width="100"></th>
										</sec:authorize>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${bulkBuyers}" var="buyer">
										<tr>
											<td>${buyer.airline.airlineName}</td>
											<td>${buyer.buyerName}</td>
											<td>${buyer.designation}</td>
											<td>${buyer.phone}</td>
											<td>${buyer.mobile}</td>
											<td>${buyer.email}</td>
											<td>${buyer.fax}</td>

											<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
												<td class="text-center"><a
													href="<c:url value='/edit-buyer-${buyer.id}' />"
													class="btn btn-success custom-width"><i
														class="fas fa-edit"></i></a> <sec:authorize
														access="hasRole('ADMIN')">
														<a href="<c:url value='/delete-buyer-${buyer.id}' />"
															class="btn btn-danger custom-width"><i
															class="fas fa-trash-alt"></i></a>
													</sec:authorize></td>
											</sec:authorize>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
					<!-- /.card-body -->
				</div>
			</c:if>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content -->
</div>
