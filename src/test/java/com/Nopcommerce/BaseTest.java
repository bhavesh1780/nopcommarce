package com.Nopcommerce;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple BasePage.
 */
public class BaseTest extends BasePage
{


 @BeforeMethod
    public void openBrowser(){
     driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://demo.nopcommerce.com/");
  }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
     }

}
