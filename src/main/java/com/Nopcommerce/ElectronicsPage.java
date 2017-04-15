package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Dell on 14/04/2017.
 */
public class ElectronicsPage extends Utils {

    public void clickOnCellPhone(){
        //Click on Cell Phone
        clickOnElement(By.xpath("//div[@class='listbox']/ul/li[2]/ul/li[2]/a"));
        Assert.assertTrue(driver.getCurrentUrl().contains("cell-phones"),"User is not on Cell Phone Page");

    }
}
