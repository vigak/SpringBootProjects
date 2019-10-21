<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
Airlines : ${reservationDetails.flight.operatingAirlines }
Departure City : ${reservationDetails.flight.departureCity }
Arrival City : ${reservationDetails.flight.arrivalCity }
Date : ${reservationDetails.flight.dateOfDeparture }

First Name : ${reservationDetails.passenger.firstName }
Last Name : ${reservationDetails.passenger.lastName }
Email : ${reservationDetails.passenger.email }
Phone Number : ${reservationDetails.passenger.phone }

<form action = "completeCheckin" method ="post">
Enter the number of bags you want to check in : <input type = "text" name ="numberOfBags" />
<input type = "hidden" name = "Id" value = "${reservationDetails.id }" />
<input type = "submit" value = "CheckIn" />
</form>


</body>
</html>