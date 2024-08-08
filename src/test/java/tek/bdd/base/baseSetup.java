package tek.bdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public abstract class baseSetup {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(baseSetup.class);
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
            LOGGER.info("Reading config file" + configFilePath);
            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (IOException ex) {
            LOGGER.error("Error reading config file");
            throw new RuntimeException("Something wrong with Config file", ex);
        }

    }
    public void setupBrowser() {
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless=Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.info(" Ruuning in browsers {} and isHeadless {} ", browserType,isHeadless);
        if (browserType.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if(isHeadless)
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase("edge")) {
            EdgeOptions options  = new EdgeOptions();
            driver = new EdgeDriver(options);
        }else if(browserType.equalsIgnoreCase("firefox")){
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless)
                options.addArguments("header");
            driver = new FirefoxDriver();
        }else{
            throw  new RuntimeException("Wrong browser type choose between chrome,firefox and edge");
        }
        LOGGER.debug("Using URL {} ");
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