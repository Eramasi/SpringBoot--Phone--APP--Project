<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
  <%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %> 
  
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Contacts</title>
<link href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css"  rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.js"> </script>
<script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script> 

<script >
$(document).ready(function() {
    $("#contactTbl").DataTable( {
        "pagingType": "full_numbers"
    } );
} );
</script> 
<script>

function deleteConfirm(){
	return confirm(" Are you sure, you want to delete the record ?");
}

</script>
</head>
<body align="center" style="background-color:powderblue;">
<h3>View Contacts Here</h3>
<a href="addContact">Add New Contact</a>

<table border="1" align="center" id="contactTbl">
<thead>
<tr>
<th>S.NO</th>
<th>Name</th>
<th>Email</th>
<th>PHNO</th>
<th>Action</th>
</tr>


</thead>
<tbody>
 <c:forEach items="${contacts}" var="c" varStatus="index">
 <tr>
 <td>${index.count}</td>
 <td>${c.contactName}</td>
 <td>${c.contactEmail}</td>
 <td>${c.contactNumber}</td>
 <td> 
 <a href="editContact?cid=${c.contactId}">Edit</a>
      <a href="deleteContact?cid=${c.contactId }"  onclick="deleteConfirm()">Delete</a>
 </td>
 </tr>
 
 </c:forEach>

</tbody>

</table>


</body>
</html>