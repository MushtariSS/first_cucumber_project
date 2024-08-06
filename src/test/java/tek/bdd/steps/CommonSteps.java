package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tek.bdd.utility.SeleniumUtility;

public class CommonSteps extends SeleniumUtility {

    @Given("user click on {string} link")
    public void userClickOnLinks(String linkText) {
        clickElement(By.linkText(linkText));
    }


    @When("user click on {string} button")
    public void user_click_on_button(String buttonVisibleText) {

        String buttonXpath = "//button[text()='" + buttonVisibleText + "']";

        clickElement(By.xpath(buttonXpath));

    }


}
