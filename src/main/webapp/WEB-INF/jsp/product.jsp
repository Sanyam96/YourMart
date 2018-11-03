<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:useBean id="createdAt" class="java.util.Date"/>
<jsp:useBean id="updatedAt" class="java.util.Date"/>

    <form action="/admin/home" method="GET" style="position: absolute; right: 0;">
        <div>
        <button type="submit" >home</button>
        </div>
    </form>

    </br>
    </br>

        <div>
        <table class="table">
          <thead class="thead-dark">
            <tr>
              <th scope="col">id</th>
              <th scope="col">Code</th>
              <th scope="col">Name</th>
              <th scope="col">mrp</th>
              <th scope="col">ssp</th>
              <th scope="col">ymp</th>
              <th scope="col">createdAt</th>
              <th scope="col">updatedAt</th>
              <th scope="col">SellerId</th>
              <th scope="col">CategoryId</th>
              <th scope="col">Status</th>
              <th scope="col">SellerCompanyName</th>
              <th scope="col">categoryName</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${ab}" var="product">
            <c:set target="${createdAt}" property="time" value="${product.createdAt}"/>
            <c:set target="${updatedAt}" property="time" value="${product.updatedAt}"/>
            <tr>
              <td>${product.id}</td>
              <td>${product.productCode}</td>
              <td>${product.productName}</td>
              <td>${product.mrp}</td>
              <td>${product.ssp}</td>
              <td>${product.ymp}</td>
              <td>${createdAt}</td>
              <td>${updatedAt}</td>
              <td>${product.sellerId}</td>
              <td>${product.categoryId}</td>
              <td>${product.productStatus}</td>
              <td>${product.sellerCompanyName}</td>
              <td>${product.categoryName}</td>
              <td>
                <form action="/admin/products" method="GET">
                    <input type="hidden" name="productId" value="${product.id}">
                    <input type="submit" value="VIEW">
                </form>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>


    <form action="/admin/products" method="GET">

        <div class="container" >
            <h4>SortBy</h4>
            <select name="sortBy" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                <option value="mrp" class="dropdown-item">mrp</option>
                <option value="ssp">ssp</option>
                <option value="ymp">ymp</option>
                <option value="createdAt">createdAt</option>
                <option value="updatedAt">updatedAt</option>
            </select>
            <input type="submit" value="Submit">
        </div>

        <h3>Filter By SellerId </h3>
        <input type"text" name="sellerId"/>
        <input type="submit" value="pessMe">

        <h3>Filter By productStatus , sellerCompanyName</h3>
        <input type"text" name="productStatusId"/>
        <input type="submit" value="pessMe">

        <h3>Filter By category </h3>
        <input type"text" name="categoryId"/>
        <input type="submit" value="pessMe">

        <h3>Search By productName</h3>
        <input type"text" name="productName"/>
        <input type="submit" value="pessMe">

        <h3>Search By productCode</h3>
        <input type"text" name="productCode"/>
        <input type="submit" value="pessMe">

        </div>
    </form>



</body>
</html>