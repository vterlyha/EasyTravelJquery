<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
        <meta charset="utf-8">
        <title>Client info</title>
        <link rel="stylesheet" href="resources/css/bootstrap.css" />
		<link rel="stylesheet" href="resources/css/mainStyleSheet.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>  
    </head>
<body>
	<jsp:include page="../jsp/fragments/header.jsp"></jsp:include>
	<c:if test="${!empty clientList}">
		<div class="container">
			<table class="table table-striped" id="clientTable">
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
						<td>${client.address.city},${client.address.street},
							${client.address.houseNumber}, ${client.address.roomNumber}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>

	<form:form method="post" action="add" modelAttribute="client">
		<div class="container" id="mainClientContainer">
			<button type="button" class="btn btn-primary btn-block"
				data-toggle="collapse" data-target="#addClientCollapse">Add
				client</button>
			<div id="addClientCollapse" class="collapse">
				<br />
				<p class="text-info" >First name</p>
				<form:input path="firstName" class="form-control" />
				<br />

				<p class="text-info">Last name</p>
				<form:input path="lastName" class="form-control" />
				<br />

				<p class="text-info">E-mail</p>
				<form:input path="email" class="form-control" />
				<br />

				<p class="text-info">Phone number</p>
				<form:input path="phoneNumber" class="form-control" />
				<br />

				<h4 class="text-primary">Address</h4>
				<p class="text-info">City</p>
				<form:input path="address.city" class="form-control" />
				<p class="text-info">Street</p>
				<form:input path="address.street" class="form-control" />
				<p class="text-info">House number</p>
				<form:input path="address.houseNumber" class="form-control" />
				<p class="text-info">Flat number</p>
				<form:input path="address.roomNumber" class="form-control" />
				<br /> <input class="btn btn-primary btn-block" type="submit"
					value="Add">
			</div>
		</div>
		<%--<table>
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
				<td colspan="2"><input type="submit" value="Add client" /></td>
			</tr>
		</table>--%>
	</form:form>

</body>
</html>