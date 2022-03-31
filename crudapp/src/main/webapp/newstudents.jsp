<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%-- <%@ include file="template.jsp"%> --%>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="/style.css" />
<link rel="stylesheet" type="text/css" href="/addStudent.css" />
<style type="text/css">

</style>
<title>Add Students</title>
</head>
<body>
	<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark py-3">
		<div class="container-fluid">
			<a class="navbar-brand" href="/">Manage Students</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link " aria-current="page"
						href="/home">Home</a></li>
					<li class="nav-item float-right"><a class="nav-link"
						href="newstudent">Add Student</a></li>
						<li class="nav-item float-right"><a class="nav-link active"
						href="newstudents">Add Students</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<form action="/addstudents" method="post">
		<div>
			<h4 id="startPara" class="d-inline">New Student 1</h4>
			<div id="items" class="row g-3 section">
				<div class="col-sm-4">
<!-- 					<label class="form-label" for="id">ID:</label>  -->
					<input class="form-control form-control-sm" type="text" id="id" name="id"
						value=${lastIndex } readonly>
				</div>
				<div class="col-sm-4">
<!-- 					<label class="form-label" for="name">Enter Name:</label>  -->
					<input required placeholder="Enter Name" class="form-control form-control-sm" type="text" id="name" name="name">
				</div>
				<div class="col-sm-4">
<!-- 					<label class="form-label" for="tech">Enter Tech:</label>  -->
					<input required placeholder="Enter Tech" class="form-control form-control-sm" type="text" id="tech" name="tech">
				</div>
			</div>
			<div id="functional" class="col-4">
				<button class="btn btn-dark" type="button" id="add">Add
					Another Student</button>
				<button type="submit" class="btn btn-dark">Submit</button>
			</div>
		</div>
	</form>
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/custom.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>