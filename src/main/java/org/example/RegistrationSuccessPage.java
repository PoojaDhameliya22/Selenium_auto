package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import javax.rmi.CORBA.Util;

public class RegistrationSuccessPage extends Utils {
    public void UserShouldBeAbleToRegisterSuccessfully()
    {
        String expectedMessage = "Your registration completed";
        String actualMessage =  driver.findElement(By.xpath("//div[contains(text(),\"Your registration completed\")]")).getText();
        System.out.println("Actual message:" + actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage,"Registration is not working");

    }
}