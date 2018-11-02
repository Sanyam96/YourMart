<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/admin/logout" method="POST">
		<button type="submit">Logout</button>
	</form>
	<c:if test="${not empty admin}">
		<h2>Hii ${admin.username}</h2>
	</c:if>
	<c:if test="${empty admin}">

	</c:if>

	<form action="/admin/seller" method="POST">
		<button type="submit">Seller</button>
	</form>

	<form action="/admin/products" method="POST">
		<button type="submit">Product</button>
	</form>

	<form action="/admin/category" method="POST">
		<button type="submit">Category</button>
	</form>
</body>
</html>