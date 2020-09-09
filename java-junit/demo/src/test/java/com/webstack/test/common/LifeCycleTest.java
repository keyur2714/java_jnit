package com.webstack.test.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LifeCycleTest {

	@BeforeEach
	public void beforeEach() {
		System.out.println("Before Each");
	}

	@AfterEach
	public void afterEach() {
		System.out.println("After Each");
	}

	@BeforeAll
	public static void beforeAll() {
		System.out.println("Before All");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("After All");
	}

	@Test
	@DisplayName("Check Valid Names")
	public void checkValidName() {
		String name = "keyur";
		System.out.println(name);
		assertEquals("keyur", name);
	}
}
