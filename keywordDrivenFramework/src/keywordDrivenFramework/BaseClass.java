package keywordDrivenFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	WebDriver driver;
	Properties prop;

	public WebDriver initDriver(String browserName) {
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\sruthi-selenium\\chromedriver.exe");
			if (prop.getProperty("headless").equals("yes")) {
				// headless mode:
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\sruthi-selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public Properties initProp() {

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\sruthi-selenium\\practiceTest\\"
					+ "TestFacebook\\src\\keywordDrivenFramework\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
}
