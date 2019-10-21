package com.vignesh.flightcheckin.integration;

import com.vignesh.flightcheckin.dto.Reservation;
import com.vignesh.flightcheckin.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	Reservation findReservation(Long id);
	
	Reservation updateReservation(ReservationUpdateRequest request);

}
