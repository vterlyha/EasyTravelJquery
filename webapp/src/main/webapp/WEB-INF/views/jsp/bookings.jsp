<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client info</title>
</head>
<body>
<jsp:include page="../jsp/fragments/header.jsp"></jsp:include>
	<h1 class="HomePageTextElements" id="TourDestinationsHeader"> Clients information
		</h1>

			<c:if test="${!empty bookingList}">
				<table class="data">
					<c:forEach items="${bookingList}" var="booking">
						<tr>
							<td>${booking.dateFrom}</td>
							<td>${booking.dateTo}</td>
							<td>${booking.country.name}</td>
							<td>${booking.city.name}</td>
							<td>${booking.hotel.name}</td>
							<td>${booking.client.firstName}</td>
							<td>${booking.client.lastName}</td>
							<td>${booking.roomQuantity}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>

</body>
</html>