<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css" rel="stylesheet">
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
</head>
<body>
<div class="container">
<h1>City Info</h1>
<table class="table">
  <tr>
    <th>Name</th>
    <th>Location Type</th>
    <th>IATA Code</th>
    <th>Latitude</th>
    <th>Longitude</th>
    <th>Travel Score</th>
  </tr>
   <c:forEach var="c"  items="${locations }">
  <tr>
<%--     <td>${jsonArray.getJSONObject(c).getString("name")}</td>
    <td>${jsonArray.getJSONObject(c).getString("subType")}</td>
    <td>${jsonArray.getJSONObject(c).getString("iataCode")}</td>
    <td>${jsonArray.getJSONObject(c).getString("latitude")}</td>
    <td>${jsonArray.getJSONObject(c).getString("longitude")}</td>
    <td>${jsonArray.getJSONObject(c).getString("score")}</td> --%>
    <td>${c.name }</td>
     <td>${c.subType }</td>
    <td>${c.iataCode }</td>
     <td>${c.geoCode.latitude }</td>
     <td>${c.geoCode.longitude }</td>
     <td>${c.analytics.travelers.score }</td>
  </tr>
  </c:forEach>
</table>
<br>
<h1>Points of Interest</h1>
${points }
<table class="table">
  <tr>
    <th>Name</th>
    <th>Location Type</th>
    <th>Latitude</th>
    <th>Longitude</th>
    <th>Travel Score</th>
    <th>Keywords</th>
  </tr>
   <c:forEach var="c"  items="${points}" varStatus="i">
  <tr>
<%--  <h1> ${c} </h1> stop --%>
<%--     <td>${jsonArray.getJSONObject(c).getString("name")}</td>
    <td>${jsonArray.getJSONObject(c).getString("subType")}</td>
    <td>${jsonArray.getJSONObject(c).getString("iataCode")}</td>
    <td>${jsonArray.getJSONObject(c).getString("latitude")}</td>
    <td>${jsonArray.getJSONObject(c).getString("longitude")}</td>
    <td>${jsonArray.getJSONObject(c).getString("score")}</td> --%>
     <td>${c.name }</td>
     <td>${c.category }</td>
     <td>${c.geoCode.latitude }</td>
     <td>${c.geoCode.longitude }</td>
     <td><%--  ${c.rank }  --%></td> 
	 <td><c:forEach var="a"  items="${c.tags }">${a}<br></c:forEach></td>
  </tr>
  </c:forEach>
</table>
</div>
</body>
</html>