<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index page</title>
</head>
<body>

<%
	List<Film> listAllFilms = (List<Film>)request.getAttribute("listAllFilms");
%>
	<form action="/film" method="post">
		<span>cod:</span> <input type="text" name="cod"> <br />
		<span>title:</span> <input type="text" name="title"> <br />
		<span>codDirector:</span> <input type="text" name="codDirector"> <br />
		<input type="submit">
	</form>
	
	
	
	
<table border="1">
	<thead>
		<tr>
			<td>Cod</td>
			<td>Title</td>
			<td>codDirector</td>
			<td>Edit</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="film" items="${listAllFilms}">
			<tr>
				<td><c:out value="${film.cod}"/> </td>
				<td><c:out value="${film.title}"/> </td>
				<td><c:out value="${film.codOwner}"/> </td>
				<td><a href="/film?cod=${film.cod}">EDIT</a> </td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>