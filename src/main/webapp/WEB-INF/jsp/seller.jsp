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
                  <th scope="col">GST Number</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>

                <c:set target="${createdAt}" property="time" value="${ab.createdAt}"/>
                <c:set target="${updatedAt}" property="time" value="${ab.updatedAt}"/>


                <tr>
                            <form action="/admin/sel" method="GET">
                              <td>${ab.id}</td>
                              <td><input type"text" name="companyName" value="${ab.companyName}"/></td>
                              <td><input type"text" name="ownerName" value="${ab.ownerName}"/></td>
                              <td><input type"text" name="address" value="${ab.address}"/></td>
                              <td><input type"text" name="emailAddress" value="${ab.emailAddress}"/></td>
                              <td><input type"text" name="telephoneNumber" value="${ab.telephoneNumber}"/></td>
                              <td><input type"text" name="gstNumber" value="${ab.gstNumber}"/></td>

                              <td>
                                    <input type="hidden" name="sellerId" value="${ab.id}">
                                    <input type="hidden" name="flag" value=0>
                                    <input type="submit" value="UPDATE">
                                </form>
                              </td>
                            </tr>

              </tbody>
            </table>

         </div>


</body>
</html>