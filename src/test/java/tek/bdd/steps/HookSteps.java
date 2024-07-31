package tek.bdd.steps;

import io.cucumber.java.After;
import org.junit.Before;
import tek.bdd.utility.SeleniumUtility;

public class HookSteps extends SeleniumUtility {
    @Before
    public void beforeEachScenario() {
        setupBrowser();
    }

    @After
    public void afterEachScenario() {
        quitBrowser();
    }

}
