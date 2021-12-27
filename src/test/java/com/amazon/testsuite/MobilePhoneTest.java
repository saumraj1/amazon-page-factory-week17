package com.amazon.testsuite;

import com.amazon.pages.AddToCartPage;
import com.amazon.pages.FindYourProductPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.SelectProductPage;
import com.amazon.utility.Utility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MobilePhoneTest extends Utility {
    HomePage homePage;
    FindYourProductPage findYourProductPage;
    SelectProductPage selectProductPage;
    AddToCartPage addToCartPage;


    @BeforeMethod
    public void init1() {
        homePage = new HomePage();
        findYourProductPage = new FindYourProductPage();
        selectProductPage = new SelectProductPage();
        addToCartPage = new AddToCartPage();
    }

    @Test
    @Parameters({"search2", "description2", "quantity2", "message2" })
    public void userShouldBeAbleToPurchaseMobilePhoneSuccessfully(String mSearch, String mDescription, String mQuantity, String mMessage) throws InterruptedException {
        //In Search bar - Search for "Mobile Phone".
        homePage.enterDataInTheSearchBox(mSearch);
        // Click on the search button
        homePage.clickOnTheSearchButton();
        //Find the product matching the description
        findYourProductPage.findSelection(mDescription);
        //Qty dropdown select qty 3
        selectProductPage.selectQuantity(mQuantity);
        //click on Add to cart
        selectProductPage.addItemToCart();
        //Verify word "Added to Cart"
        addToCartPage.verifyTheAddToCartMessage(mMessage);
    }
}
