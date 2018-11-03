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

<h2>Categories</h2>
<br>

    <form action="/admin/home" method="GET" style="position: absolute; right: 0;">
        <div>
        <button type="submit" >home</button>
        </div>
    </form>

    </br>
    </br>

    <table class="table" border="1">
      <thead class="thead-dark">
        <tr>
          <th scope="col">#</th>
          <th scope="col">Name</th>
          <th scope="col">Product count</th>
          <th scope="col">created at:</th>
          <th scope="col">updated at:</th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${cat}" var="category">
        <c:set target="${createdAt}" property="time" value="${category.createdAt}"/>
        <c:set target="${updatedAt}" property="time" value="${category.updatedAt}"/>
        <tr>
            <form action="/admin/categories/update" method="GET">
            <td>${category.id}</td>
            <td><input type"text" name="categoryName" value="${category.name}"/></td>
            <td>${category.productCount}</td>
            <td>${createdAt}</td>
            <td>${updatedAt}</td>
            <td>
                <input type="hidden" name="categoryId" value="${category.id}">
                <input type="submit" value="UPDATE" >
            </td>
            </form>

            <td>
                <c:choose>
                    <c:when test="${category.productCount=='0'}">
                        <form action="/admin/categories/delete" method="GET">
                            <input type="hidden" name="categoryId" value="${category.id}">
                            <input type="submit" value="DELETE">
                        </form>
                    </c:when>

                    <c:otherwise>
                        <form action="/admin/categories/delete" method="GET">
                            <input type="hidden" name="categoryId" value="${category.id}">
                            <input type="submit" value="DELETE" disabled="true">
                        </form>
                    </c:otherwise>
                </c:choose>
            </td>

        </tr>
      </c:forEach>
      </tbody>
    </table>
</body>
</html>