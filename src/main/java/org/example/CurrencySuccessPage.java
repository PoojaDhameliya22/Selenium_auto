package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CurrencySuccessPage extends Utils{
    public void userCurrencySuccessPage()
    {
        //dollar
        String expectedMessage  = "$1,200.00";
        String actualMessage = driver.findElement(By.xpath("//span[contains(text(),'$1,200.00')]")).getText();
        System.out.println("Actual message:" +actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage,"price doesnt match");


    }
    public void userCurrencyEuroSuccess()
    {
        //euro
        String expectedMessage1 = "€1032.00";
        String actualMessage1 = driver.findElement(By.xpath("//span[contains(text(),'€1032.00')]")).getText();
        System.out.println("Actual Message:"+actualMessage1);
        Assert.assertEquals(actualMessage1,expectedMessage1,"Price does not match");

    }
}
