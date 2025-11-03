package FinalActivity.tests.stepDefinitions.WidgetsAct;

import FinalActivity.tests.PageActions.AutoCompleteComponent;
import FinalActivity.tests.stepDefinitions.Hooks;
import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class autoSuggestStepDef extends BaseTest {
    WebDriver driver;
    Hooks hooks;

        AutoCompleteComponent AutoSuggest = new AutoCompleteComponent();

    @Test
    @Given("I am in the DEMO homepage for Auto Suggestion activity")
    public void goToHomePage() throws InterruptedException, IOException {
        AutoSuggest.goToHomePage();
    }
    @When("I navigated to the Auto Suggestion activity page")
    public void goToForm() throws InterruptedException, IOException {
        AutoSuggest.goToForm();
    }
    @And("verify that I can enter multiple color")
    public void multipleColorNames() throws InterruptedException, IOException {
        AutoSuggest.multipleColorNames();
    }
    @Then("I must be able to enter single color only")
    public void singleColorName() throws InterruptedException, IOException {
        AutoSuggest.singleColorName();
    }

    }




