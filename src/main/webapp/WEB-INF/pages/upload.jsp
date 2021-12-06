<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>  Form Upload </p>
<c:url value="/upload" var="url"></c:url>
<form action="${url}" method="post" enctype="multipart/form-data">
<input type="file" name ="file">
<input type="file" name ="file">
<input type="file" name ="file">
<button type="submit"> Click me </button>
</form>
</body>
</html>