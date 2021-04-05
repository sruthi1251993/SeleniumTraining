package datadrivenTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.utilityclass.Xls_Reader;

public class RegFBDataDr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Xls_Reader reader = new Xls_Reader("C:\\sruthi-selenium\\practiceTest\\TestFacebook\\src\\"
				+ "datadrivenTesting\\Book1.xlsx");
		int rowCount = reader.getRowCount("RegisterFB");
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\sruthi-selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		
		for(int i =2;i<=rowCount;i++) {
		String firstName = reader.getCellData("RegisterFB", "firstname", i);
		String surName = reader.getCellData("RegisterFB", "surname", i);
		String mobileno = reader.getCellData("RegisterFB", "mobileno", i);
		String password = reader.getCellData("RegisterFB", "password", i);
		String days = reader.getCellData("RegisterFB", "day", i);
		int dayNo1 = Float.valueOf(days).intValue();
 		String dayNo = String.valueOf(dayNo1);
		String months= reader.getCellData("RegisterFB", "month", i);
		String years = reader.getCellData("RegisterFB", "year", i);
		System.out.println(years);
		int yearNo = Float.valueOf(years).intValue();
		
	
		driver.findElement(By.xpath("//input[@id='u_0_l']")).clear();
		driver.findElement(By.xpath("//input[@id='u_0_l']")).sendKeys(firstName);;
		driver.findElement(By.id("u_0_n")).clear();
		driver.findElement(By.id("u_0_n")).sendKeys(surName);
		driver.findElement(By.id("u_0_q")).clear();
		driver.findElement(By.id("u_0_q")).sendKeys(mobileno);
		driver.findElement(By.id("u_0_x")).clear();
		driver.findElement(By.id("u_0_x")).sendKeys(password);

	
		Select day = new Select(driver.findElement(By.id("day")));
		day.selectByValue(dayNo);

		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByVisibleText(months);

		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByIndex(yearNo);

		WebElement gender = driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
		gender.click();

	//	WebElement submit = driver.findElement(By.xpath("//button[@id='u_0_15']"));
		//submit.click();
		}
	}

}
