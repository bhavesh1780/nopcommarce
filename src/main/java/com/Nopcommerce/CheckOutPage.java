package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * Created by Dell on 10/04/2017.
 */
public class CheckOutPage extends Utils{

    public void enterCheckOutDetails(){
        //Click the checkbox Ship to same Address
        selectCheckbox(By.xpath("//label[contains(.,'Ship to the same address')]"));
        //Enter Billing Address
        typeText(By.id("BillingNewAddress_FirstName"),"Test");
        typeText(By.id("BillingNewAddress_LastName"),"AutoTest");
        typeText(By.id("BillingNewAddress_Email"),"xyz@gmail.com");
        selectText(By.id("BillingNewAddress_CountryId"),"United Kingdom");
        typeText(By.id("BillingNewAddress_City"),"London");
        typeText(By.id("BillingNewAddress_Address1"),"123 Any Where");
        typeText(By.id("BillingNewAddress_ZipPostalCode"),"HA8 1AH");
        typeText(By.id("BillingNewAddress_PhoneNumber"),"0788654321");
        clickOnElement(By.xpath("//input[contains(@value,'Continue')]"));
        //Click on Continue
        clickOnElement(By.xpath("//div[@id='shipping-buttons-container']/input"));
        //Select Shipping Method
        clickOnElement(By.xpath("//input[contains(@class,'shipping-method-next-step-button')]"));
        //Select Payment Type
        clickOnElement(By.id("paymentmethod_1"));
        //Click on Continue
        clickOnElement(By.xpath("//input[contains(@class,'payment-method-next-step-button')]"));
        //Enter Payment Information
        selectText(By.xpath("//select[@id='CreditCardType']"),"Master card");
        typeText(By.id("CardholderName"),"Test");
        typeText(By.id("CardNumber"),"5190 3670 6278 1788");
        selectText(By.id("ExpireMonth"),"02");
        selectText(By.id("ExpireYear"),"2018");
        typeText(By.id("CardCode"),"672");
        //Click on Continue
        clickOnElement(By.xpath("//input[contains(@class,'payment-info-next-step-button')]"));
        //Click on confirm to order
        clickOnElement(By.xpath("//input[contains(@class,'confirm-order-next-step-button')]"));


    }


}
