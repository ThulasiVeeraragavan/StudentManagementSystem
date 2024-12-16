package com.example.student_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.student_management_system.entity.Student;
import com.example.student_management_system.service.StudentService;

@Controller
//@RestController
//@RequestMapping("")
public class StudentController {
	@Autowired
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
		
	}
	@GetMapping("/students/new")
	public String createSTudentForm(Model model) {
		Student student =new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student,Model model) {
		Student existingStudent =studentService.getStudentById(id);
		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		existingStudent.setEmail(student.getEmail());
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
	/*
	 * @PostMapping public ResponseEntity<Student> saveStudent(@RequestBody Student
	 * student){ return new
	 * ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.
	 * CREATED); }
	 * 
	 * @GetMapping public List<Student> getAllStudents(){ return
	 * studentService.getAllStudents(); }
	 * 
	 * @PostMapping("{id}") public ResponseEntity<Student>
	 * getEmployeeById(@PathVariable("id") long studentId){ return new
	 * ResponseEntity<Student>(studentService.getStudentById(studentId),HttpStatus.
	 * OK); }
	 * 
	 * @PutMapping("{id}") public ResponseEntity<Student>
	 * updateEmployee(@PathVariable("id") long studentId,@RequestBody Student
	 * student){ return new
	 * ResponseEntity<Student>(studentService.updateStudent(student,
	 * studentId),HttpStatus.OK); }
	 * 
	 * @DeleteMapping("{id}") public ResponseEntity<String>
	 * deleteStudent(@PathVariable("id") long studentId){
	 * studentService.deleteStudent(studentId); return new
	 * ResponseEntity<String>("Employee Deleted Successfully",HttpStatus.OK);
	 * 
	 * }
	 */
}
