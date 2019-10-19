package com.vignesh.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vignesh.location.entities.Location;
import com.vignesh.location.service.LocationService;
import com.vignesh.location.util.EmailUtill;

@Controller
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	EmailUtill EmailUtil;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLocation")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = locationService.saveLocation(location);
		EmailUtil.sendEmail("vigneshsinbox@gmail.com", "Sample Mail", locationSaved.getName());
		String msg = "Location saved with the id :: "+locationSaved.getId();
		modelMap.addAttribute("msg", msg);
		return "createLocation"; 
	}
	
	@RequestMapping("/displayLocation")
	public String displayLocation(ModelMap modelMap) {
		List<Location> locations = locationService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocation";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = locationService.getLocationById(id);
		locationService.deleteLocation(location);
		List<Location> locations = locationService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocation";
	}
	
	@RequestMapping("/editLocation")
	public String showUpdateLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = locationService.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateLocation")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		locationService.saveLocation(location);
		List<Location> locations = locationService.getAllLocations();
		String msg = "Location has been updated";
		modelMap.addAttribute("msg", msg);
		modelMap.addAttribute("locations", locations);
		return "displayLocation";
		
	}

}
