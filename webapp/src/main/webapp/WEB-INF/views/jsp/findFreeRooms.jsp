<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Free rooms</title>
<link rel="stylesheet" href="resources/css/mainStyleSheet.css" />
</head>
<body>
<jsp:include page="../jsp/fragments/header.jsp"></jsp:include>
	<h1 class="HomePageTextElements" id="TourDestinationsHeader"> Find free rooms
		</h1>
		<c:if test="${!empty hotelCount}">
		<p>${hotelCount}</p>
		</c:if>
			<p>Date From</p>
			<input type="date" name="dateFrom">
			<p>Date To</p>
			<input type="date" name="dateTo">
			<p>Hotel</p>
			<select class="UserSelect" name="hotelValue">
   				<c:forEach items="${hotelList}" var="hotel">
   					<option value="${hotel.id}">${hotel.name}</option>					
				</c:forEach>
			</select>

</body>
</html>