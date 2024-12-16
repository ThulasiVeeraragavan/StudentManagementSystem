package com.example.student_management_system.service;

import java.util.List;

import com.example.student_management_system.entity.Student;


public interface StudentService {
	Student saveStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(long id);
	Student updateStudent(Student student);
	void deleteStudent(long id);
}
