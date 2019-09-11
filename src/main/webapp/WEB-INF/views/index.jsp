<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css"
	rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body background="https://discovershareinspire.com/wp-content/uploads/2013/10/Vintage-map-faded.jpg">
	<div class="container">
		<h1>Welcome ${userInfo.userName }!</h1>
		<form action="main-search">
			<!-- 		<input type="text" name="msearch" placeholder="Search by City" style="width: 50%;"> -->
			<select name="msearch">
				<option value="London">London</option>
				<option value="New York">New York</option>
				<option value="Barcelona">Barcelona</option>
				<option value="Bangalore">Bangalore</option>
				<option value="Berlin">Berlin</option>
				<option value="Dallas">Dallas</option>
				<option value="Paris">Paris</option>
				<option value="San Francisco">San Francisco</option>
			</select> <input class="btn btn-primary" type="submit" value="Search">
		</form>



		<div>
			<h3>Your Information</h3>
			<%--     <p></p> <!-- Why doesn't this work? --> --%>
			<p>${userInfo.userName }</p>
			<p>${userInfo.eMail }</p>
			<p>${userInfo.currentPoints }PointsAccumulated</p>
			<p>Your Home Location ${userInfo.homeBase }</p>
			<h3>Locations Visited</h3>
			<p>${userInfo.locVisited }</p>
			<!-- Add a loop around this for mult. locations -->
			<h3>Favorite Cities</h3>
			<p>${userInfo.favCities }</p>
			<!-- Add a loop around this for mult. locations -->
			<h3>Favorite Activities</h3>
			<p>${userInfo.favActivities }</p>
			<!-- Add a loop around this for mult. locations -->

		</div>
		
		<div>
		<c:forEach var="img" items="${imageList }">
		<img src="${img.url}">
		
		</c:forEach>
		
		
		</div>

	</div>

</body>
</html>