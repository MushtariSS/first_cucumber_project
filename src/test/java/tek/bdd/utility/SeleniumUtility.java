package tek.bdd.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.baseSetup;


import java.time.Duration;

public class SeleniumUtility extends baseSetup {
    private WebDriverWait getWait(){
        return new WebDriverWait(getDriver(),Duration.ofSeconds(20));
    }
    private WebElement waitForVisibility(By locator){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //create method to click on given locator
    public void clickElement(By locator){
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void sendText(By locator,String value){
        waitForVisibility(locator).sendKeys(value);
    }
    //create method to get the text of an element
    public String getElementText(By locator){
        return waitForVisibility(locator).getText();
    }

    public boolean isElementEnabled(By locator) {
        return waitForVisibility(locator).isEnabled();
    }

    public boolean isElementDisplayed(By locator) {
        return waitForVisibility(locator).isDisplayed();
    }

    public byte[] takeScreenShot(){
        TakesScreenshot screenshot = (TakesScreenshot)getDriver();
        screenshot.getScreenshotAs(OutputType.BYTES);
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }
}





