<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
 	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Starter</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container ">
		<div class="content-header text-center">
			<h2>Edit Position</h2>
		</div>
		<div class="content-body">
			<form:form method = "POST" action = "/spring-mvc-qlns/position/update/${id}" modelAttribute="position">
	         	<div class="row">
	         		<div class="col-md-12">
	         			<div class="form-group">
			         		<form:label path="name">Name</form:label>
			         		<form:input path="name" class="form-control" value="${position.getName()}"/>
			         	</div>
			             <div class="form-group">
			         		<form:label path="description">Description</form:label>
			         		<form:input path="description" class="form-control" value="${position.getDescription()}"/>
			         	</div>
			         	<div class="form-group">
	         				<button class="btn btn-primary" type="submit">Update Position</button>
         					<button class="btn btn-primary">Reset</button>
	         			</div>
	         		</div>
	         	</div>
	      </form:form>
		</div>
	</div>
</body>
</html>