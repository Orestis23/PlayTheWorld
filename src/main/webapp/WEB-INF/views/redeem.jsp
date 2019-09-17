<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css"
	rel="stylesheet">
<head>
<meta charset="ISO-8859-1">
<title>Points Redemption</title>
</head>
<body>
<body background="https://discovershareinspire.com/wp-content/uploads/2013/10/Vintage-map-faded.jpg">
<div class="container">
<a class="btn btn-warning" href="login?eMail=${user.eMail }">Go Back</a>
<h1>Redeem Points</h1>

<form action="redeem-points" method="POST">
	<h4>How many points do you want to redeem? Please enter a multiple of 100.</h4>
		<input type="number" class="form-control" name="points" placeholder="How many points?" style="width: 20%;" step="100" title="Must be a multiple of 100" required>	 
		<input type="text" class="form-control" name="firstName" placeholder="First Name" style="width: 50%;" required>
		<input type="text" class="form-control" name="lastName" placeholder="Last Name" style="width: 50%;" required>
		<input type="email" class="form-control" name="eMail" placeholder="email@domain.com" style="width: 50%;" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>
		<input class="btn btn-primary" type="submit" value="Redeem">
</form>

</div>
</body>
</html>