<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
	<head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="resources/css/mainStyleSheet.css" />
        <link href="${mainCss}" rel="stylesheet" />       
    </head>
  <body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">

            <ul class="nav navbar-nav">
                <li class="active"><a href="<spring:url value="/"/>">Home</a></li>
                <li><a href="<spring:url value="/clientInfo"/>">Clients</a></li>
                <li><a href="<spring:url value="/hotelInfo"/>">Cities and hotels</a></li>
                <li><a href="<spring:url value="/bookings"/>">Bookings</a></li>
            </ul>
        </div>
      </nav>
  </body>
</html>
