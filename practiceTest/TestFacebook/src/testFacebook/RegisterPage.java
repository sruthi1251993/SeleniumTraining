package testFacebook;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RegisterPage extends BaseClass {

	public String phoneNumber;

	// @Test(dependsOnMethods= {"passLoginDetails","navigateBack"})
	@Test
	public void createAccount() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// By FirstName = By.xpath("//input//input[@id='u_0_l']");
		// WebElement element =
		// wait.until(ExpectedConditions.presenceOfElementLocated(FirstName));
		WebElement FirstName = driver.findElement(By.xpath("//input[@id='u_0_l']"));

		System.out.println("error occuring");
		WebElement SurName = driver.findElement(By.id("u_0_n"));
		WebElement phoneNumber = driver.findElement(By.id("u_0_q"));
		WebElement password = driver.findElement(By.id("u_0_x"));

		FirstName.sendKeys("fisrtnjhjh");
		SurName.sendKeys("surname");
		phoneNumber.sendKeys("7458961ui2");
		password.sendKeys("*******");

		Select day = new Select(driver.findElement(By.id("day")));
		day.selectByValue("12");

		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByVisibleText("May");

		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByIndex(10);

		WebElement gender = driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
		gender.click();

		WebElement submit = driver.findElement(By.xpath("//button[@id='u_0_15']"));
		submit.click();
	}

	@Test(dependsOnMethods = { "createAccount" })
	public void testInvalidMobileNumber() {
		WebElement checkNo = driver.findElement(By.xpath("//input[@aria-invalid='true']"));
		if (checkNo != null) {
			System.out.println("invalid mobile number ");
		}
	}
}
