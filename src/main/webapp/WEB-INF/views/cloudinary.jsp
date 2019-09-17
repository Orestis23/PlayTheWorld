<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://cloudinary.com/jsp/taglib" prefix="cl"%>
<!DOCTYPE html>
<html>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css"
	rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>Add Image</title>
<script src="https://widget.cloudinary.com/v2.0/global/all.js"
	type="text/javascript">  </script>

</head>
<body>

<!-- 	<script type="text/javascript">
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
 -->
	<button onclick="upload()" id="opener" class="cloudinary-button">Upload
		Image</button>
	<!-- 	<script type="text/javascript" src="js/cloudinary-widget-tasha.js"></script>
 -->
</body>
</html>