package org.example;

import org.openqa.selenium.By;

public class AddToCart extends Utils{
    private By _addToCart = By.xpath("//div/div[1]/div/div[2]/div[3]/div[2]/button[@class=\"button-2 product-box-add-to-cart-button\"]");
    public void userAddtoCart()
    {
        //click on add to cart
        clickOnElement(_addToCart);

    }
}
