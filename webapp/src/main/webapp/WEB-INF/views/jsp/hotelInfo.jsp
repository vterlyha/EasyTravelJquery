<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel info</title>
</head>
<body>
	<jsp:include page="../jsp/fragments/header.jsp"></jsp:include>
	<div class="UserDivs" id="countryDiv">
		<select class="UserSelect" id="countrySelect">
			<c:forEach items="${countries}" var="country">
				<option>${country.name}</option>
			</c:forEach>
		</select>
	</div>
	<div class="UserDivs" id="cityDiv">
		<select class="UserSelect" id="citySelect">
		</select>
	</div>
	<div class="UserDivs" id="hotelDiv">
		<select class="UserSelect" id="hotelSelect">
		</select>
	</div>
	
	
</body>
</html>