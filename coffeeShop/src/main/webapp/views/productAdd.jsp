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
		<h1>Add a new product</h1>
		<a href="<c:url value="/logout" />"> LogOut </a> 
		<br> 
		
		
		<form action="/product/create" method="post">
		
		
		<p>Product Name: <input type="text" name="productName"></p>
		<p>Description: <textArea rows="20" cols="30" name="description"></textArea></p>
		<p>Price $: <input type="text" name="price"></p>
		<p>Product Type: <input type="text" name="productType" ></p>
		<p> <input type="submit" value="Create Product"></p>
		
		</form>
 		
		
		
		
		
		<a href="<c:url value="/products/manage" />"> Back </a>
		
</body>
</html>