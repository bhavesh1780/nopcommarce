package com.Nopcommerce;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Dell on 08/04/2017.
 */
public class Utils extends BasePage
{
    // re-usable method for typing text into element (instead of sendKeys())
    public static void typeText(By by, String text){
        //clearing any existing text from the element
        driver.findElement(by).clear();
        //sending your text to the locator by
        driver.findElement(by).sendKeys(text);
    }

    // re-usable method to click on element
    public static void clickOnElement(By by){
        driver.findElement(by).click();
    }

    // re-usable method for Thread.sleep
    public static void sleep(int i){
        try {
            Thread.sleep(i * 1000);   // we are converting the millisecond into seconds
        } catch (InterruptedException e) {    //Thread.sleep producing IntrruptedException and we are handling it by using try and catch
            e.printStackTrace();
        }
    }
    //Reusable method for selecting checkbox
    public static void selectCheckbox(By by){
        if (!driver.findElement(by).isSelected()){   // check if the checkbox is NOT ticked/selected
            driver.findElement(by).click();          // tick on the checkbox
        }
    }
    //Reusable method for selectByVisibleText(NameLassObject)
    public static void selectText(By by, String text){

        new Select(driver.findElement(by)).selectByVisibleText(text);
    }
    //Reusable Method for selectByValue
    public static void selectValue(By by, String value){
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }
    //Reusable method for selectByIndex
    public static void selectIndex(By by, int i){
        Select select;
        new Select(driver.findElement(by)).selectByIndex(i);
    }
    //Reusable method for getText
    public static String getTextFromElement(By by){     //return type as String - why? to store and return the test we are receving from the element
        String text =  driver.findElement(by).getText();                                                          // so we can reuse the text
        return text;
    }
//    //Reusable method for isDisplayed
//    public static boolean checkIfElementIsDisplayed(By by){
//        driver.findElement(by).isDisplayed();
//        return true;
//    }

    //Reusable method to scrollPage
    public static void scrollPage(int x, int y){
        ((JavascriptExecutor)driver).executeScript("scroll(x,y)");
    }

    //Reusable method for Explicit wait until element to be present
    public static void waitForElementToBePresent(By by,int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //Reusable boolean method for verifying  if element is present
    public static boolean isElementPresent(By by){
        try{
            return driver.findElement(by).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    //Reusable method for Waiting for Element to be Present
    public static void waitElementPresent(By by){
        int counter = 0;
        while (counter <= 10){

            try {
                if (driver.findElement(by).isDisplayed()){
                    counter++;
                    System.out.println("Waiting for a Second.....");
                    sleep(1);
                }else {
                    return;
                }

            }catch (Exception e){
            return;
            }

        }
    }

    //Reusable method for Explicit wait until element is clickable
    public static void waitTillElementIsClickable(By by,int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //Reusable method for Explicit wait until element is visible
    public static void waitTillElementIsVisible(By by,int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Reusable method for Explicit wait until element is selected
    public static void waitTillElementIsSelected(By by,int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

//    //Reusable method for Explicit wait until polling element till its visible
//    public static void explicitPollingWaitElementTillVisible(By by,int seconds){
//        WebDriverWait wait = new WebDriverWait(driver,seconds);
////        wait.until(ExpectedConditions.(by));
//    }

//    //Reusable method for Explicit wait until element is disable located
//    public static void explicitWaitElementIsDisable(By by,int seconds){
//        WebDriverWait wait = new WebDriverWait(driver,seconds);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
//    }

//    //Reusable method for Explicit wait until element is disable Text
//    public static void explicitWaitElementIsVisible(By by,String text,int seconds){
//        WebDriverWait wait = new WebDriverWait(driver,seconds);
//        wait.until(ExpectedConditions.invisibilityOfElementWithText(by,text));
//    }

    //Reusable method for date stamp
    public static String dateStamp(){
        DateFormat dateFormat = new SimpleDateFormat("ddmmyyhhss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        return date1;
    }

    //Reusable method for Browser Screen Shot
    public static void browserScreenShot(String filepath){
        TakesScreenshot screenShot = (TakesScreenshot)driver;
        File screenShot1 = screenShot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot1,new File(filepath+"\\Photo"+dateStamp()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Reusable method for Print Screen Shot
    public static void printScreenShot(String filepath){
        try {
            Robot robot = new Robot();
            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(screenShot,"jpg",new File(filepath+"\\Photo"+dateStamp()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }catch (AWTException e) {
            e.printStackTrace();
        }
    }

    //Reusable method to print Random Number
    public static int randomNumber(int range){
        Random random = new Random();
        int number = random.nextInt(range);
        return number;

    }

    //Reusable method to get text by Attribute
    public static String getTextByAttribute(By by, String attributeName){
        String text = driver.findElement(by).getAttribute(attributeName);
        return text;
    }

    //Reusable method for drop down selection by Attributes if select class is not available
    public static void dropDownSelectionByAttribute(By by, String attributeName, String dropDownText){
        java.util.List<WebElement> size_menu = driver.findElements(by);
        for(WebElement element : size_menu){
            String innerTxt = element.getAttribute(attributeName);
            if(innerTxt.contentEquals(dropDownText)){
                element.click();
                break;
            }
        }

    }

    //Reusable method for mouse hover on any element
    public static void mouseHover(By by){
        Actions action =new Actions(driver);
        WebElement mouse = driver.findElement(by);
        action.moveToElement(mouse).build().perform();
    }

    //Reusable method for AssertEqual
    public static void assertEqual(By by,String expected){
        Assert.assertEquals(driver.findElement(by).getText(),expected,"Actual Text is Not Matching With Expected Text");
    }

    //assertion by getting text from web location
    public static void assertByGetText(By by, String expectedText, String errorMessage) {
        Assert.assertEquals(getTextFromElement(by),expectedText,errorMessage);
    }

    //assertion by getting attribute value from web location
    public static void assertByGetTextByAttribute(By by, String attributeValue, String expectedText,  String errorMessage) {
        Assert.assertEquals(getTextByAttribute(by, attributeValue),expectedText,errorMessage);
    }

    //assertion by string variables
    public static void assertByStringVariable( String actualText, String expectedText, String errorMessage) {
        Assert.assertEquals(actualText, expectedText, errorMessage);
    }

    public static void getPrice(By by , By productNameby){
        String price = getTextFromElement(by);
        StringBuilder sb1 = new StringBuilder(price);
        sb1.deleteCharAt(0);
        String resultString = sb1.toString();
        double converted_price = Double.parseDouble(resultString);
        String productName = getTextFromElement(productNameby);
        System.out.println("The Price for " + productName + " = " + converted_price);

    }

}
