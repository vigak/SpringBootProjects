package com.vignesh.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vignesh.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

}
