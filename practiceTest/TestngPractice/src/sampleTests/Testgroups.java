package sampleTests;

import org.testng.annotations.Test;

public class Testgroups {

		@Test
		public void groupTest() {
			System.out.println("group test");
		}
		
		@Test(groups={"Smoke"})
		public void test() {
			System.out.println("test");
		}
}
