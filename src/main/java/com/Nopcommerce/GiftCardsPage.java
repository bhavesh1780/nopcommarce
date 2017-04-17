package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Dell on 15/04/2017.
 */
public class GiftCardsPage extends Utils {

    public void emailGiftCardToFriend(){

        //Click on Virtual Gift Card
        clickOnElement(By.xpath("//div[@class='item-box']/div/div"));
        //Add Recipients Details
        typeText(By.id("giftcard_43_RecipientName"),"Test");
        typeText(By.id("giftcard_43_RecipientEmail"),"lotus7143@gmail.com");
        typeText(By.id("giftcard_43_Message"),"Gift from friend");
        //Click on Add to Cart
        clickOnElement(By.xpath("//div[@class='add-to-cart']/div"));
        Assert.assertTrue(Utils.getTextFromElement(By.xpath("//div[@id='bar-notification']/p")).contains("The product has been added to your shopping cart"));
        //Click on Email a friend
        clickOnElement(By.xpath("//input[@class='button-2 email-a-friend-button']"));
        Assert.assertTrue(Utils.isElementPresent(By.xpath("//h1[contains(.,'Email a friend')]")));
        //Input Friend details to Email
        typeText(By.id("FriendEmail"),"lotus7143@gmail.com");
        typeText(By.id("PersonalMessage"),"Gift from friend");
        clickOnElement(By.xpath("//input[@class='button-1 send-email-a-friend-button']"));
        Assert.assertTrue(Utils.isElementPresent(By.xpath("//div[@class='page-body']/div[2]")));
    }
}
