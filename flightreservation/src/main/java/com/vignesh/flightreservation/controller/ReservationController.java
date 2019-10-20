package com.vignesh.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vignesh.flightreservation.dto.ReservationRequest;
import com.vignesh.flightreservation.model.Flight;
import com.vignesh.flightreservation.model.Reservation;
import com.vignesh.flightreservation.repos.FlightRepository;
import com.vignesh.flightreservation.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService ReservationService;
	
	@RequestMapping(value = "showCompleteReservation", method = RequestMethod.GET)
	public String showCompleteReservation(@RequestParam("flightId") Long flightID, ModelMap modelMap) {
		Flight flight = flightRepository.findById(flightID).orElse(null);
		modelMap.addAttribute("msg", "Please enter the details to book the flight");
		modelMap.addAttribute("flightDetails", flight);
		return "completeReservation";
	}
	
	@RequestMapping(value = "completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest reservationRequest, ModelMap modelMap) {
		Reservation reservationDetails = ReservationService.bookFlight(reservationRequest);
		modelMap.addAttribute("msg", "Reservation ID :: "+reservationDetails.getId());
		return "showConfirmation";
	}

}
