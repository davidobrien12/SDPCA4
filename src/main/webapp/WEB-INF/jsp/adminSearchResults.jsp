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

<div class="container text-center">
		<br>
		<h2>Search Results</h2>
		

	<table>
		<c:forEach var="Item" items="${sessionScope.searchResult}"
			varStatus="status">
			<c:if test="${not status.first and status.index % 4 == 0}">
				<tr>
			</c:if>
			<td width="200"><img src="images/${Item.image}"
				height="200" width="180" /><br> <c:out
					value="${Item.title}" /><br> Manufacturer: <c:out
					value="${Item.manufacturer}" /><br> Category: <c:out
					value="${Item.category}" /><br> Price: €<c:out
					value="${Item.price}" /><br> <br> <br></td>
			<c:if test="${status.first and status.index % 4 == 4 or status.last}">
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>