<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://cloudinary.com/jsp/taglib" prefix="cl"%>

<!DOCTYPE html>
<html>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css"
	rel="stylesheet">

<link href="styles.css" rel="stylesheet">
<head>
<div align="center">
<a class="btn btn-warning" href="tripData">See Other TrekStars' Memories</a>
</div>

<div align="right">
	<a class="btn btn-warning" href="/">Logout</a>
</div>

<meta charset="UTF-8">
<title>${userInfo.userName }'s Travels!</title>
<script src="https://widget.cloudinary.com/v2.0/global/all.js"
	type="text/javascript">  </script>

</head>
<body
	background="https://discovershareinspire.com/wp-content/uploads/2013/10/Vintage-map-faded.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-4">



				<h1><p style= "font-family:georgia">Welcome ${userInfo.userName }!</p></h1>
				<form action="main-search">
					<!-- 		<input type="text" name="msearch" placeholder="Search by City" style="width: 50%;"> -->
					<select name="msearch">
						<option value="London">London</option>
						<option value="New York">New York</option>
						<option value="Barcelona">Barcelona</option>
						<option value="Berlin">Berlin</option>
						<option value="Dallas">Dallas</option>
						<option value="Paris">Paris</option>
						<option value="San Francisco">San Francisco</option>
					</select> <input class="btn btn-warning" type="submit" value="Search">
				</form>
				
				<h3><p style= "font-family:georgia">Your Dashboard</p></h3>

				<p style= "font-family:georgia">${userInfo.userName }</p>
			



				<p><img src="${userInfo.profileImage }" height="110px" width="110px">
				<p style= "font-family:georgia">${userInfo.eMail }</p>
				<p style= "font-family:georgia">Points Accumulated: ${userInfo.currentPoints }</p>
				<p style= "font-family:georgia">Your Home Location: ${userInfo.homeBase }</p>

				<h3><p style= "font-family:georgia">Locations Visited</p></h3>

				<c:forEach var="locv" items="${locList }" varStatus="i">
					<tr>

						<a class="btn btn-warning" href="delLocVisited?idDelete=${locv.id }">Remove</a>
						<a href="http://www.google.com/search?q=${locv.activityName }">${locv.activityName }</a><br>
						<br>

					</tr>
				</c:forEach>


				
				
				<h3><p style= "font-family:georgia">Favorite Activities</p></h3>
				<p style= "font-family:georgia">${userInfo.favActivities }</p>



				<c:forEach var="att" items="${list }" varStatus="i">
					<tr>


						<a class="btn btn-warning" href="delFavAtt?idDelete=${att.id }">Remove</a>
						<td><a
							href="http://www.google.com/search?q=${att.activityName }">${att.activityName }</a><br></td>
						<br>


					</tr>
				</c:forEach>

			</div>
			<div class="col-lg-8">
				<button onclick="showUploadWidget()" id="opener"
					class="cloudinary-button">Upload New Image</button>
				<br>
				<c:forEach var="img" items="${imageList }">
					<img src="${img.url}" height="250px" width="250px">
					<a id="link" href="delImage?imageId=${img.id }">Remove</a>


				</c:forEach>

			</div>
		</div>
	</div>
	<!-- script tags should always go right before the closing body tag -->
	<script>
	
	   var myWidget = cloudinary.applyUploadWidget(document.getElementById('opener'), 
			   { cloudName: "${name}", uploadPreset: "${preset}" }, (error, result) => {
			 	 console.log("start")
			 	
			 	 if(result.event === 'success'){
			          console.log(result.info.url);
			          window.location.assign("uploadurl?imageURL=" + result.info.url);
			      }
			 	  });
			 	
			 function upload(){
			 	
			 myWidget.open();
			 }

 </script>

</body>
</html>