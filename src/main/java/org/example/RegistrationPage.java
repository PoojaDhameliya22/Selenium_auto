package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Utils{
    private By _genderFemale = By.xpath("//input[@id=\"gender-female\"]");
    private By _firstName = By.xpath("//input[@name='FirstName']");
    private By _lastName = By.id("LastName");
    private By _userClickHomeImage = By.xpath("//img[@alt=\"nopCommerce demo store\"]");
    public void userEnterRegistration()
    {
        //select gender
        clickOnElement(_genderFemale);

        // enter firstname
        //driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Autoamtion");
        typeText((_firstName),"Pooja");

        //enter lastname
        //driver.findElement(By.id("LastName")).sendKeys("LastNameTest");
        typeText((_lastName),"Dhameliya");

        //select birthdate
        Select birthday = new Select(driver.findElement(By.name("DateOfBirthDay")));
        birthday.selectByIndex(10);

        //birthMonth
        Select birthMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        birthMonth.selectByValue("4");

        //birthYear
        Select birthYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        birthYear.selectByVisibleText("1960");

        //enter email
        driver.findElement(By.xpath("//input[@name=\"Email\"]")).sendKeys("pooja21"+randomDate()+"@gmail.com");

        //enter password
        //driver.findElement(By.id("Password")).sendKeys("12345@abc.com");
        typeText(By.id("Password"),"12345@abc");

        //enter confirm password
        //driver.findElement(By.id("ConfirmPassword")).sendKeys("12345@abc.com");
        typeText(By.id("ConfirmPassword"),"12345@abc");

        //enter register button
        //  driver.findElement(By.name("register-button")).click();
        clickOnElement(By.name("register-button"));

    }

    public void userClickHomePage()
    {
        clickOnElement(_userClickHomeImage);

    }


}
