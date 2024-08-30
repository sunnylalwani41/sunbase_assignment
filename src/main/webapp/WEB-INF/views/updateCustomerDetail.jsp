<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<title>Sunbase</title>
	<meta charset="UTF-8">
	<script src="https://kit.fontawesome.com/e99a9eb445.js" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link rel="stylesheet" href="css/addCustomerDetail.css">
</head>
<body>
		<h3>Update Customer Detail</h3>
	<form id="form">
		<input type="hidden" id="uuid" name="uuid" required />
		<input type="text" id="firstName" name="firstName" placeholder="First Name" required/>
		<input type="text" id="lastName" name="lastName" placeholder="Last Name" required/>
		<input type="text" id="street" name="street" placeholder="Street" required/>
		<input type="text" id="address" name="address" placeholder="Address" required/>
		<input type="text" id="city" name="city" placeholder="City" required/>
		<input type="text" id="state" name="state" placeholder="State" required/>
		<input type="email" id="email" name="email" placeholder="Email" required/>
		<input type="text" id="phone" name="phone" placeholder="Phone" required/>
		<button type="submit" class="btn btn-success">Submit Detail</button>
	</form>
	<script src="js/updateCustomerDetail.js"></script>
</body>
</html>