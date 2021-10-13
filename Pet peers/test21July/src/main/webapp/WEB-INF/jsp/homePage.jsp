<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
		<thead class="thead-dark">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
				<th>Place</th>
				<th>Buy/Sold</th>
			</tr>
		</thead>
		<c:forEach items="${pets}" var="pet">
			<tr>
				<td name="petId">${pet.id}</td>
				<td>${pet.name}</td>
				<td>${pet.age}</td>
				<td>${pet.place}</td>
				<c:if test="${pet.status =='Buy'}">
					<td><a href="buyPet/${pet.id}">${pet.status }</a></td>
				</c:if>
				<c:if test="${pet.status =='Sold'}">
					<td>${pet.status }</td>
				</c:if>

			</tr>
		</c:forEach>
	</table>
	
</body>
</html>