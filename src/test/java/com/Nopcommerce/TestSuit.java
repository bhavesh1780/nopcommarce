package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Dell on 08/04/2017.
 */
public class TestSuit extends BaseTest {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();
    CartPage cartPage = new CartPage();
    CheckOutPage checkOutPage = new CheckOutPage();


    @Test
    public void userShouldAbleToRegisterSuccessfullyAndLoginSuccessfully(){
          homePage.clickOnRegisterButton();
          registrationPage.registerNewUSer();
          Assert.assertEquals("Your registration completed", Utils.getTextFromElement(By.className("result")) );
          Assert.assertTrue(Utils.getTextFromElement(By.linkText("Log out")).contains("Log out"),"User is not Login Successfully");
        }

    @Test
    public void userShouldAbleToPurchaseSuccessfully(){
        bookPage.selectAndAddBookToCart();
        Assert.assertTrue(Utils.isElementPresent(By.linkText("shopping cart")));
    }

    @Test
    public void userShouldAbleToPurchaseProductSuccessfullyAsAGuest(){
        bookPage.selectAndAddBookToCart();
        cartPage.checkOutShoppingCart();
        cartPage.clickOnCheckOutAsAGuest();
        checkOutPage.enterCheckOutDetails();
        Assert.assertTrue(Utils.isElementPresent(By.xpath("//strong[contains(.,'Your order has been successfully processed!')]")));
    }


}

