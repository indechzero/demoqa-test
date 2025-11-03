package FinalActivity.tests.stepDefinitions.WidgetsAct;

import TestComponents.BaseTest;
import FinalActivity.tests.PageActions.SelectMenuComponent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class selectMenuStepDef extends BaseTest {

        SelectMenuComponent selectComponent = new SelectMenuComponent();

    @Test
    @Given("that I am in the DEMO homepage for Select Menu activity")
    public void goToHomePage() throws InterruptedException, IOException {
        selectComponent.goToHomePage();
    }
    @When("I navigated to the Select Menu activity page")
    public void goToSelectMenuPage() throws InterruptedException, IOException {
        selectComponent.goToSelectMenuPage();
    }

    @Then("I must be able to verify the value field")
    public void clickValueField() throws InterruptedException, IOException {

        selectComponent.clickValueField();
    }
    @And("I must be able to verify the one value field")
    public void clickOneValue() throws InterruptedException, IOException {

        selectComponent.clickOneValue();
    }
    @And("I must be able to verify the select one value field")
    public void clickSelectOneField() throws InterruptedException, IOException {

        selectComponent.clickSelectOneField();
    }
    @And("I must be able to verify the old style value field as functional")
    public void clickOldStyleField() throws InterruptedException, IOException {

        selectComponent.clickOldStyleField();
    }
    @And("I must be able to verify the multiple select value field")
    public void clickMultiSelectField() throws InterruptedException, IOException {

        selectComponent.clickMultiSelectField();
    }
    @And("I must be able to verify the standard multi select value field")
    public void clickStandardMultiSelect() throws InterruptedException, IOException {

        selectComponent.clickStandardMultiSelect();
    }

    @AfterClass
    public void tearDown()  {
        driver.quit();
    }
}
