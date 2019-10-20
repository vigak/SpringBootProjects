package com.vignesh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vignesh.flightreservation.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
