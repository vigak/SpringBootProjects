package com.vignesh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vignesh.flightreservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
