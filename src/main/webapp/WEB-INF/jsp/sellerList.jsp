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

                <form action="/admin/seller/update-seller" method"GET" style="position: absolute; right: 0;">
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
                        <a href="seller/${seller.id}">View</a>
                  </td>


                    <td>
                        ${seller.id}
                        <c:if test="${seller.sellerStatusId!=4}">
                            <input type="checkbox" name="cbox" value="${seller.id}">
                        </c:if>
                    </td>

                  </tr>
                                </c:forEach>



              </tbody>
            </table>
              <input type="submit" value="Approve Selected Products" > </form>

         </div>

            <form action="/admin/sellers" method="GET">

                 <div class="container" >
                     <h4>SortBy</h4>
                     <select name="sortBy" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                         <option value="id" class="dropdown-item">sellerId</option>
                         <option value="createdAt">Registration Time</option>
                     </select>
                     <input type="submit" value="Submit">
                 </div>

                 <h3>Filter By SellerId</h3>
                 <input type"text" name="sellerId"/>
                 <input type="submit" value="pressMe">

                 <h3>Filter By SellerStatus</h3>
                 <input type"text" name="sellerStatusId"/>
                 <input type="submit" value="pressMe">

                 <h3>Search By companyName</h3>
                 <input type"text" name="companyName"/>
                 <input type="submit" value="pressMe">

                 <h3>Search By Owner Name</h3>
                 <input type"text" name="ownerName"/>
                 <input type="submit" value="pressMe">

                 <h3>Search By Telephone Number</h3>
                  <input type"text" name="telephoneNumber"/>
                  <input type="submit" value="pressMe">
             </form>


</body>
</html>