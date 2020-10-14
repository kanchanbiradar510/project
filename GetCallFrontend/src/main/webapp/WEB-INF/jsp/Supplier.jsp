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
	<form action="InsertSupplier" method="post">
<table align="center" width="40%" height="40%">
	<tr bgcolor="PaleTurquoise">
		<td align="center" colspan="2"><h3>Supplier Detail</h3></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Supplier Name</td>
		<td><input type="text" name="supName"/></td>
	</tr>
	<tr bgcolor="MistyRose">
		<td>Supplier Desc</td>
		<td><textarea rows="5" cols="30" name="supDesc"></textarea></td>
	</tr>
	<tr bgcolor="LightCyan">
		<td colspan="2" align="center">
			<input type="submit" value="Insert Supplier"/>
		</td>
	</tr>
</table>
</form>

<table align="center" width="80%" height="40%">
	<tr bgcolor="LightCyan">
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Desc</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${supplierList}" var="supplier">
	<tr bgcolor="MistyRose">
		<td>${supplier.supplierId}</td>
		<td>${supplier.supplierName}</td>
		<td>${supplier.supplierDesc}</td>
		<td>
			<a href="deleteSupplier/${supplier.supplierId}" class="btn btn-danger">Delete</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="editSupplier/${supplier.supplierId}" class="btn btn-success">Edit</a>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>