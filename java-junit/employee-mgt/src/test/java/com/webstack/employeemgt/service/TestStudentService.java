package com.webstack.employeemgt.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.webstack.employeemgt.model.Student;
import com.webstack.employeemgt.repository.StudentRepository;

@SpringBootTest
public class TestStudentService {
	
	@InjectMocks
	private StudentService studentService;
	
	@MockBean
	private StudentRepository studentRepository;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllStudentsTest() {

		List<Student> studentList = new ArrayList<>();

		Student student1 = new Student();
		student1.setId(24);
		student1.setName("Darsh");
		student1.setMobileNo("9898012124");
		student1.setEmail("darsh_hy@gmail.com");

		Student student2 = new Student();
		student2.setId(04);
		student2.setName("Ami");
		student2.setMobileNo("8600712124");
		student2.setEmail("ami_hy@gmail.com");

		studentList.add(student1);
		studentList.add(student2);

		when(studentRepository.findAll()).thenReturn(studentList);
		when(studentService.getStudentsList()).thenReturn(studentList);

		assertEquals(2, studentList.size());

	}
	
	
	@Test
	public void getStudentByIdTest() {
		
		
		Student student1 = new Student();
		student1.setId(24);
		student1.setName("Darsh");
		student1.setMobileNo("9898012124");
		student1.setEmail("darsh_hy@gmail.com");
		
		when(studentService.getStudentById(24)).thenReturn(Optional.of(student1));
		
		assertEquals("Darsh", student1.getName());
		assertEquals("9898012124", student1.getMobileNo());
		assertEquals("darsh_hy@gmail.com", student1.getEmail());
		
				
	}
	
	@Test
	public void saveStudentTest() {
		
		Student student1 = new Student();
		student1.setId(24);
		student1.setName("Darsh");
		student1.setMobileNo("9898012124");
		student1.setEmail("darsh_hy@gmail.com");
		
		studentService.saveStudent(student1);

		verify(studentRepository,times(1)).save(student1);
	}
	
	
	
	
	
}
