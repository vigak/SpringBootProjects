package com.vignesh.flightreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.flightreservation.dto.ReservationRequest;
import com.vignesh.flightreservation.model.Flight;
import com.vignesh.flightreservation.model.Passenger;
import com.vignesh.flightreservation.model.Reservation;
import com.vignesh.flightreservation.repos.FlightRepository;
import com.vignesh.flightreservation.repos.PassengerRepository;
import com.vignesh.flightreservation.repos.ReservationRepository;

import net.bytebuddy.agent.builder.ResettableClassFileTransformer;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository PassengerRepository;
	
	@Autowired
	ReservationRepository ReservationRepository;

	@Override
	public Reservation bookFlight(ReservationRequest reservationRequest) {
		
		Flight flight = flightRepository.findById(reservationRequest.getFlightID()).orElse(null);
		
		Passenger passengerDetails = new Passenger();
		passengerDetails.setFirstName(reservationRequest.getPassengerFirstName());
		passengerDetails.setLastName(reservationRequest.getPassengerLastName());
		passengerDetails.setEmail(reservationRequest.getPassengerEmail());
		passengerDetails.setPhone(reservationRequest.getPassengerPhone());
		
		PassengerRepository.save(passengerDetails);
		
		Reservation reservationDetails = new Reservation();
		reservationDetails.setFlight(flight);
		reservationDetails.setPassenger(passengerDetails);
		reservationDetails.setCheckedIn(false);
		
		ReservationRepository.save(reservationDetails);
		
		return reservationDetails;
	}

}
