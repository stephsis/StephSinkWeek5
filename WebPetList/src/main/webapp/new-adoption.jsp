<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Adoption</title>
</head>
<body>

	<form action="createNewAdoptionServlet" method="post">
		Adopted Pet: <input type="text" name="adoptionList"><br>
		Adopted Date: <input type="text" name="month" placeholder="mm" size="4"> 
		<input type="text" name="day" placeholder="dd" size="4"> 
		<input type="text" name="year" placeholder="yyyy" size="4"> 
		Adopted By: <input type="text" name="adoptedBy"><br>

		Available Pets:<br> <select name="allPetsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allPets}" var="currentpet">
				<option value="${currentpet.id}">${currentpet.animal} | ${currentpet.breed}</option>
			</c:forEach>
		</select> <br> <input type="submit" value="Add Pet to Adopted List">
	</form>
</body>
</html>