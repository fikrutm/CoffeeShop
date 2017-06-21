
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products List</title>
</head>
<body>	
		<h1>Remove product</h1>
		<a href="<c:url value="/logout" />"> LogOut </a> 
		<br> 
		
		<form action="/product/remove" method="post">		
		<p>Enter Product Id:<input type="text" name="id"></p>		
		<input type="submit" value="Remove Product" >	
		</form>
		
		
		<a href="<c:url value="/products/manage" />"> Back </a>
</body>
</html>