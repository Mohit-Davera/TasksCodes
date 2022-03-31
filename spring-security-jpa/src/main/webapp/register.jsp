<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file="template.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<div>
	<form:form action="register" method="post" modelAttribute="userForm" >
		<form:input path="username" class="form-control" type="text" id="uname" name="uname" placeholder="Enter Username"/>
		<form:input path="password" class="form-control" type="password" id="pass" name="pass" placeholder="Enter Password"/> 
<!-- 		<select name="roles" id="roles"> -->
<!-- 				<option value="GUEST">GUEST</option> -->
<!-- 				<option value="ADMIN">ADMIN</option> -->
<!-- 		</select>  -->
		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
	</div>
</body>
</html>