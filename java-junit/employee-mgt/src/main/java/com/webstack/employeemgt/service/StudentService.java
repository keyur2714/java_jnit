package com.webstack.employeemgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstack.employeemgt.model.Student;
import com.webstack.employeemgt.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getStudentsList() {
		return studentRepository.findAll();
	}

}
