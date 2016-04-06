<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Client info</title>
<link rel="stylesheet" href="resources/css/mainStyleSheet.css" />
</head>
<body>
<jsp:include page="../jsp/fragments/header.jsp"></jsp:include>
	<h1 class="HomePageTextElements" id="TourDestinationsHeader"> 
${neededClient.firstName} ${neededClient.lastName}

	</h1>

			<c:if test="${!empty countriesVisited}">
				<table class="data">					
					<tr>
						<td>Countries client visited: </td>
						<c:forEach items="${countriesVisited}" var="country">
							<td>${country}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>How many visas he already has: </td>
						<c:forEach items="${countCountries}" var="count">
							<td>${count}</td>
						</c:forEach>
					</tr>						
				</table>
			</c:if>

</body>
</html>