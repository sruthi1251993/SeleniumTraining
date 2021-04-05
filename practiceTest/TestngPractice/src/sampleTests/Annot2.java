package sampleTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Annot2 {

	@BeforeClass
	public void beforeClass() {
		System.out.println("before class in annot2 class");
	}
	
	@Test
	public void test() {
		System.out.println("test method in annot2 class");
	}
	
	@Test(groups={"Smoke"})
	public void aTest() {
		System.out.println("A test");
	}
}
