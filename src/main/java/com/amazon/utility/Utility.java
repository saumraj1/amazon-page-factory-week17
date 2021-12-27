package com.amazon.utility;

import com.amazon.drivermanager.ManageDriver;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Jay Vaghani
 */
public class Utility extends ManageDriver {
    //*****************BASIC WEBDRIVER METHODS******************************


    /**
     * This method will click on element
     *
     * @ param by
     */
    public void cickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    public String getTextFromElement(WebElement element) {

        return element.getText();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void sendTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * This method will find the element and clear all the data from it
     *
     * @param by
     */
    public void findElementAndClearText(By by) {
        WebElement elementToClear = driver.findElement(by);
        elementToClear.clear();
    }

    public void findElementAndClearText(WebElement element) {
        element.clear();
    }

    /**
     * This method will extract the value of a particular attribute from an element
     *
     * @param by
     * @param attribute
     * @return
     */
    public String getAttributeFromElement(By by, String attribute) {
        return driver.findElement(by).getAttribute(attribute);
    }


//*************************** Alert Methods ***************************************//

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * This method will accept alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method will dismiss alert
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will get text from alert
     */
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }


    /**
     * This method will send text to alert
     */
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }


//*************************** Select Class Methods ***************************************//

    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByVisibleTextFromDropDown(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select the option by value
     */
    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    public void selectByValueFromDropDown(WebElement webElement, String value) {
        new Select(webElement).selectByValue(value);
    }

    /**
     * This method will select the option by index
     */
    public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
    }

    /**
     * This method will select the option by contains text
     */
    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

    public void selectByContainsTextFromDropDown(WebElement element, String text) {
        List<WebElement> allOptions = new Select(element).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

    /**
     * THIS METHOD SELECTS A PARTICULAR MENU FROM THE MENU BAR
     *
     * @param by
     * @param menu
     * @throws InterruptedException
     */

    public void selectMenu(By by, String menu) throws InterruptedException {

        List<WebElement> names = driver.findElements(by);
        for (WebElement name : names) {
            //Thread.sleep(2000);
            if (name.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(2000);
                name.click();
                break;
            }
        }
    }

    public void selectMenu(List<WebElement> element, String menu) throws InterruptedException {

        List<WebElement> names = element;
        for (WebElement name : names) {
            Thread.sleep(2000);
            if (name.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(2000);
                name.click();
                break;
            }
        }
    }


//*************************** Window Handle Methods ***************************************//

    /**
     * This method will close all windows
     */
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This method will switch to parent window
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This method will find that we switch to right window
     */
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }

    public void switchToIframe(WebElement element) {
        driver.switchTo().frame(element);

    }
//*************************** Action Methods ***************************************//

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverNoClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverNoClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }


    /**
     * This method will hover the mouse over a particular element and click it
     *
     * @param by
     */
    public void mouseHoverAndClick(By by) {
        Actions hover = new Actions(driver);
        WebElement a = driver.findElement(by);
        hover.moveToElement(a).click().build().perform();
    }

    public void mouseHoverAndClick(WebElement element) {
        Actions hover = new Actions(driver);
        hover.moveToElement(element).click().build().perform();
    }

    /**
     * This Method will hover mouse on one element, then on second element
     * and click the second element
     */
    public void mouseHoverOnFirstThenSecondAndClick(By by1, By by2) {
        Actions hover = new Actions(driver);
        WebElement destination1 = driver.findElement(by1);
        WebElement destination2 = driver.findElement(by2);
        hover.moveToElement(destination1).moveToElement(destination2).click().build().perform();
    }

    /**
     * This method performs a Right Click Mouse Action at the current mouse location
     *
     * @param by
     */
    public void rightClick(By by) {
        Actions rightClick = new Actions(driver);
        WebElement a = driver.findElement(by);
        rightClick.contextClick().build().perform();
    }

    /**
     * This method performs click and hold at the source location, moves to target location
     * and then releases the mouse
     *
     * @param source
     * @param target
     */
    public void dragAndDrop(By source, By target) {
        Actions builder = new Actions(driver);
        WebElement draggable = driver.findElement(source);
        WebElement droppable = draggable.findElement(target);
        builder.dragAndDrop(draggable, droppable).build().perform();
    }

    /**
     * Moves the slider from its current position to the desired position
     *
     * @param sliderBar
     * @param sliderBox
     * @param xAxis
     * @param yAxis
     */
    public void sliderMovement(By sliderBar, By sliderBox, int xAxis, int yAxis) {
        Actions moveSlider = new Actions(driver);
        WebElement mainSlider = driver.findElement(sliderBar);
        WebElement slider = driver.findElement(sliderBox);
        moveSlider.dragAndDropBy(slider, xAxis, yAxis).build().perform();
    }

//************************** Waits Methods *********************************************//

    /**
     * This method will use to wait until  VisibilityOfElementLocated
     */
    public WebElement waitUntilVisibilityOfElementLocated(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    public WebElement waitUntilStalenessOfElementLocated(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.stalenessOf(element));
        return element;
    }


    public String waitUntilTitleIsEqualTo(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.titleContains(expectedMessage));
        return expectedMessage;
    }

    /**
     * This method will wait for an element using Fluent Wait
     *
     * @param by
     * @param time
     * @param pollingTime
     * @return
     */
    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    //************************** ScreenShot Methods *********************************************//
    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/"; // path where screen shot needs to be saved
        TakesScreenshot screenshot = (TakesScreenshot) driver; // method to take screenshot
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/main/java/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /**
     * ******************VERIFICATION METHODS---ASSERT CLASS**********************
     */

    /**
     * This method verifies elements using Assert class after reading text from element
     *
     * @param expectedMessage
     * @param actualMessage
     * @param displayMessage
     */

    public void verifyElementsJU(String displayMessage, String expectedMessage, String actualMessage) {
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }

    /******
     * This method verifies elements using locator directly as the second
     * instead of String
     * @param expectedMessage
     * @param by
     * @param displayMessage
     */

    public void verifyElements(String expectedMessage, String by, String displayMessage) {
        Assert.assertEquals(expectedMessage, by, displayMessage);
    }

    public void verifyElements(String displayMessage, String expectedMessage, WebElement element) {
        String actualMessage = getTextFromElement(element);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }

    /**
     * This method is getting text from actual Message's WebElement using
     * the Explicit Wait Method. We will then use this as String actualMessage in Verification Method
     * We have used "waitUntilVisibilityOfElementLocated" Explicit Wait Method here
     *
     * @param actualMessage
     * @param timeout
     * @return
     */

    public String getTextFromActualMessageForVerificationUsingWait(By actualMessage, int timeout) {
        String verify = waitUntilVisibilityOfElementLocated(actualMessage, timeout).getText();
        return verify;
    }

    /**
     * THIS IS THE VERIFICATION METHOD USING WAIT
     * THIS METHOD WILL WORK IN THE FOLLOWING WAY:
     * 1. Get Expected - can also use the "waitUntilTitleIsEqualTo" explicit wait method.
     * 2. Get Acutal = By getting text from actual element using "waitUntilVisibilityOfElement" method
     * 3. All this incorporated in the Assert Method
     * <p>
     * <p>
     * //    public void verificationMethodUsingWait(String expectedMessage, By theActualMessage, int timeForWait) {
     * //        String expected = expectedMessage;
     * //        String actual = getTextFromActualMessageForVerificationUsingWait(theActualMessage, timeForWait);
     * //        verifyElements(expected, actual, "Message is displayed incorrectly");
     * //    }
     **/

    public String randomString() {
        String randString;
        RandomString rnd = new RandomString(10);
        return randString = rnd.nextString();
    }


}
