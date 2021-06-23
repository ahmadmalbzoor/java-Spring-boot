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
 <form:form action="/licenses/new" method="post" modelAttribute="lice">
		<p>
			<form:label path="person">Person</form:label>
			<form:errors path="person" />
			<form:select path="person">
			<c:forEach items="${pers}" var="x">
			
				<form:option value="${x.id}"><c:out value="${x.firstName} ${x.lastName}" /></form:option>
			</c:forEach>
				
			</form:select>
		</p>
		<p>
			<form:label path="state">State</form:label>
			<form:errors path="state" />
			<form:input path="state" />
		</p>
		<p>
        <form:label path="expirationDate">ExpirationDate</form:label>
        <form:input type="date" path="expirationDate"/>
        <form:errors path="expirationDate"/>

    </p>
		<input type="submit" value="Create" />
	</form:form>
</body>
</html>