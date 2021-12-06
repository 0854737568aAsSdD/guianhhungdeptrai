<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC -HelloWorld</title>
</head>


<body>
	<h1>${greeting}</h1>
	helloworld.jsp:
	<c:choose>
		<c:when test="${sessionScope.tam!=null}">
			<h1>${greeting}</h1>
		    Gia tri cua session:<br>
		    ${sessionScope.tam}
		    
		   <br> Ds Sinh vien:
		   <c:forEach items="${ds}" var="ht">
		      ${ht} <hr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<form action="hello" method="post">
				<input type="submit" values="Chuyen du lieu len Controller"
					name="but1">
			</form>
		</c:otherwise>
	</c:choose>
</body>


</html>