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
			<c:if test="${bulkBuyers.buyerList == null}">
				<div class="card card-default">
					<div class="card-header">
						<h3 class="card-title">Bulk Upload</h3>
					</div>
					<!-- /.card-header -->
					<div class="card-body">



						<form method="post"
							action='upload?${_csrf.parameterName}=${_csrf.token}'
							enctype="multipart/form-data">
							<div class="row">
								<div class="col-md-8">
									<div class="form-group float-right">
										<label for="file1" class="pr-4">Upload Buyers List</label> <input
											type="file" name="file" id="file1" class="btn btn-info">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<button type="submit" class="btn btn-success float-right">Upload</button>
									</div>
								</div>
							</div>

						</form>


					</div>
					<!-- /.card-body -->
				</div>
			</c:if>

			<c:if test="${bulkBuyers.buyerList != null}">
				<div class="card card-default">
					<div class="card-header">
						<h3 class="card-title">Bulk Upload</h3>
					</div>
					<!-- /.card-header -->
					<div class="card-body">
						<c:if test="${warning != null}">
							<div class="alert alert-warning alert-dismissible fade show"
								role="alert">
								<h5>${warning}</h5>
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
						</c:if>

						<form:form method="post"
							action="saveBulkBuyers?${_csrf.parameterName}=${_csrf.token}"
							modelAttribute="bulkBuyers">
							<div class="table-responsive-md overflow-auto">
								<table id="buyers"
									class="table table-hover table-striped table-bordered">
									<thead>
										<tr>
											<th>No.</th>
											<th>Airline</th>
											<th>Name</th>
											<th>Designation</th>
											<th>Phone</th>
											<th>Mobile</th>
											<th>Email</th>
											<th>Fax</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${bulkBuyers.buyerList}" var="buyer"
											varStatus="status">
											<tr>
												<td align="center">${status.count}</td>
												<td><c:if test="${warning != null}">
														<input
															name="buyerList[${status.index}].airline.airlineName"
															value="${buyer.airline.airlineName}" class="text-danger" />
													</c:if> <c:if test="${warning == null}">
														<input
															name="buyerList[${status.index}].airline.airlineName"
															value="${buyer.airline.airlineName}" />
													</c:if></td>
												<td><input name="buyerList[${status.index}].buyerName"
													value="${buyer.buyerName}" /></td>
												<td><input
													name="buyerList[${status.index}].designation"
													value="${buyer.designation}" /></td>
												<td><input name="buyerList[${status.index}].phone"
													value="${buyer.phone}" /></td>
												<td><input name="buyerList[${status.index}].mobile"
													value="${buyer.mobile}" /></td>
												<td><input name="buyerList[${status.index}].email"
													value="${buyer.email}" /></td>
												<td><input name="buyerList[${status.index}].fax"
													value="${buyer.fax}" /></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<br />
							<input type="submit" value="Submit"
								class="btn btn-success float-right" />

						</form:form>
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

<script type="text/javascript">
	$(function() {
		$('#buyers').DataTable({
			"paging" : true,
			"lengthChange" : false,
			"info" : true,
			"autoWidth" : true,
		});
	});
</script>
