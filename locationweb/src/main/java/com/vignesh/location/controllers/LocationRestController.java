package com.vignesh.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vignesh.location.entities.Location;
import com.vignesh.location.repos.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRestController{
	
	@Autowired
	LocationRepository locationRepository;
	
	@GetMapping
	public List<Location> getLocations(){
		return locationRepository.findAll();
	}
	
	@PostMapping
	public Location createLocation(@RequestBody Location location) {
		return locationRepository.save(location);
	}
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return locationRepository.save(location);
	}
	
	@DeleteMapping("/{id}")
	public String deleteLocation(@PathVariable int id) {
		locationRepository.deleteById(id);
		return "Location deleted successfully";
	}
	
	@GetMapping("/{id}")
	public Location getLocation(@PathVariable int id) {
		return locationRepository.findById(id).orElse(null);
	}
	

}
