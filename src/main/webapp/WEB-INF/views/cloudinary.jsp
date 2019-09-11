<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://cloudinary.com/jsp/taglib" prefix="cl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Image</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9NlqO4dP5KfioUGS568UFwM3lbWf3Uj3Qb7FBHuIuhLoDp3ZgAqPE1/MYLEBPZYM"
	crossorigin="anonymous">

<script src="https://widget.cloudinary.com/v2.0/global/all.js"
	type="text/javascript">  
</script>

</head>
<body>

<script type="text/javascript">
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

	<button onclick="upload()" id="opener" class="cloudinary-button">Upload Image</button>

</body>
</html>