package sampleTests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstTestng {

	@Test(groups= {"Smoke"})
	public void helloworld() {
		System.out.println("hello world in testng framework");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}
	
	
	@Test(dataProvider="dataProvider")
	public void dataproviderMethod(String username,String password) {
		System.out.println(username);
		System.out.println(password);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method in firsttestng class");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}
	
	@DataProvider
	public Object[][] dataProvider() {
		
		//1- username,paswrd - top score
		//2- username,pswd - last score
		//3- username,pswd - absent 
		
		Object[][] data = new Object[3][2]; //3 rows , 2 columns
		
		data[0][0] = "topusername";
		data[0][1] = "topuserpswd";
		
		data[1][0] = "lastusername";
		data[1][1] = "lastuserpswd";

		data[2][0] = "absentser";
		data[2][1] = "absentpaswd";
		
		return data;
		
	}
	
	
}
