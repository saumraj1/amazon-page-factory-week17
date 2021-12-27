package com.amazon.pages;

import com.amazon.customlisteners.CustomListeners;
import com.amazon.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SelectProductPage extends Utility {

    public SelectProductPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (id = "quantity")
    WebElement quantityBox;

    @CacheLookup
    @FindBy(id = "add-to-cart-button")
    WebElement addToCartButton;

    public void selectQuantity(String quantity){
        selectByValueFromDropDown(quantityBox, quantity);
        Reporter.log("Selecting quantity :" + quantity);

    }

    public void addItemToCart(){
        clickOnElement(addToCartButton);
        Reporter.log("Click on the add to cart button :" + addToCartButton + "<br>");

    }

}

