<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file="template.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<h1>Update Record</h1>
	<form:form action="updateuser" method="post" modelAttribute="userForm">
<!-- 		<div class="form-group"> -->
<!-- 		<label for="id">ID:</label> -->
<%-- 			<form:input path="id" class="form-control" type="text" id="id" name="id" --%>
<%-- 				value="${user.id}"/> --%>
<!-- 		</div> -->
		<div class="form-group">
		<label for="uname">Username:</label>
			<form:input path="username" class="form-control" type="text" id="uname"
				name="uname" value="${user.userName}"/>
		</div>
		<div class="form-group">
		<label for="password">Password </label>
			<form:input path="password" required="required" class="form-control" type="password" id="password"
				name="password" placeholder="Enter New Password"/>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
</body>
</html>