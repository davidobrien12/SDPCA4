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
<div class="container text-center">
		<br>
		<h3>${sessionScope.user.firstName }'s Cart</h3>
		<hr>
		
		Cart Quantity: ${sessionScope.amount } Items<br>
		Sub-Total: €${sessionScope.subTotal } <br>
		
		<form class="form-horizontal" method="post" action="purchase">
			<input type="submit" class="btn btn-secondary" value="Purchase Items" />
		</form>
		<hr>
	</div>

	<table>
		<c:forEach var="cartObj" items="${sessionScope.list}" varStatus="status">
			<c:if test="${not status.first and status.index % 4 == 0}">
				<tr>
			</c:if>
			<td width="200">
				<img src="images/${cartObj.image}" height="200" width="180" /><br> 
				<c:out value="${cartObj.title}" /><br>
				Manufacturer: <c:out value="${cartObj.manufacturer}" /><br>
				Category: <c:out value="${cartObj.category}" /><br> 
				Price: €<c:out value="${cartObj.price}" /><br> 
				<br><br>
			</td>
			<c:if test="${status.first and status.index % 4 == 4 or status.last}">
				</tr>
			</c:if>
		</c:forEach>
	</table>

	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>