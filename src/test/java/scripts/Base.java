package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.FlightDeparturePage;
import pages.UnitedHomePage;
import utilities.Driver;

public class Base {
    WebDriver driver;
    SoftAssert softAssert;
    UnitedHomePage unitedHomePage;
    FlightDeparturePage flightDeparturePage;
    Actions actions;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
        unitedHomePage = new UnitedHomePage(driver);
        flightDeparturePage = new FlightDeparturePage(driver);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void teardown() {
        softAssert.assertAll();
        Driver.quitDriver();
    }
}
