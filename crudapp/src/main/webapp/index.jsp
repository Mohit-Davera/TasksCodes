<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page import="java.lang.Math"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="template.jsp"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Records</title>
<link rel="stylesheet" type="text/css" href="/style.css" />
<style type="text/css">
.pagination{
	margin : 0px 500px;
}
.sortable a{
text-decoration: none;
}
</style>
</head>
<body>
	<display:table id="data" class="table table-sm table-dark table-striped" name="listOfStudents"
		sort="list" requestURI="/" pagesize="10" uid="one">

<!-- 			properties 				-->

		<display:setProperty name="paging.banner.placement" value="bottom" />
		<display:setProperty name="paging.banner.group_size" value="3" />
		<display:setProperty name="paging.banner.full">
			<nav aria-label="Page navigation example">
				<ul class="pagination">

					<li class="page-item"><a class="page-link text-white bg-dark" href="{1}">First</a></li>
					<li class="page-item"><a class="page-link text-white bg-dark" href="{2}">Prev</a></li>
					{0}
					<li class="page-item"><a class="page-link text-white bg-dark" href="{3}">Next</a></li>
					<li class="page-item"><a class="page-link text-white bg-dark" href="{4}">Last</a></li>

				</ul>
			</nav>
		</display:setProperty>
		<display:setProperty name="paging.banner.first">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
						
						
					<li class="page-item"><a class="page-link text-white bg-dark" href="#">First</a></li>
					<li class="page-item"><a class="page-link text-white bg-dark" href="{4}">Prev</a></li>{0}
					<li class="page-item"><a class="page-link text-white bg-dark" href="{3}">Next</a></li>
					<li class="page-item"><a class="page-link text-white bg-dark" href="{4}">Last</a></li>

				</ul>
			</nav>
		</display:setProperty>
		<display:setProperty name="paging.banner.last">
			<nav aria-label="Page navigation example">
				<ul class="pagination">

					<li class="page-item"><a class="page-link text-white bg-dark" href="{1}">First</a></li>
					<li class="page-item"><a class="page-link text-white bg-dark" href="{2}">Prev</a></li>
					{0}
					<li class="page-item"><a class="page-link text-white bg-dark" href="{3}">Next</a></li>
					<li class="page-item"><a class="page-link text-white bg-dark" href="#">Last</a></li>

				</ul>
			</nav>
		</display:setProperty>
		<display:setProperty name="paging.banner.page.link">
			<li class="page-item"><a class="page-link text-white bg-dark" href="{1}">{0}</a></li>
		</display:setProperty>
		<display:setProperty name="paging.banner.page.selected"><li class="page-item active"><a class="page-link" href="{1}">{0}</a></li></display:setProperty>
		<display:setProperty name="paging.banner.page.separator"> </display:setProperty>


<!--			columns					 -->

		<display:column class="index" title="index" headerScope="col"><%=pageContext.getAttribute("one_rowNum")%></display:column>
		<display:column property="id" title="ID" sortable="true"
			headerScope="col" />
		<display:column property="name" title="Name" sortable="true"
			headerScope="col" />
		<display:column property="tech" title="Tech" sortable="true"
			headerScope="col" />
		<display:column title="actions">
			<a class="btn btn-warning" target="_blank"
				href="http://localhost:8080/deleted?id=${one.id }">Delete</a>
			<a class="btn btn-success" target="_blank"
				href="http://localhost:8080/update?id=${one.id }">Edit</a>
		</display:column>

	</display:table>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>