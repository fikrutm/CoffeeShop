<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Addition Confirmation</title>
</head>
<body>
	<h1>Product Add Success</h1>
	<h2>${product.productName} is added successfully! }</h2>
	<br>
	<a href="<c:url value="/products/manage" />"> End </a>
</body>
</html>