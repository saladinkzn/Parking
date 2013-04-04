<%@page import="java.util.List"%>
<%@page import="ru.kpfu.parking.entities.Parking"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title> Добавление новой парковки </title>
		<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCS97OWSxbjS5RMAs58zQVDwOzGwUM8XS0&sensor=false">
		</script>
		<script type="text/javascript" src="/resources/js/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="/resources/js/add.js"></script>
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
	</head>
	<body>
		<div id="map-canvas"></div>
		<div>
			<form action="/add"  method="post">
				<h3>Добавление парковки</h3>
				<p>
					<input type="text" name="name" placeholder="Введите название парковки.">
				</p>
				<p>
					<input type="text" name="address" placeholder="Введите адрес парковки.">
				</p>
				<p>
					<input type="hidden" name="latitude">
				</p>
				<p>
					<input type="hidden" name="longitude">
				</p>
				<p>
					<input type="text" name="workingPlan" placeholder="Введите часы работы.">
				</p>
				<p>
					<input type="text" name="pricing" placeholder="Введите цену.">
				</p>
				<p>
					<textarea rows="10" cols="45" name="description" placeholder="Введите описание."></textarea>
				</p>
				<p>
					<input type="submit" value="Добавить парковку"> | <a href="/"> На главную </a>
				</p>
			</form>
		</div>
	</body>
</html>