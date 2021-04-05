package dataDrivenUsingTestng;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLogin {
	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\sruthi-selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");
	}

	@Test(dataProvider="getTestData")
	public void logIn(String username, String pswd) {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(pswd);
		driver.findElement(By.linkText("Log In")).click();
	}

	@DataProvider
	public String[][] getTestData() throws InvalidFormatException, IOException {
		ReadExcel data = new ReadExcel();
		return data.getCellData("C:\\sruthi-selenium\\practiceTest\\TestFacebook\\src\\datadrivenTesting\\Book1.xlsx",
				"loginFB");

	}
	
	@AfterSuite
	public void closePage() {
		driver.close();
	}
	
	

}
