<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<%@ include file="template.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Record</title>
<link rel="stylesheet" type="text/css" href="/style.css" />
<style type="text/css">
</style>
</head>
<body>
	<table class="table table-dark table-striped" id="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Tech</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody class="table-striped">
			<c:forEach items="${listOfStudents}" var="student">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.tech}</td>
					<td><a class="btn btn-warning" href="http://localhost:8080/deleted?id=${student.id}">Delete</a>
						<a class="btn btn-success" href="http://localhost:8080/update?id=${student.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>