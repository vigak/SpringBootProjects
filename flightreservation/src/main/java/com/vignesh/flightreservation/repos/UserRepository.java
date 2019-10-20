package com.vignesh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vignesh.flightreservation.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
