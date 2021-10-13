<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Pet</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="./">Pet Shop</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="home"> Home</a></li>
			</ul>
			<ul class="nav navbar-nav">
				<li><a href="toMyPet"> My Pet</a></li>
			</ul>
			<ul class="nav navbar-nav">
				<li><a href="toAddpet"> Add Pet</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="toLogin"><span class="fa fa-sign-out"></span>
						Sign out</a></li>
			</ul>
		</div>
	</nav>

	<table class="table">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Age</td>
			<td>Place</td>
		</tr>
		<c:forEach items="${list}" var="pet">
			<tr>
				<td>${pet.id}</td>
				<td>${pet.name}</td>
				<td>${pet.age}</td>
				<td>${pet.place}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>