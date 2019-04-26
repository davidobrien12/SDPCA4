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

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/home">Store</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor03" aria-controls="navbarColor03"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor03">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/adminSearch">Search Stock</a></li>
				<li class="nav-item"><a class="nav-link" href="/addStock">Add Stock</a></li>
				<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
			</ul>
		</div>
	</nav>
		<form class="form-horizontal" method="post" action="adminSearch"
		style="text-align: center;">
		<br>
		<b>Enter search criteria</b><br>
		<input type="checkbox" name="category" value="Category"><b>Category</b> 
		<input type="checkbox" name="manufacturer" value="Manufacturer"><b>Manufacturer</b>
		<input type="checkbox" name="title" value="Title"><b>Title</b>
		
		<div class="form-group">
			<div class="col-md-offset-4">
				<br> <label class="col-md-2 control-label"><b>Enter
						Search</b></label><br>
				<div class="col-md-3 container">
					<input type="text" class="form-control" name="adminSearch" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-secondary" value="Search" />
		</div>
	</form>

	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>