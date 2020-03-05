package starter.navigation;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CartPage extends BasePage {

    @FindBy(xpath = "//i[@aria-label='View your shopping cart']")
    WebElement cartIcon;

    @FindBy(xpath = "//tr")
    WebElement firstTablerow;

    @FindBy(xpath = "//td[@class='item-quantity tablet-landscape-cart-qty']/div/input[@class='button-minus']")
    WebElement minusCameraButton;

    String cameraMinusLinkLocator = "//td[@class='item-quantity tablet-landscape-cart-qty']/div/input[@class='button-minus']";

    public void clickOnCart() {
        cartIcon.click();
    }

    public void getCamerasQuantity(Integer quantity) {
        WebElement camerasQuantity = getDriver().findElement(
                By.xpath("(//td[@class='item-quantity tablet-landscape-cart-qty']/div/input[@type='number'])[1]"));
        Assert.assertTrue("Actual quantity " + camerasQuantity.getAttribute("value"),
                camerasQuantity.getAttribute("value").equals(quantity.toString()));
    }

    public void removeCameraQuantity(int cameraQuantity) {
        for (int i = 0; i <= cameraQuantity; i++) {
            waitForPageReadyAndInactiveQueryState();
            minusCameraButton.click();
            waitForPageReadyAndInactiveQueryState();
            waitUntilElementIsClickable(cameraMinusLinkLocator);

        }

    }


}
