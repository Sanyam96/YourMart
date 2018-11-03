<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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



  <p>${cat[0].createdAt}</p>



                     <jsp:useBean id="myDate" class="java.util.Date"/>
                     <c:set target="${myDate}" property="time" value="${cat[0].createdAt}"/>

                     <p>Date: ${myDate}</p>

    <p>${cat}</p>

    <p>${cat[0].id}</p>

    <table class="table">
      <thead class="thead-dark">
        <tr>
          <th scope="col">id</th>
          <th scope="col">Name</th>
          <th scope="col">createdAt</th>
          <th scope="col">updatedAt</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${cat}" var="category">
        <c:set target="${myDate}" property="time" value="${category.createdAt}"/>
        <tr>
          <td>${category.id}</td>
          <td>${category.name}</td>
          <td>${myDate}</td>
          <td>${category.updatedAt}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>




</body>
</html>