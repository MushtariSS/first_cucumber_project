package tek.bdd.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.HomePage;
import tek.bdd.utility.SeleniumUtility;

public class SecurityTestSteps extends SeleniumUtility {
@When("user click on sign in link")
    public void UserClickOnSigninLink(){
    clickElement(By.id("signinLink"));
}
@Then("input the validate username and password")
    public void ValidateUserInSigninPage(){
    sendText(By.id("email"),"angle@gmail.com");
    sendText(By.id("password"),"Romin2021!");
}
@And("click on  login button")
    public void ClickOnLoginbtn(){
    clickElement(By.id("loginBtn"));
}
@Then("user should be able to see account link")
    public void userShouldBeAbleToSeeAccountLink(){
    WebElement signinButton = driver.findElement(By.id("signinLink"));
    boolean isSigninBtnEnabled = signinButton.isEnabled();
}
}


