package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Dell on 09/04/2017.
 */
public class CartPage extends Utils{

    public void checkOutShoppingCart() {
        //Click on Shopping Cart
        clickOnElement(By.linkText("shopping cart"));
        //Select destination to get a shipping estimate
        selectText(By.id("CountryId"), "United Kingdom");
        //Click on Terms of service
        clickOnElement(By.id("termsofservice"));
        //Click on Checkout
        clickOnElement(By.id("checkout"));
        //Verifing Returning Customer Login, Checkout As A Guest and Register Text is Present
        Assert.assertTrue(Utils.isElementPresent(By.xpath("//h1[contains(.,'Welcome, Please Sign In!')]")));
        Assert.assertTrue(Utils.isElementPresent(By.xpath("//strong[contains(.,'Checkout as a guest or register')]")));
        Assert.assertTrue(Utils.isElementPresent(By.xpath("//strong[contains(.,'Returning Customer')]")));

    }

    public void clickOnCheckOutAsAGuest(){
        //Click on Checkout as a guest
        clickOnElement(By.xpath("//input[@value='Checkout as Guest']"));
        Assert.assertEquals("Checkout", Utils.getTextFromElement(By.xpath("//h1[contains(.,'Checkout')]")));
    }

    public void checkOutAsAReturningCustomer(){

    }

    public void clickOnCheckOutAndRegister(){

    }
}
