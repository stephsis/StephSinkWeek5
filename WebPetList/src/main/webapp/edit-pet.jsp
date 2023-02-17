<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit A Pet</title>
</head>
<body>

	<form action="editPetServlet" method="post">
		<div class="form-group">
			<label for="animal">Animal:</label>
			<input type="text" name="animal" value="${petToEdit.animal}">
			<br>
		</div>
		<div class="form-group">
			<label for="breed">Breed:</label> 
			<input type="text" name="breed" value="${petToEdit.breed}">
			<br>
		</div>
		<input type="hidden" name="id" value="${petToEdit.id}"> 
		<br>
		<input type="submit" value="Save Edited Pet">
	</form>

</body>
</html>