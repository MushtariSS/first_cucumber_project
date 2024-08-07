package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.AccountPage;
import tek.bdd.pages.SignupPage;
import tek.bdd.utility.RandomGenerator;
import tek.bdd.utility.SeleniumUtility;

import java.util.List;
import java.util.Map;

public class CreateNewAccountSteps extends SeleniumUtility {
        private static String emailToUse;
        @When("user enter {string} and {string}  and {string}")
        public void userEnterNewAccountInfo(String name, String email, String password) {

            emailToUse = email.equalsIgnoreCase("random")
                    ? RandomGenerator.generateRandomEmail() : email;

            sendText(SignupPage.NAME_INPUT, name);
            sendText(SignupPage.EMAIL_INPUT, emailToUse);
            sendText(SignupPage.PASSWORD_INPUT, password);
            sendText(SignupPage.CONFIRM_PASSWORD, password);

        }
        @Then("validate user is in account page")
        public void validateUserInAccountPage() {
            String actualText  = getElementText(AccountPage.PROFILE_PAGE_TITLE);
            Assert.assertEquals("Account page should contains Your Profile Text"
                    ,"Your Profile", actualText);
        }
        @Then("validate email address in account page match")
        public void validateEmailAddressInAccountPageMatch() {
            String actualEmail = getElementText(AccountPage.PROFILE_EMAIL_TEXT);

            Assert.assertEquals("Email in Account page should match with email used in create account step",
                    emailToUse, actualEmail);
        }
    @When("user enter new account info using Map")
        public void userInterNewAccountInfo(DataTable dataTable){
            //converting data to map
        Map<String,String> data =  dataTable.asMap();
        String email = data.get("email");
        String name = data.get("name");
        String password = data.get("password");
        emailToUse  = email.equalsIgnoreCase("random")?RandomGenerator.generateRandomEmail():email;
        sendText(SignupPage.NAME_INPUT, name);
        sendText(SignupPage.EMAIL_INPUT, emailToUse);
        sendText(SignupPage.PASSWORD_INPUT, password);
        sendText(SignupPage.CONFIRM_PASSWORD, password);
    }
    @When("user enter new account info using List")
    public void userInterNewAccountInfoUsingMap(DataTable dataTable){
            //convert data table to list
        List<String> data =dataTable.asList();
        String name=data.get(0);
        String email=data.get(1);
        String password=data.get(2);
        emailToUse  = email.equalsIgnoreCase("random")?RandomGenerator.generateRandomEmail():email;
        sendText(SignupPage.EMAIL_INPUT, emailToUse);
        sendText(SignupPage.PASSWORD_INPUT, password);
        sendText(SignupPage.CONFIRM_PASSWORD, password);
        sendText(SignupPage.NAME_INPUT, name);
    }
    @When("user enter new account as list of list")
    public void userEnterMewAccountAslistOfList(DataTable dataTable){
            //Convert table into a list of list
        List<List<String>> data = dataTable.asLists();
        String name = data.get(0).get(0);
        String email = data.get(1).get(1);
        String password = data.get(2).get(2);
        emailToUse  = email.equalsIgnoreCase("random")?RandomGenerator.generateRandomEmail():email;
        sendText(SignupPage.EMAIL_INPUT, emailToUse);
        sendText(SignupPage.PASSWORD_INPUT, password);
        sendText(SignupPage.CONFIRM_PASSWORD, password);
        sendText(SignupPage.NAME_INPUT, name);

    }
}
