package testFacebook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ForgotPswrdPage extends BaseClass {

	@Test
	public void forgottenPassword() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Forgotten account?")).click();
		
		driver.findElement(By.id("identify_email")).sendKeys(prop.get("username").toString());
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		
	}
	
}
