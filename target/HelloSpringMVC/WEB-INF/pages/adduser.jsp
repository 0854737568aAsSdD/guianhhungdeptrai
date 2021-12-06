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
<c:url value="/them-user" var="url" />
<form:form modelAttribute="user" method="post" action="${url}" enctype="multipart/form-data">
<p> Ten </p> <form:input path="name"/>
 <p style="color: red;"> <form:errors path="name"></form:errors> </p>
<p> Mat Khau </p><form:input path="pwd"/>
 <p style="color: red;"> <form:errors path="pwd"></form:errors> </p>
<form:hidden path="id"/>
<p> So thich </p>
<form:checkboxes items="${list}" path="favourites"/>
<p>Gioi Tinh </p>
<form:select path="gender">
<form:option value="Nam">Nam</form:option>
<form:option value="Nu">Nu</form:option>
</form:select>
<p> Gioi Thieu </p>
<form:textarea path="about"/>
<form:radiobutton path="acceptAgreement" value="true" label="Dong y dieu khoan "/>
<form:input path="avatar" type ="file"/>
<button type="submit"> Submit</button>
</form:form>
</body>
</html>