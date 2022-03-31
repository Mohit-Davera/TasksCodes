<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ include file="template.jsp"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/style.css" />
<title>CRUD App</title>
</head>
<body>
	<form action="showall" method="post" target="_blank">
		<button id="showAllRecords" type="submit" class="btn btn-dark">Show
			All Records</button>
	</form>
	<h3>Create/Update Record</h3>
	<form action="addstudent" method="post">
		<div class="mb-3">
			<!-- 			<label class="form-label" for="id">Enter ID:</label>  -->
			<input placeholder="Enter ID" class="form-control" type="text"
				id="id" name="id">
		</div>
		<div class="mb-3">
			<!-- 			<label class="form-label" for="name">Enter Name:</label>  -->
			<input placeholder="Enter Name" class="form-control" type="text"
				id="name" name="name">
		</div>
		<div class="mb-3">
			<!-- 			<label class="form-label" for="tech">Enter Tech:</label>  -->
			<input placeholder="Enter Tech" class="form-control" type="text"
				id="tech" name="tech">
		</div>

		<button type="submit" class="btn btn-dark">Submit</button>
	</form>
	<hr>
	<h3>Read Record</h3>
	<form action="getstudent" method="post" target="_blank">
		<div class="mb-3">
			<!-- 			<label class="form-label" for="g_id">Enter ID:</label>  -->
			<input placeholder="Enter ID" class=" form-control" type="text"
				id="g_id" name="id">
		</div>
		<button type="submit" class="btn btn-dark">Submit</button>
	</form>
	<form action="getstudentgt" method="post" target="_blank">
		<div class="mb-3">
			<!-- 			<label class="form-label" for="gt_id">All Records After This -->
			<!-- 				ID</label>  -->
			<input placeholder="All Records After This ID" class="form-control"
				type="text" id="gt_id" name="id">
		</div>
		<button type="submit" class="btn btn-dark">Submit</button>
	</form>

	<hr>
	<h3>Delete Record</h3>
	<form action="deleted" method="post" target="_blank">
		<div class="mb-3">
			<!-- 			<label class="form-label" for="d_id">Enter ID:</label>  -->
			<input placeholder="Enter ID" class="form-control" type="text"
				id="d_id" name="id">
		</div>
		<button type="submit" class="btn btn-dark">Submit</button>
	</form>
</body>
</html>