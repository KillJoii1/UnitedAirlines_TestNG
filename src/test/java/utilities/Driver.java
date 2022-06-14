package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    private Driver() {

    }

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            switch (ConfigReader.getPropertyString("browser")) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "safari" -> {
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                }
                default ->
                    throw new NotFoundException("Browser IS NOT DEFINED properly!!!");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getPropertyLong("implicitWait")));
        }
        return driver;
    }

    public static void quitDriver() {
        try{
            Thread.sleep(3000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
    }
}










