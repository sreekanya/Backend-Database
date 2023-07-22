<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eStore Web</title>
</head>
<body>
	<h3>Welcome to JSP </h3>
	<%
		int a=10;
		int b=20;
		int c= a+b;
		out.print("value of c is"+c);
	%>
	
	<a href="tags.jsp">JSP Tags </a>
	
	<div style="text-align:center;">
		<h3>Register User</h3>
		<form action = "register.jsp" method="post">
			Enter Name <br />
			<input type="text" name="txtName" /><br /><br />
			Enter Email <br />
			<input type="text" name="txtEmail" /><br /><br />
			Enter Password <br />
			<input type="password" name="txtPassword" /><br /><br />
			<input type="submit" value="Register" />
		</form>
		
		<a href="login-user.html">Existing User..Login</a>
	
	</div>
</body>
</html>