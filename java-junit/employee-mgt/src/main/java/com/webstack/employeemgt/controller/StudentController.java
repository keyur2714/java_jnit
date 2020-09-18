package com.webstack.employeemgt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webstack.employeemgt.model.Student;
import com.webstack.employeemgt.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public List<Student> getStudentList() {
		return studentService.getStudentsList();
	}
	
	@GetMapping("/students/{id}")
	public Optional<Student> getStudentById(@PathVariable("id") Integer id) {
		System.out.println(id);
		return studentService.getStudentById(id);
	}
	
	@PostMapping("/students")
	public void saveStudent(@RequestBody Student student) {		
		studentService.saveStudent(student);
	}

}
