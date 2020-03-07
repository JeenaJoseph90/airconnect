<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="static/test/jquery.min.js"></script>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
				<c:choose>
							<c:when test="${edit}">
							<h1 class="m-0 text-dark">Edit User</h1>
						</c:when>
							<c:otherwise>
							<h1 class="m-0 text-dark">Add New User</h1>
						</c:otherwise>
						</c:choose>
					
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Users</li>
						<li class="breadcrumb-item active">Add New User</li>
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
					<h3 class="card-title">
						User
						<c:choose>
							<c:when test="${edit}">
							Update
						</c:when>
							<c:otherwise>
							Registration
						</c:otherwise>
						</c:choose>
						Form
					</h3>
				</div>
				<!-- /.card-header -->
				<div class="card-body">
					<form:form method="POST" modelAttribute="user"
						class="form-horizontal" id="regForm">

						<form:input type="hidden" path="id" id="id" />
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="firstName">First Name</label>
									<form:input type="text" path="firstName" id="firstName"
										class="form-control" />
									<div class="has-error">
										<form:errors path="firstName" class="help-inline" />
									</div>
								</div>
								<!-- /.form-group -->
								<div class="form-group">
									<label for="ssoId">SSO ID</label>
									<c:choose>
										<c:when test="${edit}">
											<form:input type="text" path="ssoId" id="ssoId"
												class="form-control" disabled="true" />
										</c:when>
										<c:otherwise>
											<form:input type="text" path="ssoId" id="ssoId"
												class="form-control" />
											<div class="has-error">
												<form:errors path="ssoId" class="help-inline" />
											</div>
										</c:otherwise>
									</c:choose>
								</div>
								<div class="form-group">
									<label for="email">Email</label>
									<form:input type="text" path="email" id="email"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="email" class="help-inline" />
									</div>
								</div>
								<!-- /.form-group -->
							</div>
							<!-- /.col -->
							<div class="col-md-6">
								<div class="form-group">
									<label for="lastName">Last Name</label>
									<form:input type="text" path="lastName" id="lastName"
										class="form-control" />
									<div class="has-error">
										<form:errors path="lastName" class="help-inline" />
									</div>
								</div>
								<!-- /.form-group -->
								<div class="form-group">
									<label for="password">Password</label>
									<form:input type="password" path="password" id="password"
										class="form-control" />
									<div class="has-error">
										<form:errors path="password" class="help-inline" />
									</div>
								</div>

								<div class="form-group">
									<label for="userProfiles">Roles</label>
									<form:select path="userProfiles" items="${roles}"
										multiple="true" itemValue="id" itemLabel="type"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="userProfiles" class="help-inline" />
									</div>
								</div>
								<div class="form-group float-right pt-4">
									<c:choose>
										<c:when test="${edit}">
											<input type="submit" value="Update" class="btn btn-primary" />
											<a href="<c:url value='/users' />" class="btn btn-danger">Cancel</a>
										</c:when>
										<c:otherwise>
											<input type="submit" value="Register" class="btn btn-primary" />
											<a href="<c:url value='/users' />" class="btn btn-danger">Cancel</a>
										</c:otherwise>
									</c:choose>
								</div>
								<!-- /.form-group -->
							</div>
							<!-- /.col -->
						</div>



					</form:form>

					<!-- /.row -->


				</div>
				<!-- /.card-body -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content -->
</div>
