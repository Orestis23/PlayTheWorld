<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attraction-Type View</title>

<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css" rel="stylesheet" integrity="sha384-9NlqO4dP5KfioUGS568UFwM3lbWf3Uj3Qb7FBHuIuhLoDp3ZgAqPE1/MYLEBPZYM" crossorigin="anonymous"></head>
<body background="https://www.telegraph.co.uk/content/dam/Travel/2017/March/sudan-meroe.jpg")>

<h1>Attraction Type</h1>
	<table class="table">
		<tr>
		
			<th>Attraction Name</th>
			<th>Attraction Description</th>
			<th>Other Attraction Info (based on available API Data)</th>
			
		</tr>
		<c:forEach var="at" items="${list }" varStatus="i">
		<tr>
			<td>${at.name }</td> 
			<td>${at.category }</td>
			<td>${at.tags }</td>
		
		</tr>
		</c:forEach>
	</table>

</body>
</html>


