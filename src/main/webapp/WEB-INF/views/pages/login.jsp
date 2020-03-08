<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<script src="static/js/jquery.min.js"></script>
<c:url var="loginUrl" value="/login" />
<form class="login100-form validate-form" action="${loginUrl}"
	method="post">
	<span class="login100-form-title pb-4 pt-4"> Login to continue </span>
	<c:if test="${param.error != null}">
		<div class="alert alert-danger">
			<p>Invalid username and password.</p>
		</div>
	</c:if>
	<c:if test="${param.logout != null}">
		<div class="alert alert-success">
			<p>You have been logged out successfully.</p>
		</div>
	</c:if>


	<div class="wrap-input100">
		<input class="input100" type="text" id="username" name="ssoId" required> <span
			class="focus-input100"></span> <span class="label-input100"><i
			class="fa fa-user pr-2"></i>UserName</span>
	</div>
	
	<div class="wrap-input100">
		<input class="input100" type="password" id="password" name="password" required> <span
			class="focus-input100"></span> <span class="label-input100"><i
							class="fa fa-lock pr-2"></i>Password</span>
	</div>
	
	<div class="flex-sb-m w-full pt-3 pb-3">
		<div class="contact100-form-checkbox">
			<input class="input-checkbox100" type="checkbox" id="rememberme"
								name="remember-me"> <label class="label-checkbox100"
				for="rememberme"> Remember me </label>
		</div>
		
	</div>

	<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
						
	<div class="container-login100-form-btn">
		<input type="submit" class="login100-form-btn"
							value="Login">
	</div>

</form>
<script type="text/javascript">
$(document).ready(function(){
	   $('.input100').each(function(){
	        $(this).on('blur', function(){
	            if($(this).val().trim() != "") {
	                $(this).addClass('has-val');
	            }
	            else {
	                $(this).removeClass('has-val');
	            }
	        })    
	    });
	});
</script>