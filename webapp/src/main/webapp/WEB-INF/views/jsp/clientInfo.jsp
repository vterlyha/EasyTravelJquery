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
        <link rel="stylesheet" href="resources/css/bootstrap.css" />      
    </head>
<body>
	<jsp:include page="../jsp/fragments/header.jsp"></jsp:include>
	<h1 class="HomePageTextElements" id="TourDestinationsHeader"> Clients information
		</h1>
			<c:if test="${!empty clientList}">
				<table class="allInfo">
					<tr>
						<th>First Name, Last Name</th>
						<th>Email</th>
						<th>PhoneNumber</th>
						<th>Adress</th>
					</tr>
					<c:forEach items="${clientList}" var="client">
						<tr>
							<td><a href="clientVisasInfo.html?clientId=${client.id}">${client.lastName} 
							${client.firstName}</a></td>
							<td>${client.email}</td>
							<td>${client.phoneNumber}</td>
							<td>${client.address.city}, ${client.address.street}, ${client.address.houseNumber}, 
							${client.address.roomNumber}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>

	<form:form method="post" action="add" modelAttribute="client">			
		<table>
			<tr>
				<td>First Name</td>
        		<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>PhoneNumber</td>
				<td><form:input path="phoneNumber" /></td>
			</tr>
			<tr>
				<td>Adress</td>
				<td><form:input path="address.city" />City</td>
				<td><form:input path="address.street" />Street</td>
				<td><form:input path="address.houseNumber" />House number</td>
				<td><form:input path="address.roomNumber" />Room number</td>

			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="Add client"/></td>
			</tr>
		</table>
	</form:form>

</body>
</html>