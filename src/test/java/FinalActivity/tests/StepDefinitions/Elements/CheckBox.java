package FinalActivity.tests.StepDefinitions.Elements;

import TestComponents.BaseTest;
import FinalActivity.tests.PageActions.CheckBoxComponent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckBox extends BaseTest {

        CheckBoxComponent chckBox = new CheckBoxComponent();
    @Test
    @Given("that I am in the DEMO homepage for Checkbox activity")
    public void goToHomePage() throws InterruptedException, IOException {
        chckBox.goToHomePage();
    }
    @When("I navigated to the Checkbox activity page")
    public void goToForm() throws InterruptedException, IOException {

        chckBox.goToForm();
    }
    @Then("I must be able to select all checkbox")
    public void selectAll() throws InterruptedException, IOException {

        chckBox.selectAll();
    }
    @And("verify all checkbox")
    public void CheckBoxTest() throws InterruptedException, IOException {

        chckBox.CheckBoxTest();
    }
    @And("validate the results")
    public void getResults() throws InterruptedException, IOException {

        chckBox.getResults();


    }
    @AfterClass
    public void tearDown()  {
        driver.quit();
    }

}