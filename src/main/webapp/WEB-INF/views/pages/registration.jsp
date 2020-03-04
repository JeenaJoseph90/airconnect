<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">User Registration Form</div>
		<div class="panel-body">
			<form:form method="POST" modelAttribute="user"
				class="form-horizontal">
				<form:input type="hidden" path="id" id="id" />

				<div class="row">
					<div class="form-group col-md-8">
						<label class="col-md-3 control-lable" for="firstName">First
							Name</label>
						<div class="col-md-7">
							<form:input type="text" path="firstName" id="firstName"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="firstName" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-8">
						<label class="col-md-3 control-lable" for="lastName">Last
							Name</label>
						<div class="col-md-7">
							<form:input type="text" path="lastName" id="lastName"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="lastName" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-8">
						<label class="col-md-3 control-lable" for="ssoId">SSO ID</label>
						<div class="col-md-7">
							<c:choose>
								<c:when test="${edit}">
									<form:input type="text" path="ssoId" id="ssoId"
										class="form-control input-sm" disabled="true" />
								</c:when>
								<c:otherwise>
									<form:input type="text" path="ssoId" id="ssoId"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="ssoId" class="help-inline" />
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-8">
						<label class="col-md-3 control-lable" for="password">Password</label>
						<div class="col-md-7">
							<form:input type="password" path="password" id="password"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="password" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-8">
						<label class="col-md-3 control-lable" for="email">Email</label>
						<div class="col-md-7">
							<form:input type="text" path="email" id="email"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="email" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-8">
						<label class="col-md-3 control-lable" for="userProfiles">Roles</label>
						<div class="col-md-7">
							<form:select path="userProfiles" items="${roles}" multiple="true"
								itemValue="id" itemLabel="type" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="userProfiles" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-8">
						<div class="col-md-5"  style="float: right">
							<c:choose>
								<c:when test="${edit}">
									<input type="submit" value="Update" class="btn btn-primary" />  <a
										href="<c:url value='/list' />" class="btn btn-danger">Cancel</a>
								</c:when>
								<c:otherwise>
									<input type="submit" value="Register" class="btn btn-primary" />  <a
										href="<c:url value='/list' />" class="btn btn-danger">Cancel</a>
								</c:otherwise>
							</c:choose>
					</div></div>
				</div>
			</form:form>
		</div>
	</div>
</div>