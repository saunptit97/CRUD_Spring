<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<h2>Position</h2>
		</div>
		<a href="/spring-mvc-qlns/position/create"><button class="btn btn-primary" style="margin: 20px 0px">Add Employee</button></a>
		<div class="content-body">
			<table class="table table-hover table-bordered">
				<tr>
					<th>#</th>
					<th>Name</th>
					<th>Description</th>
					<th>Action</th>
				</tr>
				
			<c:forEach items="${positions}" var="position">
				<tr>
					<td>${position.id}</td>
					<td>${position.name}</td>
					<td>${position.description}</td>
					<td>
						<a href="/spring-mvc-qlns/position/edit/${position.id}"><button class="btn btn-warning">Edit</button></a>
						<a href="/spring-mvc-qlns/position/delete/${position.id}"><button class="btn btn-danger">Delete</button></a>
					</td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>