<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value = '/sources/css/style.css'/>">
<script type="text/javascript" src="<c:url value = '/sources/js/main.js'/>"></script>
</head>
<body>
<p> Thong tin cua file </p>
<c:forEach items="${files}" var="file">
<p> Ten : ${ file.getOriginalFilename() } </p>
</c:forEach>
</body>
</html>