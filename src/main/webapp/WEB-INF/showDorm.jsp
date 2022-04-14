<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Show Dorm</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Dorm: <c:out value="${dorm.name}" /></h1>
	<h2>Students:</h2>
	<table class="table table-striped w-100">
		<tr>
			<th scope="col">Name</th>
			<th scope="col">Action</th>
		</tr>
		<c:forEach var="oneStudent" items="${dorm.students}">
			<tr>
				<td><c:out value="${oneStudent.name}" /></td>
				<td><form action="/students/${oneStudent.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <button class="btn btn-danger">delete</button>
</form></td>	
			</tr>
		</c:forEach>
	</table>
	<a href="/students/new">Add a student</a> |
	<a href="/dorms">Home</a>
</body>
</html>