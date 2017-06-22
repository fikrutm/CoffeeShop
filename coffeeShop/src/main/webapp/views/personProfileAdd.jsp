<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer profile</title>
</head>
<body>	
		<h1>Add a new person profile</h1>		
		
		
		<br>
		<br>		
		
		<form action="/person/add/profile" method="post">
		<p>First name: <input type="text" name="firstName"></p>
		<p>Last name:<input type="text" name="lastName"></p>
		<p>email: <input type="text" name="email"></p>
		<p>Phone: <input type="text" name="phone"></p>
		<p>City: <input type="text" name="address.city"></p>
		<p>State: <input type="text" name="address.state"></p>
		<p>Country: <input type="text" name="address.country"></p>
	    <p>Zip Code: <input type="text" name="address.zipcode">	 </p>   	   		
		<input type="submit" value="Create Person">
		
		</form>
			
		
		<a href="<c:url value="/persons/manage" />"> Back </a>
		
		
		
</body>
</html>