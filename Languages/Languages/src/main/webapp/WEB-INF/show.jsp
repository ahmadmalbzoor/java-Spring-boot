<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><c:out value="${showinfo.name}"/></h3>
    <h3><c:out value="${showinfo.creator}"/></h3>
    <h3><c:out value="${showinfo.version}"/></h3>
    <a href="/edit/${showinfo.id}">Edit</a>/<a href="/languages/${showinfo.id}">Delete</a>/<a href="/languages">Dashboard</a>
</body>
</html>