package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class baseSetup {
    //Encapsulating driver instance
    private static WebDriver driver;
    public void setupBrowser(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void quitBrowser() {
        //nul check before
        if (driver != null) {
            driver.quit();
        }
    }
    //Given read-only indirect access to driver
    public WebDriver getDriver(){
        return driver;
    }
}