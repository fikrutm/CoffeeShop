<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Detail</title>
</head>
<body>

	<strong>Order : </strong>${order.number }
	<br>
	<Strong>Date :</Strong> ${order.date }
	<strong>${customer.firstname}</strong>
	<br>

	<br />

</body>
</html>