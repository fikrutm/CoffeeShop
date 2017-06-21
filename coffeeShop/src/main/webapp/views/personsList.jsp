<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Persons List</title>
</head>
<body>	
		 <a href="<c:url value="/logout" />">logout </a>	
		<br> 
		<br>		
		<h2>List of persons</h2>
		<table>
		  <tr>
		  <td>Person ID</td>
		  <td>First Name</td>
		  <td>Last Name</td>
		  <td>Address</td>
		  <td>Phone</td>
		 
		  </tr>
		  
		   <c:forEach var="person" items="${persons}"> 
		  
		  <tr>
		    <td>${person.id}</td>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.address}</td>
            <td>${person.phone}</td>    
            <sec:authorize access= "hasRole('ADMIN')">
            
            <td>
             <c:url var="deletePerson" value="/person/delete/${person.id}"/>
             <form action="${deletePerson}" method="post">
		      <button type="submit">Delete</button>
	         </form>
	         </td>
            </sec:authorize>      
		  </tr>
		</c:forEach>
		</table>
		<br>
		
		<a href="<c:url value="/persons/manage" />"> Back </a>