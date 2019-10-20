package com.vignesh.flightreservation.service;

import com.vignesh.flightreservation.dto.ReservationRequest;
import com.vignesh.flightreservation.model.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest reservationRequest);
}
