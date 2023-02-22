<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>See Who's Been Adopted</title>
</head>
<body>

	<form method="post" action="adoptionnavigationServlet">
		<table>
			<c:forEach items="${requestScope.allPets}" var="currentpet">
				<tr>
					<td><input type="radio" name="id" value="${currentpet.id}"></td>
					<td><h2>${currentpet.adoptionList}</h2></td>
				</tr>

				<tr>
					<td colspan="3">Adoption Date: ${currentpet.adoptionDate}</td>
				</tr>

				<tr>
					<td colspan="3">Adoption: ${currentpet.adopted.adoptedBy}</td>
				</tr>
				<c:forEach var="listVal" items="${currentpet.listOfPets}">
					<tr>
						<td colspan="3">${listVal.animal}, ${listVal.breed}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToPet"> 
		<input type="submit" value="delete" name="doThisToPet"> 
		<input type="submit" value="add" name="doThisToPet">
	</form>
	<br>
	<a href="addPetForAdoptionServlet">Create a new adoption</a>
	<br>
	<a href="index.html">Insert a new pet</a>

</body>
</html>