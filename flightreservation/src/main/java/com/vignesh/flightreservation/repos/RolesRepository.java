package com.vignesh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vignesh.flightreservation.model.Role;

public interface RolesRepository extends JpaRepository<Role, Long> {

}
