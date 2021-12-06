<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Danh sach</p>
<td><a href="<c:url value='them-nguoi-dung'/>">Them</a></td>
	
	<hr>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>email</th>
			<th>chon</th>
		</tr>

		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td><a href="<c:url value='chi-tiet-nguoi-dung/${user.id}'/>">
						Chi Tiet </a></td>
						<td><a href="<c:url value='xoa-nguoi-dung/${user.id}'/>">Xoa</a></td>
						<td><a href="<c:url value='sua-nguoi-dung/${user.id}'/>">Sua</a></td>
							 

			</tr>
		</c:forEach>
	</table>
</body>
</html>