package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    public static void pause(long seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForVisibilityOfElement(WebDriver driver, WebElement element, int seconds){
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilTitleIs(WebDriver driver,int seconds, String title){
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.titleIs(title));
    }

    public static void waitUntilTextToBePresentInElement(WebDriver driver, int seconds, WebElement element, String text){
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}
