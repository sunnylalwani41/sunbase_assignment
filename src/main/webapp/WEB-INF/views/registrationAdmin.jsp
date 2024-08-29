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
	<link rel="stylesheet" href="css/registration.css">
</head>
<body>
	<form id="form">
		<h3>Registration Form</h3>
		<div>
		<p>Username: </p>
		<input type="text" name="username" id="username" required>
		</div>
		<div>
		<p>Password: </p>
		<input type="password" id="password" required/>
		</div>
		<button type="submit" class="btn btn-success">Submit Detail</button>
		<a href="/login"><button class="btn btn-primary">Login</button></a>
	</form>
	<script src="js/registration.js"></script>
</body>
</html>