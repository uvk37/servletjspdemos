<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>One step away from flying away !!</h1>
	<div class="container1">
<form action=FlightList method="get">
	<div class="item" ><input type="text" placeholder="Email id" class="tb"  name="emailid" /></div>	
	<div class="item" ><input type="text" placeholder="Name on Card" class="tb"  name="nameoncard" /></div>
	<div class="item" ><input type="text" placeholder="Card Number" class="tb"  name="cardnumber" /></div>
	<div class="item" ><input type="text" placeholder="CVV" class="tb"  name="cvv" /></div>
	<div style="color:white; margin: 10px; text-align:center;">Card Expiry Date</div>
	<div class="item" ><input type="date" class="tb" name="date" /></div>
	<div ><input type="submit" value="Make Payment" class="btn"  /></div>
</form>
</div>
</body>
</html>