<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"
	rel="stylesheet">

<meta charset="ISO-8859-1">
<title>Store</title>
</head>
<body>

	<form class="form-horizontal" method="post" action="login"
		style="text-align: center;">
		<br>
		<c:if test="${not empty error}">
			<div class="alert alert-primary col-md-6 container">
				<c:out value="${error}"></c:out>
			</div>
		</c:if>
		<h3>Login</h3>
		<div class="form-group">
			<div class="col-md-6 container">
				<input type="text" class="form-control" name="username"
					placeholder="Username" autocomplete="off" value="${user.username}" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-6 container">
				<input type="password" class="form-control" name="password"
					placeholder="Password" value="${user.password}" />
			</div>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-secondary" value="Login" />
		</div>
	</form>
	<hr>

	
	<form class="form-horizontal" method="post" action="addUser"
		style="text-align: center;">
		<h3>Join Us</h3>
		<input type="hidden" name="id" value="${user.customerId}" />
		<div class="form-group">
			<input type="text" class="form-control col-md-6" name="firstName"
				placeholder="Enter First Name" autocomplete="off"
				value="${user.firstName}" />
		</div>
		<div class="form-group">
			<input type="text" class="form-control col-md-6" name="lastName"
				placeholder="Enter Last Name" autocomplete="off"
				value="${user.lastName}" />
		</div>
		<div class="form-group">
			<input type="text" class="form-control col-md-6" name="dob"
				placeholder="Enter Date of Birth" autocomplete="off"
				value="${user.dob}" />
		</div>
		<div class="form-group">
			<input type="text" class="form-control col-md-6" name="username"
				placeholder="Enter Username" autocomplete="off"
				value="${user.username}" />
		</div>
		<div class="form-group">
			<input type="password" class="form-control col-md-6" name="password"
				placeholder="Enter Password" value="${user.password}" />
		</div>
		<div class="form-group">
			<input type="text" class="form-control col-md-6"
				name="shippingAddress" placeholder="Enter Delivery Address"
				value="${user.shippingAddress}" />
		</div>
		<div class="form-group">
			<input type="text" class="form-control col-md-6" name="paymentMethod"
				placeholder="Enter Payment Method" value="${user.paymentMethod}" />
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-secondary" value="Join Us!" />
		</div>
	</form>

	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>


