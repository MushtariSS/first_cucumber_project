package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class baseSetup {
    //Encapsulating driver instance
    public static WebDriver driver;
    private Properties properties;
    //find the full path to file
    //FileInputStream to read the file
    //Properties and load the FileInputStream to the properties
    public baseSetup(){
        //System.getProperty("user.dir") return the locator of your project.
        try {
            String configFilePath = System.getProperty("user.dir") +
                    "/src/test/resources/configs/dev-config.properties";//can change it to qa-config.properties
                                                                        // to run it into different  environment
            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (IOException ex) {
            throw new RuntimeException("Something wrong with Config file", ex);
        }
    }
    public void setupBrowser(){
        driver = new ChromeDriver();
        String url = properties.getProperty("ui.url");
        driver.get(url);
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