<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <spring:url value="/resources/css/bootstrap.css" var="bootstrapCss" />
<!--      <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">-->
  </head>
  <body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">EasyTour</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="<spring:url value="/pages/clientInfo"/>">Clients</a></li>
                <li><a href="<spring:url value="/pages/hotelInfo"/>">Cities and hotels</a></li>
                <li><a href="<spring:url value="/pages/bookings"/>">Bookings</a></li>
            </ul>
        </div>
      </nav>
  </body>
</html>
