package starter.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.navigation.GoProHomePage;

public class MainPageStepDefinitions {

    @Steps
    GoProHomePage goProHomePage;

    @Given("^an anonymus buyer opens gopro main page$")
    public void anAnonymusBuyerOpensGoproMainPage() {
        goProHomePage.open();
        goProHomePage.navigateToCameras();
    }

    @And("^he navigates to cameras$")
    public void heNavigatesToCameras() {
     goProHomePage.navigateToCameras();
    }
}
