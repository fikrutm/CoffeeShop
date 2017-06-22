<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>You are in!</title>
</head>

		
		<h2>List of products Adds goes here</h2>
		<table>
		  <tr>
		  <td>Product Name</td>
		  <td>Product Type</td>
		  <td>Price</td>
		  <td>Description</td>
		 
		  </tr>
		  
		   <c:forEach var="product" items="${products}"> 
		  
		  <tr>
            <td>${product.productName}</td>
            <td>${product.productType}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>               

		  </tr>
		</c:forEach>
		</table>
		
</body>
</html>