<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Client info</title>
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
			<br>
			
	<%-- Adding new hotel--%>
	<form:form action="addBooking" method="POST">
		<div class="UserDivs" id="addHotelDiv">
			<h3>Add new booking</h3>
			<p>Date From</p>
			<input type="date"  name="dateFrom">
			<p>Date To</p>
			<input type="date"  name="dateTo">
			<p>Country</p>
			<select class="UserSelect" name="countryValue">
				<option>--Countries--</option>
    			<c:forEach items="${countriesList}" var="country">
    				 <option>${country.name}</option>
   				</c:forEach>
   			</select>
			<p>City</p>
			<select class="UserSelect" name="cityValue">
				<option>--Cities--</option>
				<c:forEach items="${citiesList}" var="city">
					<option id="cityId" value="${city.id}">${city.name}</option>
				</c:forEach>
			</select>
			<p>Hotel</p>
			<select class="UserSelect" name="cityValue">
				<option>--Hotels--</option>
				<c:forEach items="${hotelsList}" var="hotel">
					<option>${hotel.name}</option>
				</c:forEach>
			</select>
			<p>RoomQuantity</p>
			<input type="text"  name="roomQuantity">
			<p>Client</p>
			<select class="UserSelect" name="cityValue">
				<option>--Clients--</option>
				<c:forEach items="${clientsList}" var="client">
					<option>${client.lastName} ${client.firstName}</option>
				</c:forEach>
			</select>
			<br>
			<input type="submit" value="Add booking">
		</div>
	</form:form>

</body>
</html>