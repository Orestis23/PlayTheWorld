<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css"
	rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>Welcome to Trek Star!</title>

<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css" rel="stylesheet" integrity="sha384-9NlqO4dP5KfioUGS568UFwM3lbWf3Uj3Qb7FBHuIuhLoDp3ZgAqPE1/MYLEBPZYM" crossorigin="anonymous"></head>
<body background="https://discovershareinspire.com/wp-content/uploads/2013/10/Vintage-map-faded.jpg">

<div align="center">
<h1>Trek Star</h1>
<img src="http://www.clipartbest.com/cliparts/LcK/zLx/LcKzLxLca.jpeg">
<h3>
Traveling the world gives you points in life!  Track how many points you have in life by trekking across the world with Trek Star!  
The further you travel the more points you'll get.  
Upload pictures and stuff for points etc etc etc
</h3>
</div>


<div align="center">
Register here!

<form action="register">
		<input type="text" name="userName" placeholder="Enter your User-Name" style="width: 50%;">
		<input type="text" name="eMail" placeholder="Enter your E-mail Address" style="width: 50%;"> 
		<input type="text" name="password" placeholder="Enter your Password" style="width: 50%;"> 
		<input class="btn btn-primary" type="submit" value="Register">
	</form>
	
Login with the e-mail address you used when you created your account.

<form action="login">
		<input type="text" name="eMail" placeholder="Enter your E-Mail Address" style="width: 50%;"> 
		<input type="text" name="password" placeholder="Enter your Password" style="width: 50%;"> 
		<input class="btn btn-primary" type="submit" value="Login">
	</form>
</div>	
</body>
</html>