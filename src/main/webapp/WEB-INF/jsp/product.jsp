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
<body>
    <p>${ab}</p>

    <form action="/admin/products" method="GET">
        <table border="1">
          <tr>
            <th>id</th>
            <th>Code</th>
            <th>Name</th>
            <th>mrp</th>
            <th>ssp</th>
            <th>ymp</th>
            <th>createdAtInEpochTime</th>
            <th>updatedAtInEpochTime</th>
            <th>createdAtInHumanDate</th>
            <th>updatedAtInHumanDate</th>
            <th>SellerId</th>
            <th>CategoryId</th>
            <th>Status</th>
            <th>SellerCompanyName</th>
            <th>categoryName</th>
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
              <td>${product.createdAtInHumanDate}</td>
              <td>${product.updatedAtInHumanDate}</td>
              <td>${product.sellerId}</td>
              <td>${product.categoryId}</td>
              <td>${product.productStatus}</td>
              <td>${product.sellerCompanyName}</td>
              <td>${product.categoryName}</td>
            </tr>
          </c:forEach>
        </table>


        <h3>Sort By</h3>
        <input type="radio" name="sortBy" value="mrp" ${mrpChecked}/>MRP<br />
        <input type="radio" name="sortBy" value="ssp" ${sspChecked}/>SSP<br />
        <input type="radio" name="sortBy" value="ymp" ${ympChecked}/>YMP<br />
        <input type="radio" name="sortBy" value="createdAt" ${createdAtChecked}/>Created At<br />
        <input type="radio" name="sortBy" value="updatedAt" ${updatedAtChecked}/>Updated At<br />

        <input type="submit" value="pessMe">

    </form>



</body>
</html>