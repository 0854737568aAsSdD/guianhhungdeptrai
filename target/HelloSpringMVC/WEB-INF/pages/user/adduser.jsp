<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p> Form người dùng</p>
<c:url value="/them-khach-hang" var="url" />
<form:form modelAttribute="user" method="post" action="${url}" enctype="multipart/form-data">
<p> Ten </p> <form:input path="name"/>
 <p style="color: red;"> <form:errors path="name"></form:errors> </p>
<p> Email </p><form:input path="email"/>
 <p style="color: red;"> <form:errors path="pwd"></form:errors> </p>
<button type="submit"> Submit</button>
</form:form>
</body>
</html>