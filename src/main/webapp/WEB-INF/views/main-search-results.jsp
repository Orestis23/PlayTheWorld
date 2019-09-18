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
<title>City Search</title>

</head>
<body background="https://discovershareinspire.com/wp-content/uploads/2013/10/Vintage-map-faded.jpg">
	<div class="container">


<a class="btn btn-warning" href="login?eMail=${user.eMail }">Go Back</a>
		<div align="center" id="map">
		<br> <img src="${map }" height="400px" width="800px">
</div>
		<br><br>
		<h1>City Info</h1>
		<table class="table">
			<tr>
				<th>Name</th>
				<th>City Code</th>
				<th>Travel Score</th>
				<th>Points for Visiting</th>
				<th></th>
				
			</tr>

		<c:forEach var="c" items="${locations }" begin="0" end="0">
                <tr>
                    <td><c:url value="/city-detail" var="url">
                            <c:param name="cityName" value="${c.id}" />
                        </c:url> <a href="${url}">${c.name }</a></td>
                   
                    <td>${c.iataCode }</td>
                    <td>${c.analytics.travelers.score }</td>
                    <td>${distance }</td>
                    <td><button id="demo" class="btn btn-warning" type="button" onclick="addPoints(${distance })">Click if visited!</button></td>
                    
                    </tr>
                    </c:forEach>


 			<c:forEach var="c" items="${locations }" begin="0" end="0">
				<tr>
					<td><c:url value="/city-detail" var="url">
							<c:param name="cityName" value="${c.id}" />
						</c:url> <a href="${url}">${c.name }</a></td>
					
					<td>${c.iataCode }</td>
					<td>${c.analytics.travelers.score }</td>
					<td>${distance }</td>
				</tr>
 			</c:forEach> 


		</table>
		<br>
		<h1>Points of Interest</h1>
		<table class="table">
			<tr>
				<th></th>
				<th>Name (Select to Mark as Favorite)</th>
				<th>Select if you visited here!</th>
				<th>Location Type</th>
				<th>Travel Score</th>
				<th>Keywords</th>
			</tr>
			<c:forEach var="c" items="${points}" varStatus="i">
				<tr>
					<td><img src="https://maps.googleapis.com/maps/api/staticmap?center=${c.geoCode.latitude},${c.geoCode.longitude}
				&zoom=13&markers=size:tiny|${c.geoCode.latitude},${c.geoCode.longitude}&size=100x100&scale=2&key=${ googleKey}"></td>
					<td><input
						onchange="window.location.href='/addFavAtt?attName=${c.name }&msearch=${msearch }&isChecked='+ this.checked"
						type="checkbox" id="favorites" name="favorite" <c:if test="${activityNames.contains(c.name)}">
					checked
					</c:if>>${c.name } </td>
					<td><input
						onchange="window.location.href='/addLocVisited?attName=${c.name }&msearch=${msearch }&isChecked='+ this.checked"
						type="checkbox" id="locVisited" name="locVisited" <c:if test="${activityNames.contains(c.name)}">
					checked
					</c:if>>${c.name } </td>
					<td>${c.category }</td>
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
			</c:forEach>
		</table>
		<div>
			<ul class="pagination pagination-lg">
				<li class="page-item disabled">
			 <a class="page-link"
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
<script>
function addPoints(distance){
	document.getElementById("demo").style.color = "red";
	 var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     // document.getElementById("demo").innerHTML =
	      this.responseText;
	    }
	  };
	  xhttp.open("GET", "add-points?points=" +distance, true);
	  xhttp.send();
}
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>