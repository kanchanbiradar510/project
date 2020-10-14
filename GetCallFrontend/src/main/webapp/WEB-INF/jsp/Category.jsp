<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="CommonHeader.jsp"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="LightCyan">
<br><br><<br><br>
<form action="InsertCategory" method="post">
<table align="center" width="40%" height="40%">
	<tr bgcolor="PaleTurquoise">
		<td align="center" colspan="2"><h3>Category Detail</h3></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Category Name</td>
		<td><input type="text" name="catName"/></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Category Desc</td>
		<td><textarea rows="5" cols="30" name="catDesc"></textarea></td>
	</tr>
	<tr bgcolor="LightCyan">
		<td colspan="2" align="center">
			<input type="submit" value="Insert Category"/>
		</td>
	</tr>
</table>
</form>

<table align="center" height="40%" width="80%">
	<tr bgcolor="LightCyan">
		<td>Catgory ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${categoryList}" var="category">
	<tr bgcolor="MistyRose">
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDesc}</td>
		<td>
			<a href="deleteCategory/${category.categoryId}" class="btn btn-danger">Delete</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="editCategory/${category.categoryId}" class="btn btn-success">Edit</a>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>