<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adminstration CRM</title>
</head>
<body>
	<h1>Admin </h1>


	<a href="<c:url value="/products/list" />">List of Products</a>
	<br>
	<a href="<c:url value="/product/create" />">Create Product</a>
	<br>
	<a href="<c:url value="/product/remove" />">Remove Product</a>
	<br>
	<br>
	<a href="<c:url value="/product/remove" />">Person Management</a>
	<br>
	<br>
	<a href="<c:url value="/product/remove" />">List Person</a>

	<br>
	<br>
	<a href="<c:url value="/admin" />"> Back </a>

</body>
</html>