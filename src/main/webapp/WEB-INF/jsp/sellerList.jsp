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

                                <form action="/admin/seller/update-seller" method"GET" id="form1" style="position: absolute; right: 0;">
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

                <c:forEach items="${ab}" var="seller">
                <c:set target="${createdAt}" property="time" value="${seller.createdAt}"/>
                <c:set target="${updatedAt}" property="time" value="${seller.updatedAt}"/>
                <tr>
                  <td>${seller.id}</td>
                  <td>${seller.companyName}</td>
                  <td>${seller.ownerName}</td>
                  <td>${seller.address}</td>
                  <td>${seller.emailAddress}</td>
                  <td>${seller.telephoneNumber}</td>
                  <td>${createdAt}</td>
                  <td>${updatedAt}</td>
                  <td>${seller.gstNumber}</td>
                  <td>${seller.sellerStatusId}</td>
                  <td>${seller.sellerStatus}</td>

                  <td>
                    ${seller.id}
                    <div>
                    <form action="/admin/sel" method="GET" id="form2">
                        <input type="hidden" name="sellerId" value="${seller.id}">
                        <input type="hidden" name="flag" value=1>
                        <input type="submit" value="VIEW" form="form2">
                    </form>
                    </div>
                  </td>


                                    <td>
                                        ${product.id}
                                        <c:if test="${seller.sellerStatusId!=4}">
                                            <input type="checkbox" name="cbox" value="${seller.id}">
                                        </c:if>
                                    </td>

                                </c:forEach>



              </tbody>
              <input type="submit" value="Approve Selected Products" form="form1">
            </table>

         </div>


</body>
</html>