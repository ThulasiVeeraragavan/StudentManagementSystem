package com.example.student_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.student_management_system.entity.Student;
import com.example.student_management_system.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	@Autowired
	private StudentRepository studentRepository;
	

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Student student1 = new Student ("veera","ragavan","veera@gmail.com");
		 * studentRepository.save(student1); Student student2 = new Student
		 * ("narayana","raju","raju@gmail.com"); studentRepository.save(student2);
		 */
		
	}

}
