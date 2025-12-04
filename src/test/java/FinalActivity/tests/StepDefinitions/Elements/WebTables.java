package FinalActivity.tests.StepDefinitions.Elements;

import TestComponents.BaseTest;
import FinalActivity.tests.PageActions.WebTableComponents;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class WebTables extends BaseTest {

    WebTableComponents webTable = new WebTableComponents();

    @Test
    @Given("that I am in the DEMO homepage for Web Tables activity")
    public void goToHomePage() throws InterruptedException, IOException {
        webTable.goToHomePage();
    }
    @When("I navigated to the Web Tables activity page")
    public void goToWebTablePage() throws InterruptedException, IOException {
        webTable.goToWebTablePage();
    }
    @Then("I must be able to add new row entry by entering firstname {string}, lastname {string}, email {string}, age {string}, salary {string}, department {string}")
    public void addNewRowEntry(String firstName, String lastName, String email, String age, String salary, String department) throws InterruptedException, IOException {
        webTable.addNewRowEntry(firstName, lastName, email, age, salary, department );
    }
    @And("edit the new row entry")
    public void editNewRowEntry() throws InterruptedException, IOException {
        webTable.editNewRowEntry();
    }
    @And("delete the new row entry")
    public void deleteNewRowEntry() throws InterruptedException, IOException {
        webTable.deleteNewRowEntry();

    }

    @AfterTest
    public void tearDown()  {
        driver.close();
    }

}
