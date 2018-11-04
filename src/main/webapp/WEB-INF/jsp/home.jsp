<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="ISO-8859-1">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
        crossorigin="anonymous">
    <style>
        body {
            font-family: 'Raleway', sans-serif;
        }
        button {
        	cursor : pointer;
        	background-color: white;
        	border: 0px;
        	outline:none !important;
        }
        .footer {
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            color: hsla(0,0%,100%,.75);
            background-color: #24292e;
            text-align: center;
            padding-top:11px;
            padding-bottom:11px;
        }
    </style>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light" style="box-shadow: 1px 1px #888888c5;padding-bottom: 1px;padding-top:2px;">

        <!-- <a class="navbar-brand" href="#">myMart</a> -->
        <a class="navbar-brand" href="#">
            <img src="https://images.all-free-download.com/images/graphiclarge/shopping_cart_vector_graphics_558084.jpg" width="45" height="30"
                alt="mart">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                	<form action="/admin/sellers" method="GET">
                    	<button type="submit" class="nav-link">Sellers</a>
                	</form>
                </li>
                <li class="nav-item">
                	<form action="/admin/products" method="GET">
                    	<button type="submit" class="nav-link">Products</button>
                    </form>
                </li>
                <li class="nav-item">
                    <form action="/admin/categories" method="GET">
						<button type="submit" class="nav-link">Category</button>
					</form>
                </li>

            </ul>
            <form action="/admin/logout" method="POST">
            <button type="submit">
                signout
                <i class="fas fa-sign-out-alt"></i>
            </button>
            </form>
        </div>
    </nav>

    <div class="container-fluid" style="padding-left: 0px;padding-right: 0px">
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner" style="padding-left=0px;">
                <div class="carousel-item">
                    <img class="d-block w-100" height="520px;" src="http://www.mobilemartphones.com/wp-content/uploads/2013/11/Mobile-Mart-Logo11-1024x466.jpg"
                        alt="First slide">
                </div>
                <div class="carousel-item active">
                    <img class="d-block w-100" height="520px;" src="https://grocerymartonline.com/wp-content/uploads/2018/04/03.jpg" alt="Second slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" height="520px;" src="https://pbs.twimg.com/profile_images/3480556475/ff863260830dc9efdc72bf1556a06346.jpeg" height="500px"
                        alt="Third slide">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
</body>

</html>