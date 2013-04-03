<%@page import="java.util.List"%>
<%@page import="ru.kpfu.parking.entities.Parking"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCS97OWSxbjS5RMAs58zQVDwOzGwUM8XS0&sensor=false">
</script>
<script type="text/javascript" src="/resources/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/resources/js/index.js"></script>
<style type="text/css">
html {
	height: 100%
}

body {
	height: 100%;
	margin: 0;
	padding: 0
}

#map-canvas {
	height: 100%
}
</style>
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
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	<a href="/add"> Добавить новую парковку </a>
	<div id="map-canvas"></div>
</body>
</html>