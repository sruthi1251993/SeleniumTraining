package testFacebook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClass {

	public String BaseUrl = "https://www.facebook.com/";
	public WebDriver driver;
	public Properties prop;

	@BeforeSuite
	public void setBaseProp() {
		System.setProperty("webdriver.chrome.driver", "C:\\sruthi-selenium\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\sruthi-selenium\\geckodriver.exe");
	}

	@Test
	public void basemethod() throws IOException {
		// create object for chrome driver
		prop = new Properties();
		File file = new File(
				"C:\\sruthi-selenium\\practiceTest\\TestFacebook\\src\\testFacebook\\dataDriven.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);

		// chrome driver
		if (prop.get("browser").equals("chrome")) {
			driver = new ChromeDriver();
			driver.get(prop.getProperty("URL"));
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}

		// firefox
		if (prop.get("browser").equals("firefox")) {
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();
		}
	}

}
