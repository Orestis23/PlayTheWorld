<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css" rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div class="container">
<h1>Welcome!</h1>
	<form action="main-search">
		<input type="text" name="msearch" placeholder="Search by Country, City, or Location" style="width: 50%;"> 
		<input class="btn btn-primary" type="submit" value="Search">
	</form>
</div>
</body>
</html>