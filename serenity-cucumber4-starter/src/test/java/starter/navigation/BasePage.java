package starter.navigation;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class BasePage extends PageObject {

    static final int WEBELEMENT_TIMEOUT = 60;
    static final int PAGE_TIMEOUT = 60;
    WebDriverWait wait;

    public synchronized void waitForPageReadyAndInactiveQueryState() {
        String expression = String.format("return (document.readyState=='complete' && jQuery.active == %d)", 0);

        try {

            waitForPagereadyJSE(expression);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for page to load");
        }
    }

    private void waitForPagereadyJSE(String expression) throws InterruptedException {
        synchronized (getDriver()) {
            sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            wait = new WebDriverWait(getDriver(), PAGE_TIMEOUT);
            wait.until(js1 -> js.executeScript(expression));
        }
    }

    public void waitUntilElementIsClickable(String locator) {
        try {
            synchronized (getDriver()) {
                WebDriverWait wait = new WebDriverWait(getDriver(), WEBELEMENT_TIMEOUT);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            }

        } catch (Throwable e) {
            Assert.fail("Timeout");

        }
    }

    public void waitUntilElementAvailable(String locator) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        } catch (Throwable e) {
            Assert.fail("Tomeout: element not visible");
        }
    }

}
