<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
	<head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="resources/css/bootstrap.css" />  
        <link rel="stylesheet" href="resources/css/mainStyleSheet.css" />  
    </head>
  <body>
  	
    <div class="container">
    	<h2 class="text-primary">Easy Tour <small class="text-info">Perfect way to plan your vacation</small></h2>
	    <nav class="navbar navbar-inverse" id="Navbar">
	        <div class="container-fluid">
	            <ul class="nav navbar-nav">
	                <li class="navbarLi">
	                	<a class="navbarRef" id="ref1" href="<spring:url value="/"/>">Home</a>
	                </li>
	                <li class="navbarLi">
	                	<a class="navbarRef" id="ref2" href="<spring:url value="/clientInfo"/>">Clients</a>
	                </li>
	                <li class="navbarLi">
	                	<a class="navbarRef" id="ref3" href="<spring:url value="/hotelInfo"/>">Cities and hotels</a>
	                </li>
	                <li class="navbarLi">
	                	<a class="navbarRef" id="ref3" href="<spring:url value="/bookingsAngular"/>">Bookings</a>
	                </li>
	            </ul>
	        </div>
	     </nav>
    </div>
    
  </body>
</html>
