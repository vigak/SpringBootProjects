package com.vignesh.flightreservation.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vignesh.flightreservation.model.Flight;
import com.vignesh.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@RequestMapping(value="findFlights", method=RequestMethod.POST)
	public String findFlights(@RequestParam("from") String from,@RequestParam("to") String to, @RequestParam("dateOfDeparture") @DateTimeFormat(pattern = "MM-dd-yyyy") Date dateOfDeparture, ModelMap modelMap) {
		List<Flight> flights = flightRepository.findFlights(from, to, dateOfDeparture);
		modelMap.addAttribute("flights", flights);
		modelMap.addAttribute("msg", "Here are the results for your flights search");
		return "displayFlights";
	}

}
