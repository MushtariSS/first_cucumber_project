package tek.bdd.utility;

import org.openqa.selenium.By;
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
        waitForVisibility(locator).sendKeys();
    }
    //create method to get the text of an element
    public String getElementText(By locator){
        return waitForVisibility(locator).getText();
    }

}
