<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>See Others' Experiences</title>

<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9NlqO4dP5KfioUGS568UFwM3lbWf3Uj3Qb7FBHuIuhLoDp3ZgAqPE1/MYLEBPZYM"
	crossorigin="anonymous">
	 <link rel="stylesheet" type="text/css" href="https://www.htmlcommentbox.com/static/skins/bootstrap/twitter-bootstrap.css?v=0" />
	
</head>
<body
	background="https://discovershareinspire.com/wp-content/uploads/2013/10/Vintage-map-faded.jpg">


<div align="right">
	<a class="btn btn-primary" href="/">Logout</a>
</div>

<a class="btn btn-primary" href="login?eMail=${user.eMail }">Go Back</a>

	<c:forEach var="usInfo" items="${userTripInfo }">
<div align="center">
		<h2 style= "font-family:georgia">${usInfo.userName } <img src="${usInfo.profileImage }" height="75px" width="75px"></h2> <h6 style= "font-family:georgia">...is from ${usInfo.homeBase } and has ${usInfo.currentPoints } TrekPoints!</h6>
		
<div>
		<h4 style= "font-family:georgia">Visited Attractions:</h4>
		<c:forEach var="usLoc" items="${usInfo.locVisList }">
		
		<a class="btn btn-primary" href="http://www.google.com/search?q=${usLoc.activityName }">${usLoc.activityName }</a>
		</c:forEach>
</div>		
</div>
<div align="center">
		<c:forEach var="usImg" items="${usInfo.imageList }">
		
		<img src="${usImg.url }" height="250px" width="250px">
		</c:forEach>
</div>		
		<br>
<div align="center"> 
		<!-- begin wwww.htmlcommentbox.com -->
 <div style="width:500px" id="HCB_comment_box" ><a href="http://www.htmlcommentbox.com" >HTML Comment Box</a> is loading comments...</div>
<!-- end www.htmlcommentbox.com -->
</div>

	</c:forEach>	
	<!--  <div style="width:500px" id="HCB_comment_box" ><a href="http://www.htmlcommentbox.com" >HTML Comment Box</a> is loading comments...</div>
 -->
 <script type="text/javascript" id="hcb"> /*<!--*/ if(!window.hcb_user){hcb_user={};} (function(){var s=document.createElement("script"), l=hcb_user.PAGE || (""+window.location).replace(/'/g,"%27"), h="https://www.htmlcommentbox.com";s.setAttribute("type","text/javascript");s.setAttribute("src", h+"/jread?page="+encodeURIComponent(l).replace("+","%2B")+"&mod=%241%24wq1rdBcg%24IGoV1pwK9PPXCsIWAgI4y%2F"+"&opts=16862&num=10&ts=1568748769603");if (typeof s!="undefined") document.getElementsByTagName("head")[0].appendChild(s);})(); /*-->*/ </script>

</body>
</html>