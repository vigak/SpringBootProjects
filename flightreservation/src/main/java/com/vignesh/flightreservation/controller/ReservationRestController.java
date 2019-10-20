package com.vignesh.flightreservation.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vignesh.flightreservation.dto.ReservationUpdateRequest;
import com.vignesh.flightreservation.model.Reservation;
import com.vignesh.flightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@GetMapping("/reservations/{id}")
	public Reservation getReservationDetails(@PathVariable("id") Long Id) {
		return reservationRepository.findById(Id).orElse(null);
	}
	
	@PostMapping("/reservations/updateDetails")
	public Reservation updateReservationDetails(@RequestBody ReservationUpdateRequest reservationUpdateRequest) {
		Reservation reservation = reservationRepository.findById(reservationUpdateRequest.getId()).orElse(null);
		reservation.setCheckedIn(reservationUpdateRequest.getCheckedIn());
		reservation.setNumberOfBags(reservationUpdateRequest.getNumberOfBags());
		return reservationRepository.save(reservation);
	}

}
