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


    @Test
    public void userShoulsAbleToRegisterSuccessfullyAndLoginSuccessfully(){
          homePage.clickOnRegisterButton();
          registrationPage.registerNewUSer();
          Assert.assertEquals("Your registration completed", Utils.getTextFromElement(By.className("result")) );
          Assert.assertTrue(Utils.getTextFromElement(By.linkText("Log out")).contains("Log out"),"User is not Login Successfully");
        }

    @Test
    public void userShouldAbleToPurchaseSuccessfully(){
        bookPage.clickOnBookPageMenu();
        Assert.assertTrue(Utils.isElementPresent(By.xpath("//div[@class='master-wrapper-content']/div/div/div/div/h1")));
    }
}

