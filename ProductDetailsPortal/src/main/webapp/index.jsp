<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>Enter Product Details</h2>
<form action="ProductServlet" method="get">
Product ID: <input type="text" name="productId"><br/>
Price: <input type="text" name="price"><br/>
Product Category: <input type="text" name="productCategory"><br/>
Product Name: <input type="text" name="productName"><br/>
<input type="submit" value="Submit">
</form>
</div>
</body>
</html>