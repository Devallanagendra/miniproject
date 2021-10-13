<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Pet</title>
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
	<form:form action="savePet" modelAttribute="pet">
		<div class="justify-content-center"
			style="margin-left: 35%; margin-top: 17%; width: 100%">
			<div class="form-group">
				<label for="name">Name<span style="color: red"> *</span></label>
				<form:input class="form-control" path="name" cssStyle="width: 30%" />
			</div>
			<div class="form-group">
				<label for="age">Age<span style="color: red"> *</span></label>
				<form:input cssClass="form-control" path="age" cssStyle="width: 30%" />
			</div>
			<div class="form-group">
				<label for="place">Place<span style="color: red"> *</span></label>
				<form:input cssClass="form-control" path="place"
					cssStyle="width: 30%" />
			</div>
			<div style="color: red">${error_message }</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Create" />
			</div>
		</div>
	</form:form>
	<script>
		$(document).ready(function() {
			$("#cancel").click(function() {
				console.log("**********************")
				$(this).text("Sold Out");
				$(this).prop("disabled", true);
			});
		});
	</script>
</body>
</html>