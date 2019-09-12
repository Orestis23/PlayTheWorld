<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://cloudinary.com/jsp/taglib" prefix="cl"%>

<!DOCTYPE html>
<html>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sandstone/bootstrap.min.css" rel="stylesheet" integrity="sha384-G3Fme2BM4boCE9tHx9zHvcxaQoAkksPQa/8oyn1Dzqv7gdcXChereUsXGx6LtbqA" crossorigin="anonymous">

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://widget.cloudinary.com/v2.0/global/all.js"type="text/javascript">  </script>

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
			<p>${userInfo.currentPoints } PointsAccumulated</p>
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
		<c:forEach var="att" items="${list }" varStatus="i">
		<tr>
			
			<td><button type="button" a href="delFavAtt?idDelete=${att.id }">Remove</a></button></td>
			<td>${att.activityName }<br></td>
		
		</tr>
		</c:forEach>
		<div>
		<c:forEach var="img" items="${imageList }">
		<img src="${img.url}">
		
		</c:forEach>
		
		</div>
	<button onclick="showUploadWidget()" id="opener" class="cloudinary-button">Upload Image</button>
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
	 // Customized upload widget  
/* 	function showUploadWidget() { cloudinary.openUploadWidget({ cloudName: "${name}", uploadPreset:"${preset}",
	sources: [ "local", "url", "camera", "image_search", "facebook", "dropbox", "instagram" ],showAdvancedOptions: true, cropping: true, multiple: false,
	defaultSource: "local", styles: { palette: { window: "#464040", sourceBg: "#292222", windowBorder: "#c7a49f", tabIcon: "#cc6600",
	inactiveTabIcon: "#E8D5BB", menuIcons: "#ebe5db", link: "#ffb107", action: "#ffcc00", inProgress: "#99cccc", complete: "#78b3b4", error:
	"#ff6666", textDark: "#4C2F1A", textLight: "#D8CFCF" }, fonts: {default: null, "'Kalam', cursive": { url:
	"https://fonts.googleapis.com/css?family=Kalam", active: true } } }}, (err, info) => { if (!err) { 
		window.location.assign("uploadurl?imageURL=" + result.info.url);
		console.log("Upload Widget event - ",
	info);
	}
	});
	} */ </script>
	</div>

</body>
</html>