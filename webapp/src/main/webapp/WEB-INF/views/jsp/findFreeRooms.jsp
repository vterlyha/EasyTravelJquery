<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Free rooms</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css" />
	<link rel="stylesheet" href="resources/css/mainStyleSheet.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>
</head>
<body>
<jsp:include page="../jsp/fragments/header.jsp"></jsp:include>

	<div class="container" id="findFreeRooms">
		<h2 class="text-primary">Find free rooms</h2>
		<form:form method="get" action="findFreeRooms">
			<br />
			<p class="text-info">Date From</p>
			<input type="date" class="form-control" name="dateFrom">
			<br />
			<p class="text-info">Date To</p>
			<input type="date" name="dateTo" class="form-control">
			<br />
			<p class="text-info">Hotel</p>
			<select name="hotelValue" class="form-control">
				<c:forEach items="${hotelList}" var="hotel">
					<option value="${hotel.id}" class="text-info">${hotel.name}</option>
				</c:forEach>
			</select>
			<br />
			<input type="submit" class="btn btn-primary btn-block"
				value="Search">
		</form:form>
	</div>
</body>
</html>