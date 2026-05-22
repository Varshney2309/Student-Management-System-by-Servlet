<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<div class="container">

		<h2>Admin Login</h2>

		<form action="login" method="post">

			Username: <input type="text" name="username"
				value="${rememberedUsername}" required> <br>
			<br> Password: <input type="password" name="password" required>

			<br>
			<br> Remember Username <input type="checkbox" name="remember">

			<br>
			<br> <input type="submit" value="Login">

		</form>

		<br>

		<p class="error">${error}</p>
	</div>

</body>
</html>