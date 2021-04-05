package sampleTests;


import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class DependsOnMethodsTimeOutEnable {
	int a,b;
	
	@Parameters({ "welcome" })
	@Test
	public void test1(String welcome) {
		 a=10;
		System.out.println("test 1: "+a);
		System.out.println("welcome note:" + welcome);
	}
	
	@Test
	public void test2() {
		b=5;
		System.out.println("test 2: "+a+b);
	}
	
	public void Atest3() {
		int c = 5;
		System.out.println("test 3: "+a+b+c);
	}
	
	@Test
	public void test() {
		int d= a*a*a*a;
		System.out.println(d); 
		System.out.println("testing depends,timeout,enabled parameters");
	}

}
