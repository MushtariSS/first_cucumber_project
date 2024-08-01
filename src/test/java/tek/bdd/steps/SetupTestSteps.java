package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tek.bdd.utility.SeleniumUtility;

public class SetupTestSteps extends SeleniumUtility {
    @Then("validate top left corner is TEKSCHOOL")
    public void validateTopLeftLogo() {
        String topLeftCornerText = getElementText(By.className("top-nav__logo"));
        Assert.assertEquals("TEKSCHOOL",topLeftCornerText);
    }
    @Then("Validate Sign in button is Enabled")
    public void validateSigninBtnIsEnabled() {
        WebElement signinButton = driver.findElement(By.id("signinLink"));
        boolean isSigninBtnEnabled = signinButton.isEnabled();
        //boolean isSigninBtnEnabled = IsEnabled(By.id("signinLink"));
        Assert.assertTrue(isSigninBtnEnabled);
    }


}
