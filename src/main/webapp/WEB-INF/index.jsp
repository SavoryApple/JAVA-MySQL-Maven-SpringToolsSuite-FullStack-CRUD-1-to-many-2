<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Dorms</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container w-100 h-100">
		<h1>All Dorms</h1>
		<table class="table table-striped w-100">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
			</tr>
			<c:forEach var="oneDorm" items="${dorms}">
				<tr>
					<th scope="row"><c:out value="${oneDorm.id}"></c:out></th>
					<td><a href="/dorms/${oneDorm.id}"><c:out value="${oneDorm.name}"></c:out></a></td>
				
				</tr>
			</c:forEach>
		</table>

		<form action="/dorms/new">
			<button class="btn btn-primary">New Dorm</button>
		</form>

	</div>

</body>
</html>