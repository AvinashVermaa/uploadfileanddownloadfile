<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>upload jsp</title>
</head>
<body>
	<h1>Upload Jsp</h1>
	<form action="upload" method="post" enctype="multipart/form-data">
		Id : <input type="text" name="id"/>
		Document : <input type="file" name="document"/>
		<input type="submit" value="Upload"/>
	</form>
	
	<table border="2px solid red">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Data</th>
		</tr>
		
		<c:forEach items="${lists}" var="list">
			<tr>
				<td>${list.id}</td>
				<td>${list.name}</td>
				<td><a href="download?id=${list.id}">Download</a></td>
			</tr>
		</c:forEach>
	
	</table>
	
</body>
</html>