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
<title>Attraction-Type View</title>
	</head>
	
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


