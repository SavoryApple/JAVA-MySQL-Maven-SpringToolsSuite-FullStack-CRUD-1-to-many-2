<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Students</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
		<div class="container w-25 border border-secondary p-3">
		<h1>New Student</h1>
		<form:form action="/students/create" method="post"
			modelAttribute="student">
			<p>
				<form:label path="dorm">Dorm</form:label>
				<form:select path="dorm">
					<c:forEach var="oneDorm" items="${dorms}">
						<!--- Each option VALUE is the id of the person --->
						<form:option value="${oneDorm.id}">
							<!--- This is what shows to the user as the option --->
							<c:out value="${oneDorm.name}" />
						</form:option>
					</c:forEach>
				</form:select>
			</p>
			<p>
				<form:label path="name">Student Name</form:label>
				<form:errors path="name" />
				<form:input path="name" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>