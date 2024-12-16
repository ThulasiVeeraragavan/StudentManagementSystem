package com.example.student_management_system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.student_management_system.entity.Student;
import com.example.student_management_system.repository.StudentRepository;
import com.example.student_management_system.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	/*
	 * @Override public Student saveStudent(Student employee) { return
	 * studentRepository.save(employee); }
	 */

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(long id) {
		
		return studentRepository.findById(id).get();
	}

	@Override
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
		
	}

	/*
	 * @Override public Student getStudentById(long id) {
	 * 
	 * Optional<Employee> employee = employeeRepository.findById(id); if
	 * (employee.isPresent()) { return employee.get(); } else { throw new
	 * ResourceNotFoundException("Employee","Id",id); }
	 * 
	 * return studentRepository.findById(id).orElseThrow(()-> new
	 * ResourceNotFoundException("Employee","Id",id)); }
	 * 
	 * @Override public Student updateStudent(Student stduent, long id) { Student
	 * exitingEmployee=studentRepository.findById(id).orElseThrow(()-> new
	 * ResourceNotFoundException("Employee","Id",id));
	 * exitingEmployee.setFirstname(stduent.getFirstname());
	 * exitingEmployee.setLastname(stduent.getLastname());
	 * exitingEmployee.setEmail(stduent.getEmail());
	 * studentRepository.save(exitingEmployee); return exitingEmployee; }
	 * 
	 * @Override public void deleteStudent(long id) {
	 * studentRepository.findById(id).orElseThrow(()-> new
	 * ResourceNotFoundException("Employee","Id",id));
	 * studentRepository.deleteById(id);
	 * 
	 * 
	 * }
	 */

}
