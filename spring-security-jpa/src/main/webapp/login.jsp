<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file="template.jsp" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="login">
		<div class="form-group">
			<input class="form-control" type="text" id="username"
				name="username" placeholder="Username:">
		</div>
		<div class="form-group">
			<input class="form-control" type="text" id="password"
				name="password" placeholder="Password ">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</body>
</html>