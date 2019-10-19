package com.vignesh.student.dal;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vignesh.student.dal.entities.Student;
import com.vignesh.student.dal.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentdalApplicationTests {
	
	@Autowired
	private StudentRepository StudentRepository;

	@Test
	public void testCreateStudent() {
		
		Student student = new Student();
		student.setName("Vignesh");
		student.setCourse("Software Engineering");
		student.setFee(500);
		StudentRepository.save(student);
	}
	
	@Test
	public void findStudentByID() {
		Optional<Student> student = StudentRepository.findById(1l);
		System.out.println(student.get());
	}
	
	@Test
	public void updateStudent() {
		Optional<Student> studentOptional = StudentRepository.findById(1l);
		Student student = studentOptional.get();
		student.setCourse("Computer Science");
		
		StudentRepository.save(student);
		
	}
	
	@Test
	public void deleteStudent() {
		Student student = new Student();
		student.setId(2l);
		StudentRepository.delete(student);
	}

}
