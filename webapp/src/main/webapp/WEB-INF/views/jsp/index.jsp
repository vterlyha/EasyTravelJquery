<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
	<head>
    	<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">

    	<title>EasyTour</title>
    	<!-- Bootstrap -->
    	<link rel="stylesheet" href="resources/css/bootstrap.css" />
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  		<script src="resources/js/bootstrap.js"></script>
  	</head>
  	<body>
   		<jsp:include page="../jsp/fragments/header.jsp"></jsp:include>
   		<div class="container">
	   		<div id="myCarousel" class="carousel slide" data-ride="carousel">
				
				<!-- Indicators -->
				<ol class="carousel-indicators">
			    	<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			    	<li data-target="#myCarousel" data-slide-to="1"></li>
			    	<li data-target="#myCarousel" data-slide-to="2"></li>
			    	<li data-target="#myCarousel" data-slide-to="3"></li>
			    	<li data-target="#myCarousel" data-slide-to="4"></li>
			  	</ol>
	
	  			<!-- Wrapper for slides -->
	  			<div class="carousel-inner" role="listbox">
	    			<div class="item active">
	      				<img src="resources/images/egypt.jpg" alt="Egypt">
	      				<div class="carousel-caption">
	        				<h3>Egypt</h3>
	        				<p>Where everything begins</p>
	      				</div>
	    			</div>
					<div class="item">
	      				<img src="resources/images/florence.jpg" alt="Florence">
	      				<div class="carousel-caption">
	        				<h3>Florence</h3>
	        				<p>Cradle of renesance</p>
	      				</div>
	    			</div>
				    <div class="item">
				      	<img src="resources/images/montenegro.jpg" alt="Montenegro">
				      	<div class="carousel-caption">
				        	<h3>Montenegro</h3>
				        	<p>The pearl of the Mediterranean, unique in many ways</p>
				      	</div>
				    </div>
				    <div class="item">
				      	<img src="resources/images/paris.jpg" alt="Paris">
				      	<div class="carousel-caption">
				        	<h3>Paris</h3>
				        	<p>Is instantly recognisable</p>
				      	</div>
				    </div>
				  	<div class="item">
				      	<img src="resources/images/thiland.jpg" alt="Thailand">
				      	<div class="carousel-caption">
				        	<h3>Thailand</h3>
				        	<p>Is dramatic karst islands and relaxed beaches</p>
				      	</div>
				    </div>
				</div>
				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
					 <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					 <span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
					 <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					 <span class="sr-only">Next</span>
				</a>
			</div>
		</div>
  	</body>
</html>
