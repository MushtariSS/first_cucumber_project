package tek.bdd.steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.SigninPage;
import tek.bdd.utility.SeleniumUtility;

public class SecurityTestSteps extends SeleniumUtility {
    @When("user click on sign in link")
    public void user_click_on_sign_in_link() {
        clickElement(HomePage.SING_IN_LINK);
    }

    @Then("validate user is in sign in page")
    public void validate_user_is_in_sign_in_page() {
        String pageSubTitle = getElementText(SigninPage.PAGE_SUBTITLE);
        Assert.assertEquals("Sign in", pageSubTitle);
    }

    @When("user enter username and password and click on login")
    public void user_enter_username_and_password_and_click_on_login() {
        sendText(SigninPage.EMAIL_INPUT, "angle.com");
        sendText(SigninPage.PASSWORD_INPUT, "Romin2021!");
        clickElement(SigninPage.LOGIN_BUTTON);
    }

    @When("user enter {string} and {string} and click on login")
    public void userEnterUsernameAndPassword(String username, String password) {
        sendText(SigninPage.EMAIL_INPUT, username);
        sendText(SigninPage.PASSWORD_INPUT, password);
        clickElement(SigninPage.LOGIN_BUTTON);
    }

    @Then("user should be able to see account link")
    public void user_should_be_able_to_see_account_link() {
        boolean isAccountDisplayed = isElementDisplayed(HomePage.ACCOUNT_LINK);
        Assert.assertTrue(isAccountDisplayed);
    }

    @Then("user should see error {string}")
    public void userShouldSeeError(String expectedErrorMessage) {
        String actualErrorMessage = getElementText(SigninPage.ERROR_MESSAGE);
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}



