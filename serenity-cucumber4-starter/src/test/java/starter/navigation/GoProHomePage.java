package starter.navigation;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("https://gopro.com")
public class GoProHomePage extends BasePage {

    @FindBy(xpath = "//li[@class='gpn-menu-list-item cameras']/a[@href='https://gopro.com/en/ro/shop/cameras']", timeoutInSeconds = "6")
    WebElement camerasLink;


    public void navigateToCameras() {
        waitForPageReadyAndInactiveQueryState();
        camerasLink.click();

    }
}
