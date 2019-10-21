package com.vignesh.flightcheckin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vignesh.flightcheckin.dto.Reservation;
import com.vignesh.flightcheckin.dto.ReservationUpdateRequest;
import com.vignesh.flightcheckin.integration.ReservationRestClient;

@Controller
public class FlightCheckinController {
	
	@Autowired
	ReservationRestClient ReservationRestClient;
	
	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckin";
	}
	
	@RequestMapping("startCheckin")
	public String startCheckin(@RequestParam("reservationID") Long reservationId, ModelMap modelmap) {
		Reservation reservation = ReservationRestClient.findReservation(reservationId);
		modelmap.addAttribute("reservationDetails", reservation);
		return "displayReservationDetails";
	}
	
	@RequestMapping(value ="completeCheckin", method=RequestMethod.POST)
	public String completeCheckin(@RequestParam("numberOfBags") int numberOfBags, @RequestParam("Id") Long Id, ModelMap modelMap) {
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(Id);
		reservationUpdateRequest.setNumberOfBags(numberOfBags);
		reservationUpdateRequest.setCheckedIn(true);
		ReservationRestClient.updateReservation(reservationUpdateRequest);
		modelMap.addAttribute("msg", "Checked in successfully");
		return "reservationResult";
	}

}
	