package com.vignesh.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.location.entities.Location;
import com.vignesh.location.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository LocationRepository;

	@Override
	public Location saveLocation(Location location) {
		return LocationRepository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return LocationRepository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		LocationRepository.delete(location);
	}

	@Override
	public Location getLocationById(int id) {
		Location location =  LocationRepository.findById(id).get();
		return location;
	}

	@Override
	public List<Location> getAllLocations() {
		return LocationRepository.findAll();
	}

}
