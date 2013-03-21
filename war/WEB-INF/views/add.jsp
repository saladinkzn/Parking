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
	</head>
	<body>
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
					<input type="text" name="latitude" placeholder="Введите широту.">
				</p>
				<p>
					<input type="text" name="longitude" placeholder="Введите долготу.">
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