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
	
</head>
<body>
		<h3>Customer List</h3>
		<a href="/addCustomerDetail"><button class="btn btn-success">Add Customer</button></a>
		<form id="form">
			<select id="field" name="field" class="btn btn-primary" required>
	             <option value="" disabled selected>Search By</option>
	             <option value="firstName">First Name</option>
	             <option value="city">City</option>
	             <option value="email">Email</option>
	             <option value="phone">Phone</option>
	           </select>
	           <input type="text" id="value" />
	           <button type="submit" class="btn btn-primary">Search</button>
	     </form>
	     <button class="btn btn-success" id="syncButton">Sync</button>
	<table class="table table-bordered table-responsive table-striped table-hover">
        <thead class="thead-dark">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
	<script src="js/customerDetail.js"></script>
</body>
</html>