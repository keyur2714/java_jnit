package com.webstack.employeemgt.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webstack.employeemgt.model.Student;

@SpringBootTest
@AutoConfigureMockMvc
public class TestStudentController {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getAllStudentsTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/students").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].name", is("keyur")))
				.andExpect(jsonPath("$[0].email", is("keyurjava27@gmail.com")));

	}

	@Test
	public void getStudentByIdTest() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/api/students/2").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andReturn();

		ObjectMapper objectMapper = new ObjectMapper();

		Student student = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);

		assertEquals(student.getId(), 2);
		assertEquals(student.getName(), "denish");
		assertEquals(student.getEmail(), "denishjava26@gmail.com");
	}

	@Test
	public void saveStudentTest() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Student student = new Student();
		student.setName("vicky");
		student.setMobileNo("9898012121");
		student.setEmail("vicky@gmail.com");
		mvc.perform(MockMvcRequestBuilders.post("/api/students")
				.content(objectMapper.writeValueAsString(student))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").exists());

	}

}
