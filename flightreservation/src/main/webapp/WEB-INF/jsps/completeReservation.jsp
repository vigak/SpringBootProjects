<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation</title>
</head>
<body>

<h2> Flight Details : </h2>
${msg }
<pre>
Airlines : ${flightDetails.operatingAirlines }<br/>
Departure City : ${flightDetails.departureCity }<br/>
Arrival City : ${flightDetails.arrivalCity }<br/>
Departure Time : ${flightDetails.dateOfDeparture }<br/>
</pre>

<form action = "completeReservation" method = "post">
<pre>
First Name : <input type = "text" name = "passengerFirstName" />
Last Name : <input type = "text" name = "passengerLastName" />
Email Address : <input type = "text" name = "passengerEmail" />
Phone Number : <input type = "text" name = "passengerPhone" />
</pre>

<input type = "hidden" name = "flightID" value = "${flightDetails.id }" />
<input type = "submit" value = "Book Flight" />
</form>
</body>
</html> 