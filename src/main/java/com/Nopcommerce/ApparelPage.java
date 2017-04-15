package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Dell on 12/04/2017.
 */
public class ApparelPage extends Utils {

    public void selectApparelAndAddToCart(){
        //Click on Clothing on left side menu
        clickOnElement(By.xpath("//div[@class='listbox']/ul/li[3]/ul/li[2]/a"));
        //Click on Sort by
        selectText(By.xpath("//select[@id='products-orderby']"),"Price: Low to High");
        //Select number of Product to be displayed on page
        selectText(By.id("products-pagesize"),"3");
        //Click on view as list
        clickOnElement(By.xpath("//div[@class='product-viewmode']/a[2]"));
        //Click on product to compare
        clickOnElement(By.xpath("//div[2]/div/div[2]/div[3]/div[2]/input[2]"));
        //Click on notification bar to clear
        clickOnElement(By.xpath("//div[@id='bar-notification']/span"));
        sleep(5);
        //Click on product to compare
        clickOnElement(By.xpath("//div[3]/div/div[2]/div[3]/div[2]/input[2]"));
        //Take a Screenshot of the product Comparision
        browserScreenShot("C:\\Users\\Dell\\IdeaProjects\\ScreenShots");
        //Click on Notification Bar
        clickOnElement(By.linkText("product comparison"));
        //Assert if you are on Comparision page
        Assert.assertTrue(Utils.isElementPresent(By.xpath("//h1[contains(.,'Compare products')]")));
        //Click on Clear Compare list
        browserScreenShot("C:\\Users\\Dell\\IdeaProjects\\ScreenShots");
        clickOnElement(By.className("clear-list"));

    }


}
