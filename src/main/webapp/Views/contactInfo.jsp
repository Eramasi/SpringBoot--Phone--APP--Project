<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
  label,
  input,
  button {
    border: 10;
    margin-bottom: 10px;
    display: block;
    width: 100%;
  }
 .common_box_body {
    padding: 5px;
    border: 2px solid #28BAA2;
    border-color: #28BAA2;
    border-radius: 5px;
    margin-top: 1px;
    background: #d4edda;
}
</style>
<title>Save Contact</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"> </script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"> </script>  
<script>
$(document).ready(function(){
  $("#form").validate({
    // Specify validation rules
    rules: {
      contactname: "required",
      contactnumber: "required",
      email: {
        required: true,
        email: true
      },
    },
  
  });
});
</script>


</head>
<body align="center" style="background-color:powderblue;">

<h2> Save Contact</h2>
<div class="common_box_body test">
<p> 
<font color="green"> ${succmsg} </font>
</p>

<p>
<font color="red"> ${errorMsg} </font>   
 </p>

<p>
<font color="green">${SuccMsg}</font>
</p>

<p>
<font color="red"> ${ErrorMsg} </font>   
 </p>
<table border="1" align="center" id="form">

<form:form id="form" action="saveContact" modelAttribute="contact" method="Post">
<table align="center" id="contactform"> 
<tr> 
<form:hidden path="contactId"/>

<td>Contact Name :</td>



<td><form:input path="contactName" id="contactname" placeholder="Chakravarthi"  /> </td>

</tr>

<tr>

<td>Contact Email :</td>


<td><form:input path="contactEmail" id="email" is="email" placeholder="chakri@gmail.com" /></td>

</tr>

<tr>

<td>Contact Number:</td>


<td><form:input path="contactNumber"  name="contactnumber" id="contactnumber" placeholder="8328579169" /></td>

</tr>
<tr>

<td><input type="reset" value="Reset"/></td>

<td><input type="submit" value="Save" name="form"/></td>
</tr>

</table>

</form:form>
</table>
<a href="viewContacts">View All Contacts</a>
</body>
</html>