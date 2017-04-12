package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * Created by Dell on 09/04/2017.
 */
public class BookPage extends Utils {

        public void selectAndAddBookToCart(){

        clickOnElement(By.xpath("//div[@class='header-menu']/ul/li[5]"));
        //Click on Book Fahrenheit 451 by Ray Bradbury
        clickOnElement(By.xpath("//div[@class='item-box']/div[1]/div/h2"));
        //Enter the Quantity you want
        typeText(By.id("addtocart_37_EnteredQuantity"),"4");
        //Click on Add to Cart Button
        clickOnElement(By.id("add-to-cart-button-37"));
        //To clear click on Message Displayed on top of the page Product added to Shopping cart
        clickOnElement(By.xpath("//body/div[5]/span"));

    }
}
