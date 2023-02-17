<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete List of Pets</title>
</head>
<body>
	<form method = "post" action = "navigationServlet" >
		<table>
			<c:forEach items ="${requestScope.allPets}" var="currentpet">
				<tr>
					<td><input type="radio" name="id" value="${currentpet.id}"></td>
					<td>${currentpet.animal}</td>
					<td>${currentpet.breed}</td>
				</tr>
			</c:forEach>
		</table>
		<br> 
		<input type="submit" value="edit" name="doThisToPet">
		<input type="submit" value="delete" name="doThisToPet"> 
		<input type="submit" value="add" name="doThisToPet">
	</form>
</body>
</html>