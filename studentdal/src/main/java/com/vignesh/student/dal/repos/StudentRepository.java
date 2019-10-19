package com.vignesh.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.vignesh.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

	
}
