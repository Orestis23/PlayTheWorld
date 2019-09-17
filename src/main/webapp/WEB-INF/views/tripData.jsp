<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>See Others' Experiences</title>

<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9NlqO4dP5KfioUGS568UFwM3lbWf3Uj3Qb7FBHuIuhLoDp3ZgAqPE1/MYLEBPZYM"
	crossorigin="anonymous">
</head>
<body
	background="https://discovershareinspire.com/wp-content/uploads/2013/10/Vintage-map-faded.jpg">

	<c:forEach var="usInfo" items="${userTripInfo }">
		<h1>${usInfo.userName }</h1><br>
		<c:forEach var="usImg" items="${usInfo.imageList }">
		
		<img src="${usImg.url }">
		</c:forEach>
		<br>
		<c:forEach var="usLoc" items="${usInfo.locVisList }">
		
		${usLoc.activityName }<br>
		</c:forEach>
		
		
		

	</c:forEach>

	


</body>
</html>