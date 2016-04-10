<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Booking info</title>
<link rel="stylesheet" href="resources/css/bootstrap.css" />
<link rel="stylesheet" href="resources/css/mainStyleSheet.css" />
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bookings.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/lib/jquery-1.12.1.js" type="text/javascript"></script>
</head>
<body>
	<jsp:include page="../jsp/fragments/header.jsp"></jsp:include>
	<div class="container">
		<c:if test="${!empty bookingList}">
			<table class="table table-striped" id="bookingsTable">
				<tr>
					<th>Date from</th>
					<th>Date to</th>
					<th>Country</th>
					<th>City</th>
					<th>Hotel</th>
					<th>Client</th>
					<th>Room quantity</th>
				</tr>
				<c:forEach items="${bookingList}" var="booking">
					<tr>
						<td>${booking.dateFrom}</td>
						<td>${booking.dateTo}</td>
						<td>${booking.country.name}</td>
						<td>${booking.city.name}</td>
						<td>${booking.hotel.name}</td>
						<td>${booking.client.firstName}${booking.client.lastName}</td>
						<td>${booking.roomQuantity}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<table id="refTable">
		<tr>
			<td><a class="text-primary" href="freeRoomsStatistics.html">Find free rooms</a></td>
		</tr>
	</table><br/>


	<div data-ng-app="" class="container" id="mainBookingContainer">
		<form:form method="post" action="addBooking">
			<button type="button" class="btn btn-primary btn-block"
				data-toggle="collapse" data-target="#addBookingCollapse">Add
				booking</button>
			<div id="addBookingCollapse" class="collapse"><br/>
				<p class="text-info">Date From</p>
				<input type="date" class="form-control" name="dateFrom">
				<br/>
				<p class="text-info">Date To</p>
				<input type="date" class="form-control" name="dateTo">
				<br/>
				<p class="text-info">Country</p>
				<select class="form-control" name="countryId">
					<option>Select country</option>
					<c:forEach items="${countriesList}" var="country">
						<option value="${country.id}" class="text-info">${country.name}</option>
					</c:forEach>
				</select>
				<br/>
				<p class="text-info">City</p>
				<select class="form-control" name="cityId">
					<option>Select city</option>
				</select>
				<br/>
				<p class="text-info">Hotel</p>
				<select class="form-control" name="hotelId">
					<option>Select hotel</option>
				</select>
				<br/>
				<p class="text-info">RoomQuantity</p>
				<input type="text" class="form-control" data-ng-model="roomQuantity" name ="roomQuantity">
				<br/>
				<p class="text-info">Hotel</p>
				<select class="form-control" name="clientId">
					<c:forEach items="${clientList}" var="client">
						<option value="${client.id}" class="text-info">${client.lastName}
							${client.firstName}</option>
					</c:forEach>
				</select> <br/>
				<input type="submit" class="btn btn-primary btn-block" value="Add booking">
			</div>
		</form:form>
	</div>


</body>
</html>