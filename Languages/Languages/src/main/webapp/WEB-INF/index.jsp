<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${langs}" var="x">
				<tr>
					<td><a href="/info/${x.id}">${x.name}</a></td>
					<td><c:out value="${x.creator}" /></td>
					<td><c:out value="${x.version}" /></td>
					<td><a href="/edit/${x.id}">Edit</a>/<a href="/languages/${x.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<form:form action="/languages" method="post" modelAttribute="lang">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="creator">Creator</form:label>
			<form:errors path="creator" />
			<form:textarea path="creator" />
		</p>
		<p>
			<form:label path="version">Version</form:label>
			<form:errors path="version" />
			<form:input path="version" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>