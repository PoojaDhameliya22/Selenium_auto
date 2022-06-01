package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage extends Utils {

    private By _registerButton = By.className("ico-register");
    private By _clickComputer = By.linkText("Computers");
    private By _clickDesktop = By.linkText("Desktops");
    private By _clickCurrencyDollar = By.xpath("//select[@id=\"customerCurrency\"]");
    private By _clickPriceDollar = By.xpath("//span[contains(text(),'$1,200.00')]");
    private By _clickCurrencyEuro = By.xpath("//select[@id=\"customerCurrency\"]");
    private By _clickPriceEuro = By.xpath("//span[contains(text(),'€1032.00')]");
   private By _clickGood = By.xpath("//input[@id=\"pollanswers-2\"]");
    private By _clickVote = By.xpath("//button[@id=\"vote-poll-1\"]");


    public void clickOnRegisterButton() {

        // click on register button
        clickOnElement(_registerButton);
    }

    public void clickOnComputer() {
        //click on computer
        clickOnElement(_clickComputer);

    }

    public void clickOnDesktop() {
        //click on Desktop
        clickOnElement(_clickDesktop);
    }

    public void clickCurrencyDollar() {
        //click on currency
        clickOnElement(_clickCurrencyDollar);

        //select USDollar
        Select USDollar = new Select(driver.findElement(By.xpath("//select[@name=\"customerCurrency\"]")));
        USDollar.selectByIndex(0);

        //click on price in dollar
        clickOnElement(_clickPriceDollar);
    }

    public void clickCurrencyEuro() {

        //click on currency
        clickOnElement(_clickCurrencyEuro);

        //select euro
        Select euro = new Select(driver.findElement(By.xpath("//select[@name=\"customerCurrency\"]")));
        euro.selectByIndex(1);

        //click on price in euro
        clickOnElement(_clickCurrencyEuro);

    }

    public void clickcommunitypoll() {
        //click on good
        clickOnElement(_clickGood);
        //click on vote
        clickOnElement(_clickVote);
    }
}
