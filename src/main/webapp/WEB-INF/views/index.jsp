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

<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://widget.cloudinary.com/v2.0/global/all.js"
	type="text/javascript">  </script>

</head>
<body
	background="https://discovershareinspire.com/wp-content/uploads/2013/10/Vintage-map-faded.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-4">

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
					</select> <input class="btn btn-warning" type="submit" value="Search">
				</form>




				<h3>Your Information</h3>
				<p>${userInfo.userName }</p>
				<p>${userInfo.eMail }</p>
				<p>Points Accumulated: ${userInfo.currentPoints }</p>
				<p>Your Home Location: ${userInfo.homeBase }</p>
				<h3>Locations Visited</h3>
				<p>${userInfo.locVisited }</p>
				
				<%-- <c:forEach var="locv" items="${list }" varStatus="i">
					<tr>

						
						<button class="btn btn-warning"><a href="delFavAtt?idDelete=${locv.id }">Remove</a></td></button>
						<td>${locv.activityName }<br></td>  Need to create delLocVis method and change syntax above

					</tr>
				</c:forEach> --%>
				
				
				
				<h3>Favorite Cities</h3>
				<p>${userInfo.favCities }</p>
				<!-- Add a loop around this for mult. locations -->
				<h3>Favorite Activities</h3>
				<p>${userInfo.favActivities }</p>


				<c:forEach var="att" items="${list }" varStatus="i">
					<tr>

				
						<button class="btn btn-warning"><a href="delFavAtt?idDelete=${att.id }">Remove</a></td></button>
						<td>${att.activityName }<br></td>

					</tr>
				</c:forEach>

			</div>
			<div class="col-lg-8">
				<button onclick="showUploadWidget()" id="opener"
					class="cloudinary-button">Upload New Image</button>
				<br>
				<c:forEach var="img" items="${imageList }">
					<img src="${img.url}" height="250px" width="250px">

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


</body>
</html>