package com.amazon.testsuite;

import com.amazon.pages.AddToCartPage;
import com.amazon.pages.FindYourProductPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.SelectProductPage;
import com.amazon.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LaptopTest extends TestBase {

    HomePage homePage;
    FindYourProductPage findYourProductPage;
    SelectProductPage selectedProductPage;
    AddToCartPage addToCartPage;


    @BeforeMethod
    public void init() {
        homePage = new HomePage();
        findYourProductPage = new FindYourProductPage();
        selectedProductPage = new SelectProductPage();
        addToCartPage = new AddToCartPage();
    }


    @Test
    @Parameters({"search1", "description1", "quantity1", "message1" })
    public void userShouldBeAbleToPurchaseLaptopSuccessfully(String lSearch, String lDescription, String lQuantity, String lMessage) throws InterruptedException {
        // In Search bar - Search for "Laptop"
        homePage.enterDataInTheSearchBox(lSearch);
        // Click on the search button
        homePage.clickOnTheSearchButton();
        //Find the product matching the description
        findYourProductPage.findSelection(lDescription);
        //Qty dropdown select qty 3
        selectedProductPage.selectQuantity(lQuantity);
        //click on Add to cart
        selectedProductPage.addItemToCart();
        //Verify word "Added to Cart"
        addToCartPage.verifyTheAddToCartMessage(lMessage);
    }

}
