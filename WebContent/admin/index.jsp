<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Evergreen Bookstore</title>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<div align="center">
		<h3>Administrative Dashboard</h3>
	</div>
	<div align="center">
		<hr width="60%"/>
		<h2>Quick Actions:</h2>
		<b>
		<a href="create_book">New Book</a> &nbsp;
		<a href="create_user">New User</a> &nbsp;
		<a href="create_category">New Category</a> &nbsp;
		<a href="create_customer">New Customer</a> &nbsp;
		</b>
	</div>
	
	<div align="center">
		<hr width="60%"/>
		<h2>Recent Sales:</h2>
	</div>
	
		<div align="center">
		<hr width="60%"/>
		<h2>Recent Review:</h2>
	</div>
	
		<div align="center">
		<hr width="60%"/>
		<h2>Statistics:</h2>
		<hr width="60%"/>
	</div>
	
		<jsp:directive.include file="footer.jsp"/>
</body>
</html>