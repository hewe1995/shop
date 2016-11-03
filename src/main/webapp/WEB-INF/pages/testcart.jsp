<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>" />
<title>Insert title here</title>
</head>
<body>
	<h1>购物车</h1>
	<c:if test="${not empty cart }">
	<table>
		<c:forEach items="${cart.citems }" var="item">
			<tr>
				<td>${item.value.getIsumPrice() }</td>
				<td>${item.value.getIquantity() }</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>