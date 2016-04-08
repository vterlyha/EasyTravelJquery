<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Hotel info</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
	<link rel="stylesheet" href="resources/css/mainStyleSheet.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</head>
<body>
	<jsp:include page="../jsp/fragments/header.jsp"></jsp:include>
	<%-- Displaying hotel data--%>
	<div class="container">
		<table class="table table-striped" id="hotelTable">
			<thead>
				<tr>
					<th>Number</th>
					<th>Hotel</th>
					<th>City</th>
					<th>Country</th>
					<th>Room quantity</th>
					<th>Clients booked</th>
					<th>Average booking span</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${generalHotels }" var="genHotel">
					<tr>
						<td>${genHotel.hotel.id }</td>
						<td>${genHotel.hotel.name}</td>
						<td>${genHotel.hotel.city.name }</td>
						<td>${genHotel.hotel.city.country.name }</td>
						<td>${genHotel.hotel.roomQuantity }</td>
						<td>${genHotel.numOfClients }</td>
						<td>${genHotel.avgStayLength }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
	<br/>
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<div class="well col-md-offset-0">
					<form:form action="insertHotel" method="POST">
						<button type="button" class="btn btn-primary btn-block" data-toggle="collapse" data-target="#addHotelCollapse">Add hotel</button>
						<div id="addHotelCollapse" class="collapse">
							<br/>
							<p class="text-info">Hotel name</p>
							<input type="text" class="form-control" name="hotelName" />
							<br/>
							<p class="text-info">Room quantity</p>
							<input type="text" class="form-control" name="hotelRoomQuantity" />
							<br/>
							<p class="text-info">City</p>
							<select class="form-control" name="cityValue">
								<c:forEach items="${cities}" var="city">
									<option class="text-info">${city.name}</option>
								</c:forEach>
							</select>
							<br/>
							<input class="btn btn-primary btn-block" type="submit" value="Add">
						</div>
					</form:form>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="well col-md-offset-3">
					<form:form action="insertCountry" method="POST" modelAttribute="country">
						<button type="button" class="btn btn-primary btn-block" data-toggle="collapse" data-target="#addCountryCollapse">Add country</button>
						<div id="addCountryCollapse" class="collapse">
							<br/>
							<p class="text-info">Country name</p>
							<input class="form-control" name="countryName" />
							<br/>
							<label class="checkbox-inline text-info"><input type="checkbox" name="visaRequired" >Visa required</label>
							<br/><br/>
							<input class="btn btn-primary btn-block" type="submit" value="Add">
						</div>
					</form:form>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="well col-md-offset-3">
					<form:form action="insertCity" method="POST">
						<button type="button" class="btn btn-primary btn-block" data-toggle="collapse" data-target="#addCityCollapse">Add city</button>
						<div id="addCityCollapse" class="collapse">
							<br/>
							<p class="text-info">City name</p>
							<input name="cityName" class="form-control"/>
							<br/>
							<p class="text-info">Country</p>
							<select class="form-control" name="countryValue">
								<c:forEach items="${countries}" var="country">
									<option class="text-info">${country.name}</option>
								</c:forEach>
							</select>
							<br/>
							<input class="btn btn-primary btn-block" type="submit" value="Add">
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>