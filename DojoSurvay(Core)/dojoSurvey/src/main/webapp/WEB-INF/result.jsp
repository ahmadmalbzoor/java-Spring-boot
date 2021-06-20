<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h1 id="sub">Submitted Info</h1>
	<div id="main">
		<aside>
			<h4>Name:</h4>
			<h4>Dojo Location:</h4>
			<h4>Favorite Language:</h4>
			<h4>Comment:</h4>
		</aside>

		<aside>
			<h4>
				<c:out value="${name}" />
			</h4>
			<h4>
				<c:out value="${location}" />
			</h4>
			<h4>
				<c:out value="${language}" />
			</h4>
			<h4>
				<c:out value="${comment}" />
			</h4>
			<h2><a href="/back">Go Back</a></h2>
		</aside>
	</div>
</body>
</html>