package sampleTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}
	
	@Test
	public void testMethod() {
		System.out.println("test method in annotations");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}
	
	@Test
	public void secondTestMethod() {
		System.out.println("second test method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class in annotatios");
	}
}
