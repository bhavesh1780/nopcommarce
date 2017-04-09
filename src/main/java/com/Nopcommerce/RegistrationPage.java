package com.Nopcommerce;

import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dell on 08/04/2017.
 */
public class RegistrationPage extends Utils {

    public void registerNewUSer(){
        // selecting Gender : Male
        clickOnElement(By.id("gender-male"));
        // Sending "Test" in FirstName
        typeText(By.xpath("//input[@id=\"FirstName\"]"), "Test");
        // Sending "Demo" in Lastname
        typeText(By.xpath("//input[@id=\"LastName\"]"),"Test");
        // Selecting Date of Birth
        selectValue(By.name("DateOfBirthDay"),"10");
        selectIndex(By.name("DateOfBirthMonth"), 1);
        selectText(By.name("DateOfBirthYear"),"1978");
        // Creating timestamp for everytime new UNIQUE email address
        Date date = new Date();
        SimpleDateFormat x = new SimpleDateFormat("ddmmyyhhss");
        String y = x.format(date);
        // Concatinating the timestamp with email address
        String email = "xyz"+y+"@gmail.com";
        // Sending email into Email address box
        typeText(By.xpath("//input[@id=\"Email\"]"), email);
        System.out.println(email);
        // Typing company name
        typeText(By.xpath("//input[@id=\"Company\"]"),"Test");
        // Clcik on the chekbox for 'Newsletter'
        selectCheckbox(By.id("Newsletter"));
        // Typing the password
        typeText(By.xpath("//input[@id=\"Password\"]"),"Patel1");
        // Confirming password
        typeText(By.xpath("//input[@id=\"ConfirmPassword\"]"),"Patel1");
        // CLick on Register button
        clickOnElement(By.xpath("//input[@id=\"register-button\"]"));
    }
}
