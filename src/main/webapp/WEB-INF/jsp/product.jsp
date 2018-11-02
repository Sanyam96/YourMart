<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body style="background-color:#ccebff;">
    <p>${ab}</p>

    <form action="/admin/product" method="POST">
        <table border="1">
          <tr>
            <th>id</th>
            <th>Code</th>
            <th>Name</th>
            <th>mrp</th>
            <th>ssp</th>
            <th>ymp</th>
            <th>createdAt</th>
            <th>updatedAt</th>
            <th>SellerId</th>
            <th>Category</th>
            <th>Status</th>
          </tr>
          <c:forEach items="${ab}" var="product">
            <tr>
              <td>${product.id}</td>
              <td>${product.productCode}</td>
              <td>${product.productName}</td>
              <td>${product.mrp}</td>
              <td>${product.ssp}</td>
              <td>${product.ymp}</td>
              <td>${product.createdAt}</td>
              <td>${product.updatedAt}</td>
              <td>${product.sellerId}</td>

            </tr>
          </c:forEach>
        </table>
        <input type="submit" value="Approve">
    </form>
</body>
</html>