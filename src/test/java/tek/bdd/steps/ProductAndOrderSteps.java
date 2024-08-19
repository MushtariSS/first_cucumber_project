package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.ShoppingCart;
import tek.bdd.utility.SeleniumUtility;

import java.util.List;

public class ProductAndOrderSteps extends SeleniumUtility {
    @When("user enter {string} on search bar and click search")
    public void user_enter_on_search_bar_and_click_search(String searchText) {
        sendText(HomePage.SEARCH_BAR_INPUT, searchText);
        clickElement(HomePage.SEARCH_BTN);
    }

    @Then("validate search result containes {string} for all product")
    public void validate_search_result_contains_for_all_product(String expectedSearchKeyword) {
        List<WebElement> elements = getElements(HomePage.ALL_SEARCH_RESULTS_TITLE);
        //Assert.assertFalse("search result should not be empty",elements.isEmpty());
        for (WebElement element : elements) {
            Assert.assertTrue(element.getText().contains(expectedSearchKeyword));
        }
    }

    @When("user click on first item in search result")
    public void user_click_on_first_item_in_search_result() {
        clickElement(HomePage.FIRST_SEARCHED_PRODUCT_TITLE);
    }

    @Then("verify {int} item in the cart list")
    public void verify_item_in_the_cart_list(int expectedCartSize) {
        List<WebElement> cartItems = getElements(ShoppingCart.CART_ITEM_LIST);
        Assert.assertEquals(cartItems.size(), expectedCartSize);
    }

    @When("user delete all items in cart")
    public void user_delete_all_items_in_cart() {
       getElements(ShoppingCart.ALL_ITEMS_DELETE)
               .forEach(each -> {
                   clickOnElement(each);
               });


    }
    @Then("validate shopping cart is empty")
    public void validate_shopping_cart_is_empty() {
        boolean isDisplayed = isElementDisplayed(ShoppingCart.CART_EMPTY_TITLE);
        Assert.assertTrue("Cart Empty title should display", isDisplayed);

    }
}
