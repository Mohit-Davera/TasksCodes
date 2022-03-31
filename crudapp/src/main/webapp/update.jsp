<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file="template.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/style.css" />
<title>Update Record</title>
</head>
<body>
	<h1>Update Record</h1>
	<form action="addstudent" method="post">
		<div class="form-group">
			<label class="form-label" for="id">Enter ID:</label><input readonly class="form-control" type="text" id="id" name="id"
				value="${student.id}">
		</div>
		<div class="form-group">
			<label class="form-label" for="name">Enter Name:</label> <input class="form-control" type="text" id="name"
				name="name" value="${student.name}">
		</div>
		<div class="form-group">
			<label class="form-label" for="tech">Enter Tech:</label> <input class="form-control" type="text" id="tech"
				name="tech" value="${student.tech}">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>