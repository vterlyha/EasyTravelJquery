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
	<form:form action="addBooking" method="post" modelAttribute="booking">
		<div class="UserDivs" id="addHotelDiv">
			<h3>Add new booking</h3>
			<p>Date From (yyyy/mm/dd)</p>
			<form:input path="dateFrom" />
			<p>Date To (yyyy/mm/dd)</p>
			<form:input path="dateTo" />
			<p>Country</p>
			<form:select path="country">
			<c:forEach items="${countriesList}" var="country">
				<form:option value="${country.name}"/>
			</c:forEach>
			</form:select>
			<p>City</p>
			<form:select path="city">
			<c:forEach items="${citiesList}" var="city">
				<form:option value="${city.name}"/>
			</c:forEach>
			</form:select>
			<p>Hotel</p>
			<form:select path="hotel">
			<c:forEach items="${hotelList}" var="hotel">
				<form:option value="${hotel.name}"/>
			</c:forEach>
			</form:select>
			<p>RoomQuantity</p>
			<form:input path="roomQuantity" />
			<p>Client</p>
			<form:select path="client">
			<c:forEach items="${clientList}" var="client">
				<form:option value="${client.lastName} ${client.firstName}"/>
			</c:forEach>
			</form:select>

			<br>
			<input type="submit" value="Add booking">
			</div>
	</form:form>

</body>
</html>