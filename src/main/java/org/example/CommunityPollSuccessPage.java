package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;


public class CommunityPollSuccessPage extends Utils{

    public void userAbleToVoteCommunityPoll()
    {
        String expectedMessage ="Only registered users can vote.";
        String actualMessage =driver.findElement(By.xpath("//div[contains(text(),'Only registered users can vote.')]")).getText();
        System.out.println("Actual Message:"+actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage,"Vote doesnt match");
    }
//    public void registerUserAbleVoteSuccess()
//    {
//        //assert 19 vote
//        String expectedMessage1 = "18 vote(s)...";
//        String actualMessage1 = driver.findElement(By.xpath("//span[@class=\"poll-total-votes\"]")).getText();
//        System.out.println("Actual Message1:"+actualMessage1);
//        Assert.assertEquals(actualMessage1,expectedMessage1,"Register vote doesnt match");
//    }
}
