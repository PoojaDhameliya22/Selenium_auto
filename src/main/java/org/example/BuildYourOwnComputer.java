package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BuildYourOwnComputer extends Utils{

    private By _selectProcessor = By.name("product_attribute_1");
    private By _selectRAM = By.name("product_attribute_2");
    private By _selectHDD = By.name("product_attribute_3");
    private By _selectOS = By.name("product_attribute_4");
    private By _selectSoftware = By.xpath("//input[@name=\"product_attribute_5\"]");
    private By _addToCart = By.xpath("//button[@id=\"add-to-cart-button-1\"]");

    public void userEnterComputerDetails()
    {
        //select processor
        Select processor = new Select(driver.findElement(_selectProcessor));
        processor.selectByIndex(1);

        //select RAM
        Select ram = new Select(driver.findElement(_selectRAM));
        ram.selectByIndex(1);

        //select HDD
        clickOnElement(_selectHDD);

        //select OS
        clickOnElement(_selectOS);

        //select software
        List<WebElement> elements = driver.findElements(_selectSoftware);
        System.out.println(Integer.toString(elements.size()));
        for (WebElement el:elements )
        {
            el.click();
        }

        //click add to cart button
        clickOnElement(_addToCart);

    }
}
