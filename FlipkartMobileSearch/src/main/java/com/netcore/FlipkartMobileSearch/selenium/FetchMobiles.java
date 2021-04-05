package com.netcore.FlipkartMobileSearch.selenium;

import com.netcore.FlipkartMobileSearch.model.Mobile;
import com.netcore.FlipkartMobileSearch.utils.StringParserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class FetchMobiles {

  private WebDriver driver;

  public FetchMobiles(WebDriver driver) {
    this.driver = driver;
  }

  public List<Mobile> fetchMobilesFromUi() throws InterruptedException {

    driver.get("https://www.flipkart.com/");

    Actions actions = new Actions(driver);

    Action sendEsc = actions.sendKeys(Keys.ESCAPE).build();

    sendEsc.perform();


    driver.findElement(By.className("L0Z3Pu")).click();


    driver.findElement(By.name("q")).sendKeys("iphones under 40000");
    driver.findElement(By.className("L0Z3Pu")).click();

    Thread.sleep(4000);

    String xPathMobiles = "//*[@class='_1YokD2 _3Mn1Gg']/div";


    List<WebElement> list = driver.findElements(By.xpath(xPathMobiles));

    String name = null;
    String prodPrice = null;
    String ratings = null;

    List<Mobile> mobileList = new ArrayList<>();
    Mobile mobile = null;

    for (int i = 2; i < list.size(); i++) {

      String mobileNameXpath = "//*[@class='_1YokD2 _3Mn1Gg']/div[" + i + "]/div/div/div/a/div[2]/div[1]/div[1]";
      String priceXpath = "//*[@class='_1YokD2 _3Mn1Gg']/div[" + i + "]/div/div/div/a/div[2]/div[2]/div[1]/div/div[1]";
      String ratingElementPath = "//*[@class='_1YokD2 _3Mn1Gg']/div[" + i + "]/div/div/div/a/div[2]/div[1]/div[2]/span[2]/span/span[1]";

      prodPrice = driver.findElement(By.xpath(priceXpath)).getText();
      int priceInt = StringParserUtils.parseAndGetPrice(prodPrice);

      if (priceInt > 40000) {
        break;
      }

      name = driver.findElement(By.xpath(mobileNameXpath)).getText();
      ratings = driver.findElement(By.xpath(ratingElementPath)).getText().split(" ")[0];

      mobile = new Mobile(name, prodPrice, ratings);

      mobile.setPriceInInt(priceInt)
          .setStorage(StringParserUtils.parseAndGetStorage(name))
          .setRatingsInInt(StringParserUtils.parseAndGetRatings(ratings));

      mobileList.add(mobile);
    }
    return mobileList;
  }
}
