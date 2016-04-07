<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Booking info</title>
<link rel="stylesheet" href="resources/css/mainStyleSheet.css" />
</head>
<body>
<jsp:include page="../jsp/fragments/header.jsp"></jsp:include>
	<h1 class="HomePageTextElements" id="TourDestinationsHeader"> Bookings information
		</h1>

			<c:if test="${!empty bookingList}">
				<table class="data">
					<tr>
						<th>Date from</th>
						<th>Date to</th>
						<th>Country</th>
						<th>City</th>
						<th>Hotel</th>
						<th>Client </th>
						<th>Room quantity</th>
					</tr>
					<c:forEach items="${bookingList}" var="booking">
						<tr>
							<td>${booking.dateFrom}</td>
							<td>${booking.dateTo}</td>
							<td>${booking.country.name}</td>
							<td>${booking.city.name}</td>
							<td>${booking.hotel.name}</td>
							<td>${booking.client.firstName} ${booking.client.lastName}</td>
							<td>${booking.roomQuantity}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
<table>
<tr>
<td>
			<a href="freeRoomsStatistics.html">Find free rooms
			</td>
			</tr>
			</table>


	<form:form method="post" action="addBooking">
		<div class="UserDivs" id="addHotelDiv">
			<h3>Add new booking</h3>
			<p>Date From</p>
			<input type="date" name="dateFrom">
			<p>Date To</p>
			<input type="date" name="dateTo">
			<p>Country</p>
			<select class="UserSelect" name="countryValue">
   				<c:forEach items="${countriesList}" var="country">
   					<option value="${country.id}">${country.name}</option>					
				</c:forEach>
			</select>
			<p>City</p>
			<select class="UserSelect" name="cityValue">
   				<c:forEach items="${citiesList}" var="city">
   					<option value="${city.id}">${city.name}</option>					
				</c:forEach>
			</select>
			<p>Hotel</p>
			<select class="UserSelect" name="hotelValue">
   				<c:forEach items="${hotelList}" var="hotel">
   					<option value="${hotel.id}">${hotel.name}</option>					
				</c:forEach>
			</select>
			<p>RoomQuantity</p>
			<input type="text" name="roomQuantity">
			<p>Hotel</p>
			<select class="UserSelect" name="clientValue">
   				<c:forEach items="${clientList}" var="client">
   					<option value="${client.id}">${client.lastName} ${client.firstName}</option>					
				</c:forEach>
			</select>
	<input type="submit" value="Add booking">
	</form:form>

</body>
</html>