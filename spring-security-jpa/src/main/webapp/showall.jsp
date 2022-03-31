<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<%@ include file="template.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All</title>
<link rel="stylesheet" type="text/css" href="/style.css" />
<style type="text/css">
</style>
</head>
<body>
	<table class="table table-dark table-striped" id="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Status</th>
				<th>UserName</th>
				<th>Roles</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody class="table-striped">
			<c:forEach items="${listOfUsers}" var="user">
				<tr>
					<td>${user.id}</td>
					<c:if test="${user.active }">
						<td>active</td>
					</c:if>
					<c:if test="${not user.active }">
						<td>inactive</td>
					</c:if>
					<%-- 					<td>${user.active }</td> --%>
					<td>${user.userName}</td>
					<td>${user.roles}</td>
					<td><c:if test="${user.active }">
							<a class="btn btn-warning"
								href="http://localhost:8080/deactive?userName=${user.userName}">Deactivate</a>
						</c:if> <c:if test="${not user.active }">
							<a class="btn btn-warning"
								href="http://localhost:8080/active?userName=${user.userName}">Activate</a>
						</c:if> <a class="btn btn-success"
						href="http://localhost:8080/delete?userName=${user.userName}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/logout">logout</a>
</body>
</html>