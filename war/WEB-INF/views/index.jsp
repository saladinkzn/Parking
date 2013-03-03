<%@page import="java.util.List"%>
<%@page import="ru.kpfu.parking.entities.Parking"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Добро пожаловать в Парковки!</title>
</head>
<body>
	<h2>Парковки.</h2>
	<table>
		<tbody>
			<c:forEach var="parking" items="${parkings}">
			<tr>
				<td>${parking.id}</td>
				<td>${parking.name}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="/add"  method="post">
		<input type="text" name="name" placeholder="Введите название парковки.">
		<input type="submit" value="Добавить парковку">
	</form>
</body>
</html>