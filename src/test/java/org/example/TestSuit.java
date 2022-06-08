package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.*;

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
        communityPollSuccessPage.registerUserAbleVoteSuccess();
    }
    @Test
    public void productTitles()
    {
        homePage.getProductTitles();
    }
    @Test
    public void verifyUserIsAbleToNavigateToFacebookPage()
    {
        //on home page click on facebook button

        //verify that user is on facebook page(Assert)

        //close the windown and come back to main home page(Assert)

        String MainWindow = driver.getWindowHandle();
        //click on facebook button//
        clickOnElement(By.className("facebook"));
        //To handle all new opened window.
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1=s1.iterator();

        while (i1.hasNext()){
            String ChildWindow = i1.next();
            if(!MainWindow.equalsIgnoreCase(ChildWindow)){
                //Switching to child window
                driver.switchTo().window(ChildWindow);
                // verify user is on correct Facebook page
                String expectedFacebookUrl = "https://www.facebook.com/nopCommerce";
                String actualFacebookUrl = driver.getCurrentUrl();
                Assert.assertEquals(actualFacebookUrl,expectedFacebookUrl);
                driver.close();;
            }
            //Switching to Parent window
            driver.switchTo().window(MainWindow);
            // verify user is on correct homepage
            String expectedHomeUrl = "https://demo.nopcommerce.com/";
            String actualHomeUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualHomeUrl,expectedHomeUrl);
        }

    }
    @Test
    public void verifyUserIsNotAbleToVoteWithoutSelectingAnOption() throws InterruptedException {
        //click on the vote button on the homepage
        clickOnElement(By.xpath("//button[@id=\"vote-poll-1\"]"));

        //verify the message in alert "Please select an answer" (Assert)
        Alert alert = driver.switchTo().alert();

        //Assert
        String expectedMessage = "Please select an answer";
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        Assert.assertEquals(alertMessage,expectedMessage,"Alert is not match");
        Thread.sleep(3000);

        //click on OK button to close the Alert
        alert.accept();
    }
    @Test
    public void verifyThatUserIsAbleToSearchGivenProductSuccessfully()
    {
        //on homepage click on search bar and enter nike or apple(Parameterised method)

        //verify that user is on the Nike or Apple Page(Assert point)

        //verify that all the product listed contains either nike or apple(Same as url)(Assert point)


    }
    @Test
    public void verifyThatUserCommentSuccessfullyAddedToCommentList()
    {
        //on homepage click under news nd nop commerce new release. click on details button
        clickOnElement(By.xpath("//div/div[2]/div[2]/div[3]/a[@href=\"/nopcommerce-new-release\"]"));

        //verify that user is on nopcommerce new release page(Assert point - verify URL)
        String expectedURL = "https://demo.nopcommerce.com/nopcommerce-new-release";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL,"URL is not match");

        //verify the title of the page "NopCommerce new release" (Assert point - verify title)
        String expectedTitle = "nopCommerce new release!";
        String actualTitle = driver.findElement(By.className("page-title")).getText();
        Assert.assertEquals(actualTitle,expectedTitle,"Title is does not match");

        //enter title
        //clickOnElement(By.className("center-comment-title"));
        //driver.findElement(_friendEmail).sendKeys("abc@gmail.com");

        driver.findElement(By.xpath("//input[@id=\"AddNewComment_CommentTitle\"]")).sendKeys("Hiii");

        //enter comment
        //clickOnElement(By.className("class=\"enter-comment-text\""));
        driver.findElement(By.xpath("//textarea[@class=\"enter-comment-text\"]")).sendKeys("Helllo");

        //click on new comment button
        clickOnElement(By.xpath("//button[@name=\"add-comment\"]"));


        //verify comment added message "News comment is successfully added."(Assert point - verify message)
        String expectedMessage = "News comment is successfully added.";
        String actualMessage  = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);

        //verify that user comment has been added to the contains list(Assert point - comment has been added to the list)

        //verify that user comment has been displayed last on the list(Assert point - comment is listed last on the list)

//        String title = "NopCommerceNewReleaseTitleField";
//        List<WebElement> comments = driver.findElements(By.xpath("//div[@class='comment-title']"));
//        List<String> listOfComments = new ArrayList<>();
//        for (WebElement we:comments){
//            listOfComments.add(we.getText());
//        }
//        Assert.assertTrue(listOfComments.contains(title));
//        String lastComment = listOfComments.get(listOfComments.size()-1);
//        System.out.println(lastComment);
//        Assert.assertEquals(lastComment, title, "Comments are not listed in correct order");
        String title = "Like Product List";
        List<WebElement> comments = driver.findElements(By.xpath("//div[@class='comment-title']"));
        List<String> listOfComments = new ArrayList<>();
        for (WebElement we:comments){
            listOfComments.add(we.getText());
        }
        Assert.assertTrue(listOfComments.contains(title));
        String lastComment = listOfComments.get(listOfComments.size()-1);
        System.out.println(lastComment);
        Assert.assertEquals(lastComment, title, "Comments are not listed in order");

    }
    //@Test
//    public void verifyProductListIsInZtoAFormat()
//    {
//        //this test case should fail
//
//        //click on computer on homepage
//        homePage.clickOnComputer();
//
//        //click on desktop
//        homePage.clickOnDesktop();
//
//        //sort by functionality, select name Z to A option
//        clickOnElement(By.xpath("//select[@id=\"products-orderby\"]/option[3]"));
//
//        //verify that all the product listed in Z-A format(Assert point)
//        List<String> list1=new ArrayList<String>();
//        list1.add("Build your own computer");
//        list1.add("Digital Storm VANQUISH 3 Custom Performance PC");
//        list1.add("Lenovo IdeaCentre 600 All-in-One PC");
//        System.out.println(list1);
//
//        //making duplicate list
//        List<String> sortedList = new ArrayList<String>(list1);
//
//        //sorting the list
//        Collections.reverse(sortedList);
//
//        System.out.println(sortedList);
//    }
    @Test
    public void verifyThatProductListIsInZtoAFormat()
    {
        //this test case should fail

        //click on computer on homepage
        homePage.clickOnComputer();

        //click on desktop
        homePage.clickOnDesktop();

        //sort by functionality, select name Z to A option
        clickOnElement(By.xpath("//select[@id=\"products-orderby\"]/option[3]"));

        //Verify that all the products are listed in Z-A format (Assert Point)
        ArrayList<String> beforeList = new ArrayList<String>();
        List<WebElement> elementList = driver.findElements(By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2")); ////h2[@class='product-title']/a
        for (WebElement we:elementList){
            beforeList.add(we.getText().substring(0, 1));
        }
        Collections.sort(beforeList, Collections.reverseOrder());
        System.out.println(beforeList);

        List<String> afterList = new ArrayList<String>();
        for (WebElement we:elementList){
            afterList.add(we.getText().substring(0, 1));
        }
        System.out.println(afterList);
        //Assert.assertTrue(afterList.equals(beforeList));
        Assert.assertEquals(afterList, beforeList, "List is not list from Z to A");
    }
}


