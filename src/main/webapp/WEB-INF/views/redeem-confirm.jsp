<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css" rel="stylesheet">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="https://discovershareinspire.com/wp-content/uploads/2013/10/Vintage-map-faded.jpg">
<div class="container">
<h1>Congratulations, ${firstName }!</h1>
<br>
<h3>You've successfully redeemed TrekPoints for cash! Check your email at ${email } for a message with your reward link!
<br>
Points redeemed: ${points }
<br>
Points remaining: ${balance }
<br>
Value of points redeemed: $${value }
<br>
<a class="btn btn-warning btn-lg" href="login?eMail=${user.eMail }">Return to Menu</a>
</h3>
</div>
</body>
</html>