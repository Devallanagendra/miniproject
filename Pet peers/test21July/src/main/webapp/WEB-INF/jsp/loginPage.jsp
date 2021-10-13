<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
		<ul class="nav navbar-nav navbar-right">
			<li><a href="toUserReg"><span class="fa fa-user-plus"></span>
					Sing up</a></li>
		</ul>
	</div>
	</nav>
	<form:form action="authenticateUser" modelAttribute="user">

		<div class="justify-content-center"
			style="margin-left: 35%; margin-top: 17%; width: 100%">
			<div style="color: green">${data[0]}</div>
			<div class="form-group">
				<label for="userName">Username<span style="color: red">
						*</span></label>
				<form:input class="form-control" path="userName"
					cssStyle="width: 30%" />
			</div>
			<div>
				<form:errors cssStyle="color: red" path="userName" />
			</div>
			<div class="form-group">
				<label for="userPassword">Password<span style="color: red">
						*</span></label>
				<form:password cssClass="form-control" path="userPassword"
					cssStyle="width: 30%" />
			</div>
			<div>
				<div style="color: red">${errMsg}</div>
			</div>

			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Login" />
			</div>
		</div>
	</form:form>
</body>
</html>