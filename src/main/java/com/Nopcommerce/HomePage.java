package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Dell on 08/04/2017.
 */
public class HomePage extends Utils {

    public void clickOnRegisterButton(){
        // click on 'Register' button from top menu bar
        clickOnElement(By.xpath("//a[@class=\"ico-register\"]"));
        // Verify if user is navigated to registration page successfully
        Assert.assertEquals("Register", getTextFromElement(By.xpath("//div[@class='page-title']/h1")) );

    }

    public void clickOnLogInButton(){
        // click on login button
        clickOnElement(By.linkText("Log in"));
        // Verify if user is navigated to Log in page successfully
        Assert.assertEquals("Welcome, Please Sign In!", getTextFromElement(By.className("page-title")));

    }

    public void clickOnLogOutButton(){
        // Explicitly waiting for 'log out' button to be clickable
        waitTillElementIsClickable(By.linkText("Log out"), 3);
        //click on logout button
        clickOnElement(By.linkText("Log out"));
        //Verify if user is navigated to Logged Out
        Assert.assertTrue(isElementPresent(By.linkText("Log in")));

    }

    public void clickOnShoppingCart(){
        //Click on Shopping Cart to go to shopping cart
        clickOnElement(By.linkText("shopping cart"));
        //Verify if user is navigated to Shopping cart page
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "We have not reached to Cart Page");

    }

    public void clickOnWishList(){
        //Click on Wishlist on Home Page
        clickOnElement(By.xpath("//span[contains(.,'Wishlist')]"));
        //Verify if user is navigated to Wishlist page
        Assert.assertTrue(driver.getCurrentUrl().contains("wishlist"),"We have not reached to Wishlist page");

    }

    public void clickOnSearch(){
        //Click on Search on Home page
        clickOnElement(By.id("small-searchterms"));

    }

    public void clickOnComputersCategory(){
        //Click on Computers Menu on Homepage
        clickOnElement(By.linkText("Computers"));
        //Verify if user is navigated to Computers page
        Assert.assertTrue(driver.getCurrentUrl().contains("computers"),"We have not reached to Computers page");
    }

    public void clickOnApparelCategory(){
        //Click on Apparel Menu on Homepage
        clickOnElement(By.linkText("Apparel"));
        //Verify if user is navigated to Apparel page
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@class='breadcrumb']/ul/li[2]")).contains("Apparel"), "We have not reached to Apparel page");

    }

    public void clickOnBooksCategory() {
        //Click on Book Menu on Homepage
        clickOnElement(By.xpath("//div[@class='header-menu']/ul/li[5]"));
        //Verify if user is navigated to Book page
        Assert.assertTrue(driver.getCurrentUrl().contains("books"), "We have not reached to Book page");
    }

    public void clickOnGiftCardCategory(){
        //Click on GiftCard Menu on Homepage
        clickOnElement(By.linkText("Gift Cards"));
        //Verify if user is navigated to GiftCard page
        assertByGetText(By.xpath("//h1[contains(.,'Gift Cards')]"), "Gift Cards", "We  have not reached to Gift Cards Page");
    }
}
