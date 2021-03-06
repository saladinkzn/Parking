﻿<%@page import="java.util.List"%>
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
		<thead>
			<tr>
				<th>Идентификатор</th>
				<th>Название</th>
				<th>Адрес</th>
				<th>Широта</th>
				<th>Долгота</th>
				<th>Режим работы</th>
				<th>Стоимость за час</th>
				<th>Описание</th>
				<th> </th>
				<th> </th>
			</tr>
		</thead>
		<tbody>
			<%-- Здесь мы получаем список парковок, добавленных в контроллере методом request.setAttribute("parkings", ..) --%>
			<c:forEach var="parking" items="${parkings}">
			<tr>
				<%-- parking.id аналогично <%=parking.getId()%> Т.е. берем значение поля id ч/з геттер и подставляем. --%>
				<td>${parking.id}</td>
				<td>${parking.name}</td>
				<td>${parking.address}</td>
				<td>${parking.latitude}</td>
				<td>${parking.longitude}</td>
				<td>${parking.workingPlan}</td>
				<td>${parking.pricing}</td>
				<td>${parking.description}</td>
				<td>
				<form action="/ad1" method="POST">
                 <input type="hidden" name="id" value="${parking.id}">
                <input type="submit" value="Удалить">
                </form>
                <td>
                <td>
				<form action="ad2" method="POST">
                 <input type="hidden" name="id" value="${parking.id}">
                <input type="submit" value="Пропустить">
                </form>
                <td>
			</tr>
		
			</c:forEach>
		</tbody>
	</table>
	<hr>

</body>
</html>