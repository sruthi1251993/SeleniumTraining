package testFacebook;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginPage extends BaseClass {
	WebDriverWait wait;
	
	@Test(dependsOnMethods = { "passLoginDetails" }) 
	//@Test(enabled=True)
	public void navigateBack() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.navigate().back();
		//driver.close();
		 //wait = new WebDriverWait(driver, 20);
		}

	@Test
	public void getTitle() {
		String Title = driver.getTitle();
		System.out.println(Title);
	}

	@Test
	public void passLoginDetails() throws IOException {
		driver.findElement(By.id("email")).sendKeys(prop.get("username").toString());
		driver.findElement(By.name("pass")).sendKeys(prop.get("password").toString());
		
		driver.findElement(By.linkText("Log In")).click();
		
		System.out.println("After login title of the page is:"+driver.getTitle());
		
			}
}
