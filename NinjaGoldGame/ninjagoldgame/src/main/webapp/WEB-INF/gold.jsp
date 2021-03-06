<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div>
		<h3>
			Your Gold:
			<lable> <c:out value="${count}" /></lable>
		</h3>
	</div>
	<div id="main">
		<aside>
			<h3>Farm</h3>
			<h4>(Earns 10 to 20 gold)</h4>
			<form action="/play" method="POST">
				<button type="submit">Find Gold</button>
				<input type="hidden" name="gold" value="farm">
			</form>
		</aside>
		<aside>
			<h3>Cave</h3>
			<h4>(Earns 5 to 10 gold)</h4>
			<form method="POST" action="/play">
				<input type="submit" value="Find Gold!"> <input
					type="hidden" value="cave" name="gold">
			</form>
		</aside>
		<aside>
			<h3>House</h3>
			<h4>(Earns 2 to 5 gold)</h4>
			<form method="POST" action="/play">
				<input type="submit" value="Find Gold!"> <input
					type="hidden" value="house" name="gold">
			</form>
		</aside>
		<aside>
			<h3>Casino</h3>
			<h4>(Earns/Taken 0 to 50 gold)</h4>
			<form method="POST" action="/play">
				<input type="submit" value="Find Gold!"> <input
					type="hidden" value="casino" name="gold">
			</form>
		</aside>

	</div>
	<div>
		<h3>Activities :</h3>

		<c:forEach items="${activites}" var="item">
			<c:if test="${gold < 0}">
				<p style="color: red;">
					<c:out value="${item}" />
				</p>
			</c:if>
			<c:if test="${gold > 0}">
				<p style="color: green;">
					<c:out value="${item}" />
				</p>
			</c:if>
	  	</c:forEach>
	</div>
</body>
</html>