<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit An Adoption</title>
</head>
<body>

	<form action="editAdoptionDetailsServlet" method="post">
		<input type="hidden" name="id" value="${adoptionToEdit.id}">
		Adopted Pet: <input type="text" name="adoptionList" value="${adoptionToEdit.adoptionList}"><br> 
		Adopted Date: <input type="text" name="month" placeholder="mm" size="4" value="${month}"> 
		<input type="text" name="day" placeholder="dd" size="4" value="${date}"> 
		<input type="text" name="year" placeholder="yyyy" size="4" value="${year}">

		Adopted By: <input type="text" name="adoptedBy" value="${adoptionToEdit.adoption.adoptedBy}"><br>

		Available Pets:<br> <select name="allAdoptionsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allAdoptions}" var="currentadoption">
				<option value="${currentadoption.id}">${currentadoption.animal} | ${currentadoption.breed}</option>
			</c:forEach>
		</select> <br> <input type="submit"
			value="Edit Adoption and Add A New Adoption">
	</form>
	<a href="index.html">Go add new pets instead.</a>

</body>
</html>