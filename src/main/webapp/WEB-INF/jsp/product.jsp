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
              <th scope="col">Product Code</th>
              <th scope="col">Name</th>
              <th scope="col">mrp</th>
              <th scope="col">ssp</th>
              <th scope="col">ymp</th>
              <th scope="col">SellerId</th>
              <th scope="col">CategoryId</th>
              <th scope="col">Short Description</th>
              <th scope="col">Long Description</th>
              <th scope="col">Dimensions</th>
              <th></th>
            </tr>
          </thead>
          <tbody>

            <tr>
            <form action="/admin/prod" method="GET">
              <td>${ab.id}</td>
              <td><input type"text" name="productCode" value="${ab.productCode}"/></td>
              <td><input type"text" name="productName" value="${ab.productName}"/></td>
              <td><input type"text" name="mrp" value="${ab.mrp}"/></td>
              <td><input type"text" name="ssp" value="${ab.ssp}"/></td>
              <td><input type"text" name="ymp" value="${ab.ymp}"/></td>
              <td><input type"text" name="sellerId" value="${ab.sellerId}"/></td>
              <td><input type"text" name="categoryId" value="${ab.categoryId}"/></td>
              <td><input type"text" name="shortDescription" value="${ab.shortDescription}"/></td>
              <td><input type"text" name="longDescription" value="${ab.longDescription}"/></td>
              <td><input type"text" name="dimensions" value="${ab.dimensions}"/></td>

              <td>
                    <input type="hidden" name="productId" value="${ab.id}">
                    <input type="hidden" name="flag" value=0>
                    <input type="submit" value="UPDATE">
                </form>
              </td>
            </tr>

          </tbody>
        </table>

</body>
</html>