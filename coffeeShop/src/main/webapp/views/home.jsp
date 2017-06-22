<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<%@include file="nav-nav.jsp"%>
	<h1>Welcome to Lissu Coffee </h1>
		
		<a href="<c:url value="/login" />" class="btn btn-info" role="button">Login</a>
		<br>
		<br>
		
		<a href="<c:url value="/registration" />" class="btn btn-info" role="button">Registor</a>
		
		
		<a href="<c:url value="/secure" />" class="btn btn-info" role="button">Go Here to see more products</a>
		
		
		<h2>List of products</h2>
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