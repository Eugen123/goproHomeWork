package starter.stepdefinitions;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebElement;
import starter.navigation.CartPage;

public class CartStepDefinitions {


    @Steps
    CartPage cartPage;


    @Then("^he should see (\\d+) items in the cart$")
    public void heShouldSeeItemsInTheCart(int camerasQuantity) {
        cartPage.getCamerasQuantity(camerasQuantity);
    }

    @Then("^he removes (\\d+) camera from the cart$")
    public void heRemovesCameraFromTheCart(int quantityTobeRemoved) {
        cartPage.removeCameraQuantity(quantityTobeRemoved);
    }
}
