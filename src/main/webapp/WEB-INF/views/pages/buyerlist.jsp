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
					<h1 class="m-0 text-dark">Material Buyer</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Material Buyer</li>
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
				<div class="card">
					<!-- Default panel contents -->
					<div class="card-header">List of Material Buyers</div>
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
										<sec:authorize access="hasRole('ADMIN')">
											<th width="100"></th>
										</sec:authorize>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${buyers}" var="buyer">
										<tr>
											<td>${buyer.airline.airlineName}</td>
											<td>${buyer.buyerName}</td>
											<td>${buyer.designation}</td>
											<td>${buyer.phone}</td>
											<td>${buyer.mobile}</td>
											<td>${buyer.email}</td>
											<td>${buyer.fax}</td>

											<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
												<td><a href="<c:url value='/edit-buyer-${buyer.id}' />"
													class="btn btn-success custom-width">edit</a></td>
											</sec:authorize>
											<sec:authorize access="hasRole('ADMIN')">
												<td><a
													href="<c:url value='/delete-buyer-${buyer.id}' />"
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
  $(function () {
    $('#buyers').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": true,
      "ordering": true,
      "info": true,
      "autoWidth": true,
      "dom": 'Bfrtip',
      "buttons": [
          'copyHtml5',
          'excelHtml5',
          'csvHtml5',
          'pdfHtml5'
      ]
    });
  });
</script>