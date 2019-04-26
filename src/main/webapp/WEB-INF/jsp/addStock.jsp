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
<br>
	<div class="container text-center">
		<h2>Add an Item</h2>
	</div>
	<form class="form-horizontal" method="post" action="addingStock"
		style="text-align: center;">
		<%-- <input type="hidden" name="id" value="${customer.userId}" /> --%>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-3 container">
					<input type="text" class="form-control" name="title"
						placeholder="Product Title" autocomplete="off"
						value="${Item.title}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-3 container">
					<input type="text" class="form-control" name="manufacturer"
						placeholder="Product Manufacturer" autocomplete="off"
						value="${Item.manufacturer}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-3 container">
					<input type="text" class="form-control" name="price"
						placeholder="Product Price" autocomplete="off"
						value="${Item.price}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-3 container">
					<input type="text" class="form-control" name="category"
						placeholder="Product Category" autocomplete="off"
						value="${Item.category}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-3 container">
					<input type="text" class="form-control" name="amount"
						placeholder="Product Quantity" autocomplete="off"
						value="${Item.amount}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-3 container">
					<input type="file" class="form-control" name="photo"
						value="${Item.photo}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-secondary" value="Add Product" />
		</div>
	</form>


	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>

</body>
</html>