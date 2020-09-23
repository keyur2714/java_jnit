package com.webstack.employeemgt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstack.employeemgt.model.Student;
import com.webstack.employeemgt.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getStudentsList() {
		List<Student> allStudents = studentRepository.findAll();
		allStudents.forEach(s->System.out.println(s));
		return allStudents;
	}
	
	public Optional<Student> getStudentById(Integer id) {
		return studentRepository.findById(id);
	}
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

}
