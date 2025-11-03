package FinalActivity.tests.stepDefinitions.WidgetsAct;

import FinalActivity.tests.PageActions.DatePickerComponent;
import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class datePickerStepDef extends BaseTest {

    DatePickerComponent datePick = new DatePickerComponent();

    @Test
    @Given("I am in the DEMO homepage for Date Picker activity")
    public void goToHomePage() throws InterruptedException, IOException {
        datePick.goToHomePage();
    }

    @When("I navigated to the Date Picker activity page")
    public void goToDatePickerPage() throws InterruptedException, IOException {
        datePick.goToDatePickerPage();
    }

    @Then("I verify the Date Picker as functional by typing")
    public void typeDate() throws InterruptedException, IOException {
        datePick.typeDate();
    }

    @And("the Date Picker Selector must be functional")
    public void selectDate() throws InterruptedException, IOException {
        datePick.selectDate();

    }

}

