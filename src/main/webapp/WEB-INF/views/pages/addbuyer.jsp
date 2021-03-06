<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="static/test/jquery.min.js"></script>
<style>

  .required:after {
    content:" *";
    color: red;
  }
</style>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<c:choose>
						<c:when test="${edit}">
							<h1 class="m-0 text-dark">Edit Buyer</h1>
						</c:when>
						<c:otherwise>
							<h1 class="m-0 text-dark">Add New Buyer</h1>
						</c:otherwise>
					</c:choose>

				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Buyer</li>
						<li class="breadcrumb-item active">Add New Buyer</li>
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
						Buyer
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
					<form:form method="POST" modelAttribute="buyer"
						class="form-horizontal" id="regForm">

						<form:input type="hidden" path="id" id="id" />
						<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="country" class="required">Country</label>
									<form:select path="airline.country.id" id="country" 
										class="form-control input-sm">
										<form:option value="0" label="Select Country"></form:option>
										</form:select>
									<div class="has-error">
										<form:errors path="airline.country.id" class="help-inline" />
									</div>
								</div>
								<div class="form-group">
									<label for="buyerName" class="required">Buyer Name</label>
									<form:input type="text" path="buyerName" id="buyerName"
										class="form-control" />
									<div class="has-error">
										<form:errors path="buyerName" class="text-danger font-weight-bold" />
									</div>
								</div>
								<!-- /.form-group -->
								<div class="form-group">
									<label for="designation">Designation</label>
									<form:input type="text" path="designation" id="designation"
										class="form-control" />
									<div class="has-error">
										<form:errors path="designation" class="help-inline" />
									</div>

								</div>
								
								<div class="form-group">
									<label for="phone">Phone</label>
									<form:input type="text" path="phone" id="phone"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="phone" class="help-inline" />
									</div>
								</div>
								<!-- /.form-group -->
							</div>
							<!-- /.col -->
							<div class="col-md-6">
								 <div class="form-group">
									<label for="airline" class="required">Airline</label>
									<form:select path="airline.id" id="airline"
										class="form-control input-sm">
										<form:option value="0" label="Select Airline"></form:option>
									</form:select>
									<div class="has-error">
										<form:errors path="airline.id" class="text-danger font-weight-bold" />
									</div>
								</div>

								<!-- /.form-group -->
								
								<div class="form-group">
									<label for="email">Email</label>
									<form:input type="text" path="email" id="email"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="email" class="text-danger font-weight-bold" />
									</div>
								</div>
								
								<div class="form-group">
									<label for="mobile">Mobile</label>
									<form:input type="mobile" path="mobile" id="mobile"
										class="form-control" />
									<div class="has-error">
										<form:errors path="mobile" class="help-inline" />
									</div>
								</div>
								<div class="form-group">
									<label for="fax">Fax</label>
									<form:input type="fax" path="fax" id="mobifaxle"
										class="form-control" />
									<div class="has-error">
										<form:errors path="fax" class="help-inline" />
									</div>
								</div>

								<div class="form-group float-right pt-4">
									<c:choose>
										<c:when test="${edit}">
											<input type="submit" value="Update" class="btn btn-primary" />
											<a href="<c:url value='/buyers' />" class="btn btn-danger">Cancel</a>
										</c:when>
										<c:otherwise>
											<input type="submit" value="Register" class="btn btn-primary" />
											<a href="<c:url value='/buyers' />" class="btn btn-danger">Cancel</a>
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

<script type="text/javascript">
$(document).ready(function(){
		
		var csrfParameter = '${_csrf.parameterName}';
    	var csrfToken = '${_csrf.token}';
    	var mode = '${edit}';
    	var ctryId = '${ctryId}';
    	var airId = '${airId}';
    	
    	getAllCountries();
    	
    	function getAllCountries() {
    		var jsonParams = {};
			jsonParams[csrfParameter] = csrfToken;
			$.ajax({
				type: "GET",
	            url: "${pageContext.request.contextPath}/getAllCountries",
	            data: jsonParams,
				success: function(data){
	                $.each(data, function(i, d) {
	                	if(mode == "true" && ctryId == d.key) {
	                		$('#country').append('<option selected value="' + d.key + '">' + d.value + '</option>');
	                		getAirlineByCountryId();
	                	} else
	                    	$('#country').append('<option value="' + d.key + '">' + d.value + '</option>');
	                });
				}
			});
    	}
    	
	   $("#country").change(function(){ 
		   getAirlineByCountryId();
	   });
	   
	   function getAirlineByCountryId() {
		   
		   var selectedCountry = $("#country option:selected").val();
			if(selectedCountry == 0) {
				$('#airline').empty();
				$('#airline').append(new Option("Select Airline", "0"));
				return;
			}
			var jsonParams = {};
			jsonParams['countryId'] = selectedCountry;
			jsonParams[csrfParameter] = csrfToken;
			$.ajax({
				type: "GET",
	            url: "${pageContext.request.contextPath}/getAirlineByCountryId",
	            data: jsonParams,
				success: function(data){
	                $('#airline').empty();
	                $.each(data, function(i, d) {
	                	if(mode == "true" && airId == d.key) {
	                		$('#airline').append('<option selected value="' + d.key + '">' + d.value + '</option>');
	                	} else
	                		$('#airline').append('<option value="' + d.key + '">' + d.value + '</option>');
	                });
				}
			});
	   }
	});
</script>
