<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categories List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:useBean id="createdAt" class="java.util.Date"/>
<jsp:useBean id="updatedAt" class="java.util.Date"/>
<h2>Sellers</h2>
<br>

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
                  <th scope="col">#</th>
                  <th scope="col">companyName</th>
                  <th scope="col">ownerName</th>
                  <th scope="col">address</th>
                  <th scope="col">emailAddress</th>
                  <th scope="col">telephoneNumber</th>
                  <th scope="col">createdAt</th>
                  <th scope="col">updatedAt</th>
                  <th scope="col">GST Number</th>
                  <th scope="col">Seller Status ID</th>
                  <th scope="col">Seller Status</th>
                  <th></th>
                  <th></th>
                </tr>
              </thead>
              <tbody>

                <c:set target="${createdAt}" property="time" value="${ab.createdAt}"/>
                <c:set target="${updatedAt}" property="time" value="${ab.updatedAt}"/>
                <tr>
                  <td>${ab.id}</td>
                  <td>${ab.companyName}</td>
                  <td>${ab.ownerName}</td>
                  <td>${ab.address}</td>
                  <td>${ab.emailAddress}</td>
                  <td>${ab.telephoneNumber}</td>
                  <td>${createdAt}</td>
                  <td>${updatedAt}</td>
                  <td>${ab.gstNumber}</td>
                  <td>${ab.sellerStatusId}</td>
                  <td>${ab.sellerStatus}</td>

                  <td>
                    ${ab.id}
                    <div>
                    <form action="/admin/sel" method="GET">
                        <input type="hidden" name="productId" value="${ab.id}">
                        <input type="hidden" name="flag" value=1>
                        <input type="submit" value="VIEW">
                    </form>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>

         </div>


</body>
</html>