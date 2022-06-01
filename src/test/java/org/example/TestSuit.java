package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class TestSuit extends BaseTest{
    //Register
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();

    //Addtocart
    AddToCart addToCart = new AddToCart();
    BuildYourOwnComputer buildYourOwnComputer = new BuildYourOwnComputer();
    ShoppingCart shoppingCart  = new ShoppingCart();
    ShoppingCartSuccessPage shoppingCartSuccessPage = new ShoppingCartSuccessPage();
    //EmailFriend
    EmailFriendButton emailFriendButton = new EmailFriendButton();
    EmailFriendPage emailFriendPage = new EmailFriendPage();
    EmailFriendSuccessPage emailFriendSuccessPage = new EmailFriendSuccessPage();

    //Currency
    CurrencySuccessPage currencySuccessPage = new CurrencySuccessPage();

    //community poll
    CommunityPollSuccessPage communityPollSuccessPage = new CommunityPollSuccessPage();


    @Test
    public void userShouldBeAbleToRegisterSuccessfully(){
        homePage.clickOnRegisterButton();
        registrationPage.userEnterRegistration();
        registrationSuccessPage.UserShouldBeAbleToRegisterSuccessfully();
    }
    @Test
    public void userShouldBeAbleToAddProductInAddToCart()
    {
        homePage.clickOnComputer();
        homePage.clickOnDesktop();
        addToCart.userAddtoCart();
        buildYourOwnComputer.userEnterComputerDetails();
        shoppingCart.userAddShoppingCart();
        shoppingCartSuccessPage.userShouldBeAbleToSuccessAddToCartInShoppingCart();
    }
    @Test
    public void userShouldBeAbleToSendEmailAsaFriend()
    {
        homePage.clickOnRegisterButton();
        registrationPage.userEnterRegistration();
        homePage.clickOnComputer();
        homePage.clickOnDesktop();
        addToCart.userAddtoCart();
        emailFriendButton.UserShouldBeAbleToClickEmailFriendButton();
        emailFriendPage.userEmailFriendPage();
        emailFriendSuccessPage.UserAbleToEmailFriendSuccess();
    }
    @Test
    public void UserShouldBeAbleToChangeCurrency()
    {
        homePage.clickCurrencyDollar();
        currencySuccessPage.userCurrencySuccessPage();
        homePage.clickCurrencyEuro();
        currencySuccessPage.userCurrencyEuroSuccess();
    }
   // @Test
//    public static void takeSnapShot(String a) throws Exception{
//
//        //Convert web driver object to TakeScreenshot
//
//        TakesScreenshot scrShot =((TakesScreenshot)driver);
//
//        //Call getScreenshotAs method to create image file
//
//        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
//
//        //Move image file to new destination
//
//        //File DestFile=new File("Screenshots");
//
//        //Copy file at destination
//    try
//    {
//         FileUtils.copyFile(srcFile, new File("Screenshots\\"+a+".png"));
//    }
//    catch (Exception e)
//    {
//        e.printStackTrace();
//    }
//    }
    @Test
    public void userShouldBeAbleToSelectCommunityPoll()
    {
        homePage.clickcommunitypoll();
        communityPollSuccessPage.userAbleToVoteCommunityPoll();
        userShouldBeAbleToRegisterSuccessfully();
        registrationPage.userClickHomePage();
        homePage.clickcommunitypoll();
        //communityPollSuccessPage.registerUserAbleVoteSuccess();
    }
}
