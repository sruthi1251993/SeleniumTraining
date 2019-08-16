package keywordDrivenFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyWordEngine {

	public WebDriver driver;
	public Properties prop;

	public static Workbook book;
	public static Sheet sheet;

	public BaseClass base;
	public WebElement element;

	public final String SCENARIO_SHEET_PATH = "C:\\sruthi-selenium\\practiceTest\\TestFacebook\\"
			+ "src\\keywordDrivenFramework\\facebook_scenarios.xlsx";

	public void startExecution(String sheetName) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(SCENARIO_SHEET_PATH);
			try {
				book = WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException | IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);

		int k = 0;

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			try {
				String locatorType = sheet.getRow(i).getCell(k + 1).toString().trim();
				String locatorValue = sheet.getRow(i).getCell(k + 2).toString().trim();
				String action = sheet.getRow(i).getCell(k + 3).toString().trim();
				String value = sheet.getRow(i).getCell(k + 4).toString().trim();

				switch (action) {

				case "open browser":
					base = new BaseClass();
					prop = base.initProp();
					if (value.isEmpty() || value.equals("NA")) {
						driver = base.initDriver(prop.getProperty("browser"));
					} else {
						driver = base.initDriver(value);
					}
					break;

				case "enter url":
					if (value.isEmpty() || value.equals("NA")) {
						driver.get(prop.getProperty("url"));
					} else {
						driver.get(value);
					}
					break;

				case "quit":
					driver.quit();
					break;

				default:
					break;
				}

				switch (locatorType) {

				case "id":

					element = driver.findElement(By.id(locatorValue));
					if (action.equalsIgnoreCase("sendKeys")) {
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						element.isDisplayed();
					} else if (action.equalsIgnoreCase("getText")) {
						String elementText = element.getText();
						System.out.println("text from element : " + elementText);
					}
					locatorType = null;
					break;

				case "name":

					element = driver.findElement(By.name(locatorValue));
					if (action.equalsIgnoreCase("sendKeys")) {
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						element.isDisplayed();
					} else if (action.equalsIgnoreCase("getText")) {
						String elementText = element.getText();
						System.out.println("text from element : " + elementText);
					}
					locatorType = null;
					break;
					
					
				case "xpath":

					element = driver.findElement(By.xpath(locatorValue));
					if (action.equalsIgnoreCase("sendKeys")) {
						element.clear();
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						element.isDisplayed();
					} else if (action.equalsIgnoreCase("getText")) {
						String elementText = element.getText();
						System.out.println("text from element : " + elementText);
					}
					locatorType = null;
					break;
					
				
				case "linkText":

					element = driver.findElement(By.linkText(locatorValue));
					if (action.equalsIgnoreCase("click")) {
						element.click();
					}
					locatorType = null;
					break;

				default:
					break;
				}
				
			}catch(Exception e) {
				
			}

				}

	}

}
