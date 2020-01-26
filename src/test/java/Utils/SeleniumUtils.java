package Utils;

import Setup.TestRule;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class SeleniumUtils {

    public static boolean aguardaElementoClicavel(WebElement elemento, int segundos){
        WebElement webElement;
        try {
            Wait<WebDriver> wait = new FluentWait<>(TestRule.getDriver()).withTimeout(Duration.ofSeconds(segundos))
                    .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class).ignoring(TimeoutException.class);

            try {
                webElement = wait.until(ExpectedConditions.elementToBeClickable(elemento));

            } catch (Exception e) {
                return false;
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
        return webElement.isDisplayed() ;

    }
}
