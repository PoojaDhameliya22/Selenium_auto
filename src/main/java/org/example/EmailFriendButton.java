package org.example;

import org.openqa.selenium.By;

public class EmailFriendButton extends Utils{
    private By _clickEmailFriendButton = By.xpath("//button[@class=\"button-2 email-a-friend-button\"]");
    public void UserShouldBeAbleToClickEmailFriendButton()
    {
        clickOnElement(_clickEmailFriendButton);
    }
}
