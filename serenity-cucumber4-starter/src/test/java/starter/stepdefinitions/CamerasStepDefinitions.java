package starter.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.navigation.CamerasPage;

public class CamerasStepDefinitions {

    @Steps
    CamerasPage camerasPage;

    @And("^he adds (\\d+) hero8 black bundle$")
    public void heAddsHeroBlackBundle(int numerOfItems) {

            for (int i = 0; i< numerOfItems; i++){
                camerasPage .addH8BundleToCart();
                    camerasPage.closeCartPopUp();
            }
    }

    @When("^he navigates to cart$")
    public void heNavigatesToCart() {
        camerasPage.clickOnCartIcon();
    }
}
