<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Location</title>
</head>
<body>
<form action ="updateLocation" method = "post">
<pre>
ID : <input type = "text" name = "id" value = "${location.id}" readonly/>
Code : <input type = "text" name = "code" value = "${location.code}"/>
Name : <input type = "text" name = "name" value = "${location.name}"/>
Type : Urban <input type = "radio" name = "type" value = "URBAN" ${location.type=='URBAN'?'checked':'' }/>
		Rural <input type = "radio" name = "type" value = "RURAL" ${location.type=='RURAL'?'checked':'' }/>
	</pre>	
<input type = "submit" value = "Save"/>

</form>
</body>
</html>