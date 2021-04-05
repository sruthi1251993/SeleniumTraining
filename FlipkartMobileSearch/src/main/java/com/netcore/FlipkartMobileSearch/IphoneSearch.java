package com.netcore.FlipkartMobileSearch;

import com.netcore.FlipkartMobileSearch.convertor.CsvConvertor;
import com.netcore.FlipkartMobileSearch.model.Mobile;
import com.netcore.FlipkartMobileSearch.selenium.FetchMobiles;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;


public class IphoneSearch {

  private static final Logger logger = LoggerFactory.getLogger(IphoneSearch.class);

  public static void main(String[] args) throws InterruptedException, IOException {

    String browser = "CHROME";

    if (args != null && args.length > 0) {
      browser = args[0];
    } else {
      logger.info("No browser entered, defaulting it to CHROME browser");
    }

    WebDriver driver = setAndGetWebDriver(browser);

    FetchMobiles mobileDetails = new FetchMobiles(driver);

    List<Mobile> mobileList = mobileDetails.fetchMobilesFromUi();

    CsvConvertor csvConvertor = new CsvConvertor();

    csvConvertor.sortAndExportToCsv(mobileList);


  }

  private static WebDriver setAndGetWebDriver(String browserType) {
    WebDriver driver = null;
    DriverManagerType driverManagerType = null;
    try {
      if (StringUtils.isNotBlank(browserType)) {
        driverManagerType = DriverManagerType.valueOf(browserType);
      }
    } catch (IllegalArgumentException ex) {
      logger.error("Entered browser is invalid {}", browserType);
      logger.info("Supported browsers are CHROME, FIREFOX, SAFARI");
      System.exit(1);
    }

    WebDriverManager.getInstance(driverManagerType).setup();

    switch (driverManagerType) {
      case CHROME:
        driver = new ChromeDriver();
        break;
      case SAFARI:
        driver = new SafariDriver();
        break;
      case FIREFOX:
        driver = new FirefoxDriver();
        break;
      default:
        driver = new ChromeDriver();
        break;
    }

    return driver;
  }

}