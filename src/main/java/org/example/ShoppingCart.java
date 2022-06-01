package org.example;

import org.openqa.selenium.By;

public class ShoppingCart extends Utils{
    public void userAddShoppingCart()
    {
        //open shopping cart
        clickOnElement(By.xpath("//span[@class=\"cart-label\"]"));
    }

}
