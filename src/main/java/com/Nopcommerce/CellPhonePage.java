package com.Nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Dell on 15/04/2017.
 */
public class CellPhonePage extends Utils {

    public void selectCellPhonesAndAddToCart() {

        //adding the 1st cellphone product into cart
        clickOnElement(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/input"));
        Assert.assertTrue(Utils.getTextFromElement(By.xpath("//div[@id='bar-notification']/p")).contains("The product has been added to your shopping cart"));

        getPrice(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div"), By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/h2"));

        driver.navigate().refresh();

        //adding the 2nd cellphone product into cart
        clickOnElement(By.xpath("//div[@class='item-grid']/div[2]/div/div[2]/div[3]/div[2]/input"));
        Assert.assertTrue(Utils.getTextFromElement(By.xpath("//div[@id='bar-notification']/p")).contains("The product has been added to your shopping cart"));

        getPrice(By.xpath("//div[@class='item-grid']/div[2]/div/div[2]/div[3]/div"), By.xpath("//div[@class='item-grid']/div[2]/div/div[2]/h2"));
        driver.navigate().refresh();
        // added 3rd cell phone product into cart
        clickOnElement(By.xpath("//div[@class='item-grid']/div[3]/div/div[2]/div[3]/div[2]/input"));
        Assert.assertTrue(Utils.getTextFromElement(By.xpath("//div[@id='bar-notification']/p")).contains("The product has been added to your shopping cart"));

        getPrice(By.xpath("//div[@class='item-grid']/div[3]/div/div[2]/div[3]/div"), By.xpath("//div[@class='item-grid']/div[3]/div/div[2]/h2"));


    }

    public void getAllProductsFrfomTheCellphonePage() {
        WebElement itemgrid = driver.findElement(By.className("item-grid"));
        List<WebElement> divs = itemgrid.findElements(By.xpath("//div[@class='item-box']"));
        java.util.Iterator<WebElement> i = divs.iterator();
        while (i.hasNext()) {
            WebElement div = i.next();
            System.out.println(div.getText());
        }
    }

    public void addAllProductsToCart() {
        WebElement itemgrid = driver.findElement(By.className("item-grid"));
        List<WebElement> addToBasketButtons = itemgrid.findElements(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/input"));
        java.util.Iterator<WebElement> j = addToBasketButtons.iterator();
        while (j.hasNext()) {
            WebElement addToBasket = j.next();
            driver.navigate().refresh();
            addToBasket.click();

        }
    }
}