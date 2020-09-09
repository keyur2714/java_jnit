package com.webstack.test.utiltest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.webstack.demo.util.NumericOperationUtil;

import junit.framework.Assert;

public class NumericUtilTest {

	private static NumericOperationUtil numericOperationUtil;
	
	@BeforeEach
	public void init() {
		numericOperationUtil = new NumericOperationUtil();
	}
	
	@Test
	@DisplayName("Check Add Method")
	public void testAddition() {		
		assertEquals(12, numericOperationUtil.add(5, 7));
	}
	
	@Test
	@DisplayName("Check sub Method")
	@Tag("development")
	public void testSubstraction() {		
		assertEquals(7, numericOperationUtil.sub(9, 2));
	}
	
	
	@Test
	@DisplayName("Check Multiplication Method")
	@Tag("production")
	public void testMultiplication() {		
		assertEquals(18, numericOperationUtil.mul(9, 2));
	}
	
	
	@Test
	@DisplayName("Check Division Method")
	@Tag("uat")
	public void testDivision() {		
		assertEquals(4, numericOperationUtil.div(8, 2));
	}
	
	@AfterAll
	public static void destroy(){
		numericOperationUtil = null;
	}
}
