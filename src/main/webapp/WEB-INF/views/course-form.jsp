<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Course</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<div class="container">
		<h2>Add Course</h2>

		<form action="add" method="post">

			Course Name: <input type="text" name="courseName" required> <br>
			<br> Duration: <input type="text" name="duration" required> <br>
			<br> Fees: <input type="number" name="fees" required> <br> <br>
			Trainer Name: <input type="text" name="trainerName" required> <br>
			<br> <input type="submit" value="Add Course">

		</form>

		<br>

		<p class="error">${error}</p>

		<br> <a href="../dashboard"> Back To Dashboard </a>
	</div>

</body>
</html>