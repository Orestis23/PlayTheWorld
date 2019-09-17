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
<title>Be A TrekStar</title>

<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css" rel="stylesheet" integrity="sha384-9NlqO4dP5KfioUGS568UFwM3lbWf3Uj3Qb7FBHuIuhLoDp3ZgAqPE1/MYLEBPZYM" crossorigin="anonymous"></head>
<body background="https://discovershareinspire.com/wp-content/uploads/2013/10/Vintage-map-faded.jpg">

<div align="center">
<h1><font size="8" style = "font-family:georgia">Trek Star</font> </h1>
<img src="https://cdn.pixabay.com/photo/2016/04/19/20/36/globe-1339833_960_720.png" height="300" width="300">
<h3>

<p style = "font-family:georgia"> <font size="5">Share your experiences with others from around the world! Upload images of you with your 
family and friends and leave reviews of popular Restaurants and Activities you enjoy.</p>  

<p style = "font-family:georgia">The further you travel from home, the more TrekPoints you receive to increase your ranking
within the TrekStar community!  Other TrekStars want to see the world and you can help them decide
which memories to create!</p></font>
</h3>
</div>


<div align="center">
Register here!

<form action="submit-person" method="post">
		<input type="text" class="form-control" name="userName" placeholder="Enter your User-Name" style="width: 50%;" required>
		<input type="email" class="form-control" name="eMail" placeholder="email@domain.com" style="width: 50%;" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>	 
		<input type="password" class="form-control" name="password" placeholder="Enter your Password" style="width: 50%;" required> 
		<input type="homebase" class="form-control" name="homeBase" placeholder="Enter your Home City" style="width: 50%;" required> 
		<input class="btn btn-primary" type="submit" value="Register">
	</form>
	
Login with the e-mail address you used when you created your account.

<form action="login" method="post">
		<input type="email" class="form-control" name="eMail" placeholder="email@domain.com" style="width: 50%;" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">	 
		<input type="password" class="form-control" name="password" placeholder="Enter your Password" style="width: 50%;"> 
		<input class="btn btn-primary" type="submit" value="Login">
	</form>
</div>	
</body>
</html>