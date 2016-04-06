<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Hotel info</title>
<link rel="stylesheet" href="resources/css/mainStyleSheet.css" />
</head>
<body>
	<jsp:include page="../jsp/fragments/header.jsp"></jsp:include>
	<form:form action="selectCity" method="GET" id="SelectDataForm">
		<div class="UserDivs" id="countryDiv">
			<select class="UserSelect" id="countrySelect" name="countryValue" onchange="submit()">
				<option>--Countries--</option>
				<c:forEach items="${countries}" var="country">
					<option>${country.name}</option>
				</c:forEach>
			</select>
		</div>
		<input value="Submit countries" type="submit">
		<div class="UserDivs" id="cityDiv">
			<select class="UserSelect" id="citySelect" name="cityValue">
				<option>--Cities--</option>
				<c:forEach items="${cities}" var="city">
					<option>${city.name}</option>
				</c:forEach>
			</select>
		</div>
		<input value="Submit cities" type="submit">
		<div class="UserDivs" id="hotelDiv">
			<select class="UserSelect" id="hotelSelect">
				<option>--Hotels--</option>
				<c:forEach items="${hotels}" var="hotel">
					<option>${hotel.name}</option>
				</c:forEach>
			</select>
		</div>
	</form:form>
</body>
</html>