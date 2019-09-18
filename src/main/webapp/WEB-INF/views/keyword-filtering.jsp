<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css"
	rel="stylesheet">
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
</head>
<body background="https://discovershareinspire.com/wp-content/uploads/2013/10/Vintage-map-faded.jpg">
<div class="container">
<a class="btn btn-warning" href="login?eMail=${user.eMail }">Go Back</a>
	${keyword }
		<h1>Points of Interest</h1>
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Location Type</th>
				<th>Latitude</th>
				<th>Longitude</th>
				<th>Travel Score</th>
				<th>Keywords</th>
			</tr>
			<c:forEach var="c" items="${points}" varStatus="i">
				<c:forEach var="b" items="${c.tags }">
					<c:if test="${b eq keyword}">
						<tr>
							<td>${c.name }</td>
							<td>${c.category }</td>
							<td>${c.geoCode.latitude }</td>
							<td>${c.geoCode.longitude }</td>
							<td>${c.rank }</td>
							<td><c:forEach var="a" items="${c.tags }">
							<c:url value="/keyword-filter" var="url">
								<c:param name="keyword" value="${a}" />
								<c:param name="latitude" value="${c.geoCode.latitude}" />
								<c:param name="longitude" value="${c.geoCode.longitude}" />
							</c:url>
							<a href="${url}">${a }</a>
							<br>
						</c:forEach></td>
						</tr>
					</c:if>
				</c:forEach>
			</c:forEach>
		</table>
		<div>
			<ul class="pagination pagination-lg">
				<li class="page-item disabled">
					<%-- 					<% String link = request.getParameter("${points.last}");
						session.setAttribute("link", link); %>  --%> <a class="page-link"
					href="points-last">&laquo;</a>
				</li>
				<li class="page-item active"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">4</a></li>
				<li class="page-item"><a class="page-link" href="#">5</a></li>
				<li class="page-item">
					<%
						String link = request.getParameter("${points.next}");
						session.setAttribute("next", link);
					%> <a class="page-link" href="points-next">&raquo;</a>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>