package org.example;

import org.openqa.selenium.By;

public class EmailFriendPage extends Utils{
    private By _friendEmail = By.xpath("//*[@id=\"FriendEmail\"]");
    private By _yourEmail = By.xpath("//*[@id=\"YourEmailAddress\"]");
    private By _personalMessage = By.xpath("//*[@id=\"PersonalMessage\"]");
    private By _emailButton = By.name("send-email");
    public void userEmailFriendPage()
    {
        //friend email
        //clickOnElement(By.xpath("//*[@id=\"FriendEmail\"]"));
        //enter your friend email
        driver.findElement(_friendEmail).sendKeys("abc@gmail.com");


        //your email
        driver.findElement(_yourEmail).sendKeys(" ");

        //personal message
        driver.findElement(_personalMessage).sendKeys("This computer is a very nice and good price.");

        //click on email button
        clickOnElement(_emailButton);
    }

}
