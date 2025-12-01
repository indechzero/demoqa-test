package FinalActivity.tests.StepDefinitions.Elements;

import TestComponents.BaseTest;
import FinalActivity.tests.PageActions.RadioButtonComponents;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;

import java.io.IOException;

public class RadioButton extends BaseTest {
    RadioButtonComponents radiobtnComponent = new RadioButtonComponents();

    @Test
    @Given("that I am in the DEMO homepage for Radio Button activity")
    public void goToHomePage() throws InterruptedException, IOException {

        radiobtnComponent.goToHomePage();
    }
    @When("I navigated to the Radio activity page")
    public void goToRadioButtonPage() throws InterruptedException, IOException {
            radiobtnComponent.goToRadioButtonPage();
    }
    @Then("I was able to verify unselected Radio Button")
    public void radioButtonUnselected() throws InterruptedException, IOException {
        radiobtnComponent.radioButtonUnselected();
    }
    @Then("I was able to select Yes Radio Button")
    public void selectYesRadioBtn() throws InterruptedException, IOException {
        radiobtnComponent.selectYesRadioBtn();
    }
    @And("I was able to select Impressive Radio Button")
    public void selectImpressive() throws InterruptedException, IOException {
        radiobtnComponent.selectImpressive();
    }
    @Then("I was not able to select No Radio Button")
    public void verifyNoBtn() throws InterruptedException, IOException {

        radiobtnComponent.verifyNoBtn();

    }


}
