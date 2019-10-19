<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Location</title>
</head>
<body>
<form action ="saveLocation" method = "post">
<pre>
ID : <input type = "text" name = "id" />
Code : <input type = "text" name = "code" />
Name : <input type = "text" name = "name" />
Type : Urban <input type = "radio" name = "type" value = "URBAN"/>
		Rural <input type = "radio" name = "type" value = "RURAL"/>
	</pre>	
<input type = "submit" value = "Save"/>

</form>
${msg}

<a href = "displayLocation">View All Locations</a>
<a href = "editLocation">Update Location</a>
</body>
</html>