package starter.navigation;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://gopro.com/en/ro/shop/cameras")
public class CamerasPage extends BasePage {

    @FindBy(xpath = "//div[@id='H8-CLP-Module1']//button[@title='Add to Cart']")
    WebElement h8AddToCartButton;

    @FindBy(xpath = "//div[@id='minicart-popup-close']", timeoutInSeconds = "5")
    WebElement closeCartPopUp;

    @FindBy(xpath = "//div[@class='gpn-shopping-cart-display-container']")
    WebElement cartIcon;

    String popUpCloseLocator = "//div[@id='minicart-popup-close']";


    public void addH8BundleToCart() {
        h8AddToCartButton.click();
    }

    public void closeCartPopUp() {

        this.waitUntilElementAvailable(popUpCloseLocator);
        closeCartPopUp.click();

    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }
}
