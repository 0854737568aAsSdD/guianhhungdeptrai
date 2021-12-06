<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<p> Thông tin người dùng </p>
<p> Tên người dùng : ${user.name} </p>
<p> Pwd : ${user.pwd} </p>
<p> Id : ${user.id} </p>
<p> GioiTinh : ${user.gender} </p>
<p> Gioi Thieu : ${user.about} </p>
<p> Arugument : ${user.acceptAgreement} </p>
<p> So Thich  </p>
<c:forEach items="${user.favourites}" var="item">
   <p> ${item} </p>
 </c:forEach>
 <p> FileName : ${user.avatar.getOriginalFilename()} </p>
</body>
</html>