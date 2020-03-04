<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="authbar">
	<h5><span>Signed in as &nbsp;<strong>${loggedinuser}</strong></span></h5>
	<a href="<c:url value="/logout"/>" class="btn btn-info">Logout</a>
</div>