<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Profile page</title>
</head>
<body>
   <div style="color:blue"> User Name: <security:authentication property="principal.username" /> </div>
	<h1>Profile page</h1> 
	
	<a href="<c:url value="/logout" />">logout </a>
	
	<div style="color:blue">
	<p>First Name: ${userData.firstName}</p>
	<p>Last Name: ${userData.lastName}</p>
	<p>email: ${userData.email}</p>
	<p>Phone: ${userData.phone}</p>
	<p>City: ${userData.address.city}</p>
	<p>Country: ${userData.address.country}</p>
	<p>State: ${userData.address.state}</p>
	<p>ZipCode: ${userData.address.zipcode}</p>
	
	</div>
			<br>
		<br>
	<a href="/user/profile/update">Update Profile</a>
	<br>
	<br>
	<a href="/user">Back</a>
	</body>
</html>