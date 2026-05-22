<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<div class="container">

		<h2>Student Course Registration</h2>

		<form action="save" method="post">

			Student ID: <input type="number" name="studentId" required> <br>
			<br> Course ID: <input type="number" name="courseId" required> <br>
			<br> Registration Date: <input type="date"
				name="registrationDate" required> <br> <br> Status: <select
				name="status">

				<option value="ACTIVE">ACTIVE</option>

				<option value="COMPLETED">COMPLETED</option>

			</select> <br> <br> <input type="submit" value="Register">

		</form>

		<br>

		<p class="error">${error}</p>

		<br> <a href="../dashboard"> Back To Dashboard </a>
	</div>

</body>
</html>