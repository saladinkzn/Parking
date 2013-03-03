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
			<%-- Здесь мы получаем список парковок, добавленных в контроллере методом request.setAttribute("parkings", ..) --%>
			<c:forEach var="parking" items="${parkings}">
			<tr>
				<%-- parking.id аналогично <%=parking.getId()%> Т.е. берем значение поля id ч/з геттер и подставляем. --%>
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