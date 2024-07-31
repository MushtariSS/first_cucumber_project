package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SeleniumUtility extends BaseSetup {
    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    }
    public WebElement waitForVisibility(By locator){
        return getWait().until((ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    public void ClickOnLocator(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void sendText(By locator, String value) {
        waitForVisibility(locator).sendKeys(value);
    }
    public String getElementText(By locator){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}
