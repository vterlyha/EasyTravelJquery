<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Available rooms</title>
<link rel="stylesheet" href="resources/css/mainStyleSheet.css" />
</head>
<body>
	<jsp:include page="../jsp/fragments/header.jsp"></jsp:include>
	<div class="container" id="freeRooms">
		<h2 class="text-primary">Available rooms</h2>
		<p class="text-info">Hotel: ${hotel.name}</p>
		<p class="text-info">Booked rooms on this dates: ${bookedRooms}</p>
		<p class="text-info">All rooms in the hotel: ${roomQuantity}</p>
		<p class="text-info">Available rooms: ${availableRooms}</p>
	</div>
</body>
</html>